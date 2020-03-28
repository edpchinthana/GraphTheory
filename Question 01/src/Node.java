import java.util.ArrayList;
import java.util.List;

public class Node {
    int data;
    List<Node> children = new ArrayList<>();

    public Node(){

    }

    public Node(int data){
        this.data = data;
    }
}
