package all.TreePackage;

import java.util.Iterator;

public class Main {
    public static void main(String[] args)

    {
        BinaryTree<String> aTree = new BinaryTree<>();
        createTree1(aTree);
        showTreeStats(aTree, "A", 3, 7);
        testTraversals(aTree, "A B D E C F G", "D B E A F C G", "D E B F G C A", "A B C D E F G");

        aTree.clear();
        createTree2(aTree);
        showTreeStats(aTree, "A", 3, 6);
        testTraversals(aTree, "A B E C F G", "B E A F C G", "E B F G C A", "A B C E F G");

        aTree.clear();
        createTree3(aTree);
        showTreeStats(aTree, "A", 4, 7);
        testTraversals(aTree, "A B D E C F G", "D B E A F G C", "D E B G F C A", "A B C D E F G");
        aTree.clear();
        createTree4(aTree);
        showTreeStats(aTree, "A", 4, 8);
        testTraversals(aTree, "A B D H E C F G", "D H B E A F C G", "H D E B F G C A", "A B C D E F G H");

        aTree.clear();
        createTree5(aTree);
        showTreeStats(aTree, "A", 4, 8);
        testTraversals(aTree, "A B D E H C F G", "D B E H A F C G", "D H E B F G C A", "A B C D E F G H");

        aTree.clear();
        createTree6(aTree);
        showTreeStats(aTree, "A", 4, 8);
        testTraversals(aTree, "A B D E F G C H", "D B F E G A C H", "D F G E B H C A", "A B C D E H F G");

        aTree.clear();
        createTree7(aTree);
        showTreeStats(aTree, "A", 4, 11);
        testTraversals(aTree, "A B D E F G B D E F G", "D B F E G A D B F E G", "D F G E B D F G E B A", "A B B D E D E F G F G");

        testEmptyTree();

        TestSeg2421(); // Test the code in Segment 24.21 of Chapter 24

        System.out.println("Done.");
    }  // end main

    /** Tests the 4 traversals of a given binary tree. */
    public static void testTraversals(BinaryTree<String> aTree, String preorder,
                                      String inorder, String postorder, String levelOrder)
    {
        testPreorder(aTree,   preorder);
        testInorder(aTree,    inorder);
        testPostorder(aTree,  postorder);
        testLevelOrder(aTree, levelOrder);
    } // end testTraversals

    /** Precondition: tree is empty but not null. */
    public static void createTree1(BinaryTree<String> tree)
    {
        // Leaves
        BinaryTree<String> dTree = new BinaryTree<>("D");
        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> gTree = new BinaryTree<>("G");

        // Subtrees:
        BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
        BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

        tree.setTree("A", bTree, cTree);

        System.out.println("\nTree 1:\n");
        System.out.println("     A      ");
        System.out.println("   /   \\   "); // '\\' is the escape character for backslash
        System.out.println("  B     C   ");
        System.out.println(" / \\   / \\");
        System.out.println("D   E  F  G ");
        System.out.println();
    } // end createTree1

    public static void createTree2(BinaryTree<String> tree) //  B has no left child
    {
        // Leaves
        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> gTree = new BinaryTree<>("G");

        // Subtrees:
        BinaryTree<String> bTree = new BinaryTree<>("B", null, eTree);
        BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

        tree.setTree("A", bTree, cTree);

        System.out.println("\nTree 2:\n");
        System.out.println("     A      ");
        System.out.println("   /   \\   ");
        System.out.println("  B     C   ");
        System.out.println("   \\   / \\");
        System.out.println("    E  F  G ");
        System.out.println();
    } // end createTree2

    public static void createTree3(BinaryTree<String> tree)
    {
        // Leaves
        BinaryTree<String> dTree = new BinaryTree<>("D");
        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> gTree = new BinaryTree<>("G");

        // Subtrees:
        BinaryTree<String> fTree = new BinaryTree<>("F", null, gTree);
        BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
        BinaryTree<String> cTree = new BinaryTree<>("C", fTree, null);

        tree.setTree("A", bTree, cTree);

        System.out.println("\nTree 3:\n");
        System.out.println("     A      ");
        System.out.println("   /   \\  ");
        System.out.println("  B     C  ");
        System.out.println(" / \\   /  ");
        System.out.println("D   E  F   ");
        System.out.println("        \\ ");
        System.out.println("         G ");
        System.out.println();
    } // end createTree3

