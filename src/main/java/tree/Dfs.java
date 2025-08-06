package tree;

public class Dfs {
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

        System.out.println("[PREORDER]");
        preOrderDfs(a);
        System.out.println();

        System.out.println("[INORDER]");
        inOrderDfs(a);
        System.out.println();
        
        System.out.println("[POSTORDER]");
        postOrderDfs(a);
        System.out.println();

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

    // 전위순회 
    public static void preOrderDfs(Node root){
        System.out.print(root.value+" ");
        Node left = root.left;
        Node right = root.right;
        if (left!=null){
            preOrderDfs(left);
        }
        if (right!=null){
            preOrderDfs(right);
        }
    }    
    
    // 중위순회 
    public static void inOrderDfs(Node root){
        Node left = root.left;
        Node right = root.right;
        if (left!=null){
            inOrderDfs(left);
        }
        System.out.print(root.value+" ");
        if (right!=null){
            inOrderDfs(right);
        }
    }    
    
    // 후위순회 
    public static void postOrderDfs(Node root){
        Node left = root.left;
        Node right = root.right;
        if (left!=null){
            postOrderDfs(left);
        }
        if (right!=null){
            postOrderDfs(right);
        }
        System.out.print(root.value+" ");
    }    
}
