package all;

import all.SortedListPackage.LinkedList;

public class Driver {
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        // Create a sorted linked list (7->6->5->4->3->2->1)
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        // Print the given linked list
        System.out.println("Given Linked List:");
        llist.printList(); // Adjusted to not require a head parameter

        // Convert the linked list to a balanced binary search tree
        LinkedList.TNode root = llist.sortedListToBST();

        // Print the pre-order traversal of the constructed BST
        System.out.println("\nPre-Order Traversal of constructed BST:");
        llist.preOrder(root);
    }
}
