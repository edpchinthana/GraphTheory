import java.util.*;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    List<Node> children = new ArrayList<>();

    public Node(){

    }

    public Node(int data){
        this.data = data;
    }

    public void setData(int data){
        this.data = data;
    }
}


class Tree {

    public Boolean addNode(Node Parent, Node Child){
        if(Parent.children.size()==0 || Child.children.size()==0){
            Parent.children.add(Child);
            Child.children.add(Parent);
            return true;
        }else{
            if(searchNode(Parent,Child,null)==null){
                Parent.children.add(Child);
                Child.children.add(Parent);
                return true;
            }else{
                return false;
            }
        }
    }

    public Node searchNode(Node Parent, Node Child, Node Head){
        if(Parent!=Child){
            Node Temp = null;
            for(int x=0;x<Parent.children.size();x++){
                Node Children = Parent.children.get(x);
                if(Head!=Children&&Temp==null){
                    Temp = searchNode(Parent.children.get(x),Child, Parent);
                }
            }
            return Temp;
        }else{
            return Parent;
        }
    }

    public void removeNode(Node root,Node Head){
        if (root != null) {
            for(int x=0;x<root.children.size();x++){
                if(root.children.get(x)!=Head){
                    removeNode(root.children.get(x),root);
                }
            }
            root.data=-1;
        }
    }
}
public class Main {

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        String s = input.nextLine();

        for(int i = 0;i < n;i++){
            String s1[] = input.nextLine().split(" ");

            int Cities = Integer.parseInt(s1[0]);
            int Roads = Integer.parseInt(s1[1]);
            long CostPerLib = Long.parseLong(s1[2]);
            long CostPerRoad = Long.parseLong(s1[3]);
            int answer = 0;
            long NumberOfPaths = 0;
            long NumberOfTrees = 0;

            int[][] n1 = new int[Roads][2];
            for(int x=0;x<Roads;x++){
                String s2[] = input.nextLine().split(" ");
                n1[x][0]=Integer.parseInt(s2[0]);
                n1[x][1]=Integer.parseInt(s2[1]);
            }

            //Calculations
            if(CostPerLib < CostPerRoad){
                System.out.println(CostPerLib * Cities);
            }else{

                Tree tree1 = new Tree();
                Node[] nodes = new Node[Cities];
                for(int x=0;x<Cities;x++){
                    nodes[x] = new Node();
                    nodes[x].setData(x);
                }

                for(int x=0;x<Roads;x++){
                    if(tree1.addNode(nodes[n1[x][0]-1],nodes[n1[x][1]-1])) {
                        NumberOfPaths++;
                    }
                }

                for(int x=0;x<Cities;x++){
                    if(nodes[x].data!=-1) {
                        tree1.removeNode(nodes[x],null);
                        NumberOfTrees++;
                    }
                }
                long ans1 = NumberOfPaths*CostPerRoad;
                long ans2 = (NumberOfTrees*CostPerLib)+ans1;
                System.out.println(ans2);
            }
        }
    }
}