    public static void createTree4(BinaryTree<String> tree) //  D has H as right child
    {
        // Leaves
        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> gTree = new BinaryTree<>("G");
        BinaryTree<String> hTree = new BinaryTree<>("H");

        // Subtrees:
        BinaryTree<String> dTree = new BinaryTree<>("D", null, hTree);
        BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
        BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

        tree.setTree("A", bTree, cTree);

        System.out.println("\nTree 4:\n");
        System.out.println("     A      ");
        System.out.println("   /   \\   ");
        System.out.println("  B     C   ");
        System.out.println(" / \\   / \\");
        System.out.println("D   E  F  G ");
        System.out.println(" \\         ");
        System.out.println("  H         ");
        System.out.println();
    } // end createTree4

    public static void createTree5(BinaryTree<String> tree)
    {
        // Leaves
        BinaryTree<String> dTree = new BinaryTree<>("D");
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> gTree = new BinaryTree<>("G");
        BinaryTree<String> hTree = new BinaryTree<>("H");
        BinaryTree<String> emptyTree = new BinaryTree<>();

        // Subtrees:
        BinaryTree<String> eTree = new BinaryTree<>("E", emptyTree, hTree);
        BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
        BinaryTree<String> cTree = new BinaryTree<>("C", fTree, gTree);

        tree.setTree("A", bTree, cTree);

        System.out.println("\nTree 5:\n");
        System.out.println("     A      ");
        System.out.println("   /   \\   ");
        System.out.println("  B     C   ");
        System.out.println(" / \\   / \\");
        System.out.println("D   E  F  G ");
        System.out.println("     \\     ");
        System.out.println("      H     ");
        System.out.println();
    } // end createTree5

    public static void createTree6(BinaryTree<String> tree)
    {
        // Leaves:
        BinaryTree<String> dTree = new BinaryTree<>();
        dTree.setTree("D", null, null);
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> gTree = new BinaryTree<>("G");
        BinaryTree<String> hTree = new BinaryTree<>("H");
        BinaryTree<String> emptyTree = new BinaryTree<>();

        // Subtrees:
        BinaryTree<String> eTree = new BinaryTree<>();
        eTree.setTree("E", fTree, gTree);
        BinaryTree<String> bTree = new BinaryTree<>();
        bTree.setTree("B", dTree, eTree);
        BinaryTree<String> cTree = new BinaryTree<>("C", emptyTree, hTree);

        tree.setTree("A", bTree, cTree);

        System.out.println("\nTree 6:\n");  // Fig. 24-13
        System.out.println("     A      ");
        System.out.println("   /   \\   ");
        System.out.println("  B     C   ");
        System.out.println(" / \\     \\");
        System.out.println("D   E     H ");
        System.out.println("   / \\     ");
        System.out.println("  F   G     ");
        System.out.println();
    } // end createTree6

    public static void createTree7(BinaryTree<String> tree)
    {
        // Leaves:
        BinaryTree<String> dTree = new BinaryTree<>("D");
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> gTree = new BinaryTree<>("G");

        // Subtrees:
        BinaryTree<String> eTree = new BinaryTree<>("E", fTree, gTree);
        BinaryTree<String> bTree = new BinaryTree<>("B", dTree, eTree);
        tree.setTree("A", bTree, bTree);

        System.out.println("\nTree 7:\n");
        System.out.println("     A      ");
        System.out.println("   /   \\     ");
        System.out.println("  B     B     ");
        System.out.println(" / \\   / \\  ");
        System.out.println("D   E D   E   ");
        System.out.println("   / \\   / \\");
        System.out.println("  F   G F   G ");
        System.out.println();
    } // end createTree7

    public static void showTreeStats(BinaryTree<String> tree, String root, int height, int numberOfNodes)
    {
        if (tree.isEmpty())
            System.out.println("The tree is empty");
        else
            System.out.println("The tree is not empty");

        System.out.println("Root of tree is " + tree.getRootData() + "; s/b " + root);

        System.out.println("Height of tree is " + tree.getHeight() + "; s/b " + height);

        System.out.println("# nodes in tree is " + tree.getNumberOfNodes() + "; s/b " + numberOfNodes);
    } // end showTreeStats

