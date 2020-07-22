/*
	In this exmaple, we will find the lowest common ancestor in a binary tree
	Time complexity of finding LCA is O(n)
*/

class LCA{

	public static void main(String[]args){
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7); 


        Node lca = findLca(root, 4, 6);
        System.out.println("LCA of 4 and 6 is: "+lca.value);
     	lca = findLca(root, 3, 4);
        System.out.println("LCA of 3 and 4 is: "+lca.value);
        lca = findLca(root, 4, 5);
        System.out.println("LCA of 4 and 5 is: "+lca.value);
           
	}

	private static Node findLca(Node root, int n1, int n2){
		if (root==null) {
			return root;
		}

		if (root.value == n1 || root.value == n2) {
			return root;
		}

		Node leftLca = findLca(root.left, n1, n2);
		Node rightLca = findLca(root.right, n1, n2);

		/*
		If both of the above calls return Non-NULL, then one key 
        is present in once subtree and other is present in other, 
        So this node is the LCA
        */ 
		if (leftLca!=null && rightLca!=null){
			return root;
		} 

		return (leftLca != null) ? leftLca : rightLca; 

	}
}

class Node{
	int value; 
    Node left, right; 
  
    Node(int value) { 
        this.value = value; 
        left = right = null; 
    } 
}