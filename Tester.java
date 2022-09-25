package project3package;

public class Tester {

	static BinarySearchTree binaryTree;
	
	public static void main(String[] args) {
		Tester test = new Tester();
		System.out.println("THE TESTER IS NOW CREATING A BINARY SEARCH TREE.");
		System.out.println("");
		System.out.println("THE TREE IS BELOW.");
		int[] keys = {35, 69, 12, 34, 9, 75, 23, 42, 1};
		binaryTree = new BinarySearchTree(keys);
		System.out.println(binaryTree);
		System.out.println("");
		System.out.println("TESTING THE INSERT METHOD. ADDING 5.");
		binaryTree.insert(5);
		System.out.println(binaryTree);
		System.out.println("");
		System.out.println("ADDING 10.");
		System.out.println(binaryTree);
		System.out.println("");
		System.out.println("TESTING SUM METHOD.");
		System.out.println("The sum of the tree is " + binaryTree.sum() + ".");
		System.out.println("");
		System.out.println("TESTING THE SEARCH METHOD.");
		binaryTree.search(35);
		binaryTree.search(69);
		binaryTree.search(1);
		binaryTree.search(100);
		System.out.println("");
		System.out.println("TESTING THE kTH SMALLEST METHOD.");
		System.out.println("The 5th smallest value in the tree is " + binaryTree.kthSmallest(5));
		System.out.println("");
		System.out.println("TESTING THE INORDER METHOD.");
		test.testInorder();
		System.out.println("");
		System.out.println("TESTING THE DELETE METHOD. 69 WILL BE DELETED.");
		System.out.println("");
		System.out.println("THE TREE BEFORE:");
		System.out.println(binaryTree);
		System.out.println("");
		System.out.println("THE TREE AFTER:");
		binaryTree.delete(69);
		System.out.println(binaryTree);
		System.out.println("");
		System.out.println("THE TESTS ARE NOW COMPLETE.");
	}
	
	public void testInorder() {
		int[] trav = binaryTree.inorder();
		for (int i : trav) {
			System.out.print(i + " ");
		}
		System.out.println();
	}


}