    public static void testLevelOrder(BinaryTree<String> tree, String answer)
    {
        System.out.println("\nLevel order:");
        System.out.println(answer + "  Expected");

        Iterator<String> levelOrder = tree.getLevelOrderIterator();

        while (levelOrder.hasNext())
        {
            System.out.print(levelOrder.next() + " ");
        } // end while

        System.out.println(" Actual using LevelOrderIterator\n---------------");
    } // end testLevelOrder

    public static void testPreorder(BinaryTree<String> tree, String answer)
    {
        System.out.println("\nPreorder:");
        System.out.println(answer + "  Expected");

        Iterator<String> preorder = tree.getPreorderIterator();

        while (preorder.hasNext())
        {
            System.out.print(preorder.next() + " ");
        } // end while

        System.out.println(" Actual using PreorderIterator");
        tree.iterativePreorderTraverse();
        System.out.println(" Actual using iterativePreorderTraverse");
        System.out.println("---------------");
    } // end testPreorder

    public static void testInorder(BinaryTree<String> tree, String answer)
    {
        System.out.println("\nInorder:");
        System.out.println(answer + "  Expected");

        Iterator<String> inorder = tree.getInorderIterator();

        while (inorder.hasNext())
        {
            System.out.print(inorder.next() + " ");
        } // end while

        System.out.println(" Actual using InorderIterator");

        tree.iterativeInorderTraverse();
        System.out.println(" Actual using iterativeInorderTraverse");
        System.out.println("---------------");
    } // end testInorder

    public static void testPostorder(BinaryTree<String> tree, String answer)
    {
        System.out.println("\nPostOrder:");
        System.out.println(answer + "  Expected");

        Iterator<String> postorder = tree.getPostorderIterator();

        while (postorder.hasNext())
        {
            System.out.print(postorder.next() + " ");
        } // end while

        System.out.println(" Actual using PostorderIterator\n---------------");
    } // end testPostorder

    public static void testEmptyTree()
    {
        System.out.println("\nTest empty tree:");
        BinaryTree<String> myTree = new BinaryTree<>();
        // myTree.root is null, so myTree is empty, not null

        System.out.println("myTree is not null--CORRECT.");

        if (myTree.isEmpty())
            System.out.println("myTree is empty--CORRECT.");
        else {
            System.out.println("myTree.root is not empty--ERROR");
        }
        System.out.println();
    } // end testEmptyTree

    /** Tests the code in Segment 24.21. */
    public static void TestSeg2421()
    {
        System.out.println("Testing code in Segment 24.21:");

        // Represent each leaf as a one-node tree
        BinaryTreeInterface<String> dTree = new BinaryTree<>();
        dTree.setTree("D", null, null);

        BinaryTreeInterface<String> fTree = new BinaryTree<>();
        fTree.setTree("F", null, null);

        BinaryTreeInterface<String> gTree = new BinaryTree<>();
        gTree.setTree("G", null, null);

        BinaryTreeInterface<String> hTree = new BinaryTree<>();
        hTree.setTree("H", null, null);

        BinaryTreeInterface<String> emptyTree = new BinaryTree<>();

        // Form larger subtrees
        BinaryTreeInterface<String> eTree = new BinaryTree<>();
        eTree.setTree("E", fTree, gTree); // Subtree rooted at E

        BinaryTreeInterface<String> bTree = new BinaryTree<>();
        bTree.setTree("B", dTree, eTree); // Subtree rooted at B

        BinaryTreeInterface<String> cTree = new BinaryTree<>();
        cTree.setTree("C", emptyTree, hTree); // Subtree rooted at C

        BinaryTreeInterface<String> aTree = new BinaryTree<>();
        aTree.setTree("A", bTree, cTree); // Desired tree rooted at A

        // Display root, height, number of nodes
        System.out.printf("Root of tree contains %s%n", aTree.getRootData());
        System.out.printf("Height of tree is %d%n", aTree.getHeight());
        System.out.printf("Tree has %d nodes%n", aTree.getNumberOfNodes());

        // Display nodes in preorder
        System.out.println("A preorder traversal visits nodes in this order:");
        Iterator<String> preorder = aTree.getPreorderIterator();
        while (preorder.hasNext())
            System.out.printf("%s ", preorder.next());
        System.out.println();
    } // end TestSeg2421
}
