package all.SortedListPackage;

public class LinkedList<T> {

    private Node<T> head;

    // Node class for LinkedList
    public static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    // TNode class for Binary Search Tree (BST) with generic type
    public static class TNode<T> {
        T data;
        TNode<T> left, right;
        TNode(T data) {
            this.data = data;
            left = right = null;
        }
    }

    // Push a new node to the linked list
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    // Print the linked list
    public void printList() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Convert sorted linked list to a balanced BST
    public TNode<T> sortedListToBST() {
        return sortedListToBSTHelper(head);
    }

    private TNode<T> sortedListToBSTHelper(Node<T> head) {
        if (head == null) return null;

        // Find the middle element of the list (slow and fast pointer approach)
        Node<T> slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Now slow is at the middle node, create the tree node
        TNode<T> node = new TNode<>(slow.data);

        // If there is a left part, recursively build the left subtree
        if (prev != null) {
            prev.next = null; // Cut the list before the middle
            node.left = sortedListToBSTHelper(head);
        }

        // Recursively build the right subtree
        node.right = sortedListToBSTHelper(slow.next);

        return node;
    }

    // Pre-order traversal of the BST
    public void preOrder(TNode<T> root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }
}
