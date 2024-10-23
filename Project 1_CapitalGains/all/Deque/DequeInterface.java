package all.Deque;
import java.util.Iterator;

public interface DequeInterface<T> extends Iterable<T>{
    /** Adds a new entry to the front of back of this deque.
     * @param newEntry An object to be added.
     */
    public void addToFront(T newEntry);
    public void addToBack(T newEntry);

    /** Removes and returns the front or back entry of this deque.
     * @return The object at the front or back of the deque.
     */
    public T removeFront();
    public T removeBack();

    void addFirst(T item);

    void addLast(T item);

    T removeFirst();

    T removeLast();

    T getFirst();

    T getLast();

    /** Detects whether this deque is empty.
     * @return True if deque is empty, or false otherwise.
     */
    public boolean isEmpty();

    /** Returns the front or back entry's data.
     * @return Entry data for front of back node.
     */
    public T getFront();
    public T getBack();

    /* Removes all entries from this deque. */
    public void clear();

    int size();

    /** Creates iterators to iterate through deque.
     * @return Returns an iterator for use.
     */
    public Iterator<T> iterator(); // end iterator

}
