package dfs_shortestpath;

import java.util.*;

public class DFS_ShortestPath {
static Vector<String > InputValue= new Vector<>();
static Vector<Integer> PathCost = new Vector<>();
static class Node
{
    String key;
    int weight;
    ArrayList<Node> child_node = new ArrayList<>();
 
    public Node(String key, int weight)
    {
        this.key = key;
        this.weight = weight;
        
    }
};
 
static void traverse_tree(Node root)
{
    Stack<Node> nodes = new Stack<>();
    nodes.push(root);
    while (!nodes.isEmpty())
    {
        Node curr = nodes.pop();

        if (curr != null)
        {
            if(curr.key.contains("I")){        
                String s = "";
                for(int i = curr.key.length() - 1; i>=0; i--){
                    s += curr.key.charAt(i);
                }
                InputValue.add(s + curr.weight);
            }
            for(int i = curr.child_node.size() - 1; i >= 0; i--)
            {
                curr.child_node.get(i).key += curr.key;
                curr.child_node.get(i).weight += curr.weight;
                nodes.add(curr.child_node.get(i));
            }
        }
    }
    for(String s:InputValue){
        int indexOfI = s.indexOf("I");
        String sb = s.substring(indexOfI + 1, s.length());
        int totalCost = Integer.parseInt(sb);
        PathCost.add(totalCost);
    }
    int min = PathCost.get(0);
    for(int i = 1; i < PathCost.size(); i++){
        if(min > PathCost.get(i)){ min = PathCost.get(i);}
    }
    for(String s : InputValue){
        if(s.contains(Integer.toString(min))){
           System.out.println(s);
        }
    }
    
}

public static void main(String[] args)
{
 
    Node root = new Node("A", 0);
    (root.child_node).add(new Node("B", 6));
    (root.child_node).add(new Node("C", 9));
    (root.child_node).add(new Node("D", 11));
    (root.child_node.get(0).child_node).add(new Node("E", 8));
    (root.child_node.get(1).child_node).add(new Node("F", 19));
    (root.child_node.get(1).child_node.get(0).child_node).add(new Node("I", 4));
    (root.child_node.get(1).child_node).add(new Node("G", 10));
    (root.child_node.get(2).child_node).add(new Node("H", 12));
    (root.child_node.get(2).child_node.get(0).child_node).add(new Node("I", 7));
    (root.child_node.get(2).child_node.get(0).child_node).add(new Node("J", 9));
    
     System.out.print("DFS Shortest Path is: ");
    traverse_tree(root);
}
}
