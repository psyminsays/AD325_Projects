package all.Deque;
import all.StockLedger.StockPurchase;

import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class LinkedDeque<T> implements DequeInterface<T> {
    private DLNode head;
    private DLNode tail;
    private int size;

    public abstract Iterator<StockPurchase> getIterator();

    // Node class for the doubly linked deque
    private class DLNode {
        private T data;
        private DLNode next;
        private DLNode prev;

        public DLNode(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public DLNode getNextNode() {
            return next;
        }

        public void setNextNode(DLNode next) {
            this.next = next;
        }

        public DLNode getPreviousNode() {
            return prev;
        }

        public void setPreviousNode(DLNode prev) {
            this.prev = prev;
        }
    }

    public LinkedDeque(String message) {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        DLNode newNode = new DLNode(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setNextNode(head);
            head.setPreviousNode(newNode);
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item) {
        DLNode newNode = new DLNode(item);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.setPreviousNode(tail);
            tail.setNextNode(newNode);
            tail = newNode;
        }
        size++;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T data = head.getData();
        head = head.getNextNode();
        if (head == null) {
            tail = null; // Deque is now empty
        } else {
            head.setPreviousNode(null);
        }
        size--;
        return data;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        T data = tail.getData();
        tail = tail.getPreviousNode();
        if (tail == null) {
            head = null; // Deque is now empty
        } else {
            tail.setNextNode(null);
        }
        size--;
        return data;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return head.getData();
    }

    @Override
    public T getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return tail.getData();
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorForLinkedList();
    }

    private class IteratorForLinkedList implements Iterator<T> {
        private DLNode current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.getData();
            current = current.getNextNode();
            return data;
        }
    }
}
