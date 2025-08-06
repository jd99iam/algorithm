package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Bfs {
    public static void main(String[] args) {

        // 트리 구성 
        Node a = new Node("a");
        Node b = new Node("b");
        Node c = new Node("c");
        Node d = new Node("d");
        Node e = new Node("e");
        Node f = new Node("f");
        Node g = new Node("g");
        Node h = new Node("h");

        a.left = b; 
        a.right = c;
        b.left = d; 
        b.right = e;
        d.left = g;
        d.right = h;
        c.right = f;


        // bfs 
        List<Node> visited = bfs(a);
        for (Node node : visited){
            System.out.println(node.value);
        }


    }

    // 이진 트리 노드 
    public static class Node {
        public String value;
        public Node left; 
        public Node right; 

        public Node(String value){
            this.value = value;
        }

    }

    public static List<Node> bfs(Node node){
        
        List<Node> visited = new ArrayList<>();
        ArrayDeque<Node> queue = new ArrayDeque<>();

        queue.offer(node);

        while (!queue.isEmpty()){
            Node current = queue.poll();

            visited.add(current);

            Node left = current.left;
            Node right = current.right;

            if (left!=null){
                queue.offer(left);
            }
            if (right!=null){
                queue.offer(right);
            }

        }

        return visited;
    }
}
