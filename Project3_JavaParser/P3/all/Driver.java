package all;

import all.SortedListPackage.LinkedList;

/* Driver program to test above functions */
public class Driver (String[] args) {
    LinkedList llist = new LinkedList();
 
        /* Let us create a sorted linked list to test the functions
           Created linked list will be 7->6->5->4->3->2->1 */
    llist.push(7);
    llist.push(6);
    llist.push(5);
    llist.push(4);
    llist.push(3);
    llist.push(2);
    llist.push(1);

    System.out.println("Given Linked List ");
    llist.printList(head);

    /* Convert List to BST */
    LinkedList.TNode root = llist.sortedListToBST();
    System.out.println("");
    System.out.println("Pre-Order Traversal of constructed BST ");
    llist.preOrder(root);
}