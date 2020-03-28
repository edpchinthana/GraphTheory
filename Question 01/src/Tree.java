public class Tree {

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
                if(Head!=Children){
                    Temp = searchNode(Parent.children.get(x),Child, Parent);
                }
            }
            return Temp;
        }else{
            return Parent;
        }
    }
}
