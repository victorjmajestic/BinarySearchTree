package project3package;

public class BinarySearchTree {
	class Node { 
		private int key;
		private Node left;
		private Node right;  

		public Node(int key) { 
	        this.key = key;
	        left = right = null;
	    }
		
		public String toString() {
			return "" + key;
		}
	}
	
	private Node root;
	private int treeSize = 0;
	private int option;
	
	
	public BinarySearchTree(int key) { 
		root = new Node(key);
	}
	
	public BinarySearchTree(int[] keys) { 
		for(int k : keys) {  
			insert(k);
		}
	}
	
	public void insert(int key) { 
		insert(root, key);
		treeSize++;
	}
	
	private Node insert(Node root, int key) { 
		Node parent = null;
		Node trav = root;
		
		while (trav != null) { 
			parent = trav;
			if (key < trav.key) 
				trav = trav.left;
			else 
				trav = trav.right;
		}
		
		if (parent == null) { 
			return this.root = new Node(key);
		} else if (key < parent.key) { 
			return parent.left = new Node(key);
		} else { 
			return parent.right = new Node(key);
		}
		
	}
	
	public void search(int key) { 
		Node[] node = search(new Node[] {root, null}, key);
		if (option == 1)
			System.out.println("The tree is empty or the key " + key + " does not exist.");
		if (option == 2)
			System.out.println("The node with key " + key + " is the root of the tree.");
		if (option == 3)
			System.out.println("The node with key " + key + " is to the right of the node with key " + node[1]);
		if (option == 4)
			System.out.println("The node with key " + key + " is to the left of the node with key " + node[1]);
	}
	
	public Node[] search(Node node[], int key) {
		if (node[0] == null) {
			option = 1;
			return null;
		}
		if (node[0].key == key) {
			option = 2;
			return node;
		}
		if (node[0].key < key) {
			option = 3;
			return search(new Node[] {node[0].right, node[0]}, key);
		}
		else {
			option = 4;
			return search(new Node[] {node[0].left, node[0]}, key);
		}
	}
	
	private int count;
	private int[] inOrderTree;
	public int[] inorder() {
		inOrderTree = new int[treeSize];
		count = 0;
		inorder(root);
		return inOrderTree;
	}
	private void inorder(Node root) { 
		if (root != null) { 
			inorder(root.left); 
			inOrderTree[count] = root.key; 
			count++;
			inorder(root.right); 
		}
	}
	
	public int sum() { 
		int sum = 0;
		inorder();
		for (int i : inOrderTree) {
			sum += i;
		}
		return sum;
	}
	
	public int kthSmallest(int k) {
		inorder();	
		return inOrderTree[k-1];
	}
	
	public void delete(int key){
		delete(root, key);
		treeSize--;
	}
	private void delete(Node root, int key) {
        Node parent = null;
        Node trav = root;

        while (trav != null && trav.key != key) { 
            parent = trav;
            if (key < trav.key)
                trav = trav.left;
            else
                trav = trav.right;
        }
       
        if (trav == null) { 
            treeSize++; 
        } else {  
            deleteNode(trav, parent);
        }
    }
	
	private void deleteNode(Node toDelete, Node parent) {
		if (toDelete.left == null || toDelete.right == null) { 
			Node toDeleteChild = null;
			if (toDelete.left != null)
				toDeleteChild = toDelete.left;
			else
				toDeleteChild = toDelete.right;
			if (toDelete == root)
				root = toDeleteChild;
			else if (toDelete.key < parent.key)
				parent.left = toDeleteChild;
			else
				parent.right = toDeleteChild;
		} else { 
			Node replacementParent = toDelete;
			Node replacement = toDelete.right;
			while (replacement.left != null) {
				replacementParent = replacement;
				replacement = replacement.left;
			}
			deleteNode(replacement, replacementParent);
		}
	}
			
	public String toString() { 
		String str = "{";
		inorder();
		for (int i : inOrderTree) {
			str += " " + i;
		}
		return str += " }";
	}
}