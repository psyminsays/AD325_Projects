package all.Deque;

import java.util.Iterator;

/**
 * Exception thrown when an operation is attempted on an empty queue.
 */
public abstract class EmptyQueueException extends LinkedDeque {
    /**
     * Constructs a new EmptyQueueException with the specified detail message.
     *
     * @param message the detail message.
     */
    public EmptyQueueException(String message) {
        super(message);
    }

    /**
     * Adds a new entry to the front of back of this deque.
     *
     * @param newEntry An object to be added.
     */
    @Override
    public void addToFront(Object newEntry) {

    }

    /**
     * @param newEntry
     */
    @Override
    public void addToBack(Object newEntry) {

    }

    /**
     * Removes and returns the front or back entry of this deque.
     *
     * @return The object at the front or back of the deque.
     */
    @Override
    public Object removeFront() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public Object removeBack() {
        return null;
    }

    /**
     * Returns the front or back entry's data.
     *
     * @return Entry data for front of back node.
     */
    @Override
    public Object getFront() {
        return null;
    }

    /**
     * @return get back of the node.
     */
    @Override
    public Object getBack() {
        return null;
    }

    /**
     * Clear the queue
     */
    @Override
    public void clear() {

    }

    /**
     * @return returns the LinkedDeque
     */
    @Override
    public Iterator getIterator() {
        return null;
    }
}
