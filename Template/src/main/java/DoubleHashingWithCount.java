import java.util.Iterator;
import java.util.LinkedList;

public class DoubleHashingWithCount<K, V> implements DictionaryInterface<K, V> {
    private static final int INITIAL_CAPACITY = 300;  // Size based on earlier calculation (for ~1.5 comparisons)
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public DoubleHashingWithCount() {
        table = new LinkedList[INITIAL_CAPACITY];
        size = 0;
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();  // Initialize each LinkedList to store entries
        }
    }

    @Override
    public V add(K key, V value) {
        int index = hash1(key);
        int step = hash2(key);
        int initialIndex = index;

        // Traverse the table using double hashing to handle collisions
        while (!table[index].isEmpty()) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    V oldValue = entry.value;
                    entry.value = value;
                    return oldValue;  // Replace and return the old value
                }
            }
            index = (index + step) % table.length;
            if (index == initialIndex) break;  // If we circle back, the table is full
        }

        // Add the entry at the first empty slot
        table[index].add(new Entry<>(key, value));
        size++;
        return null;
    }

    @Override
    public V remove(K key) {
        int index = hash1(key);
        int step = hash2(key);
        int initialIndex = index;

        // Traverse to find the key to remove
        while (!table[index].isEmpty()) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return entry.value;
                }
            }
            index = (index + step) % table.length;
            if (index == initialIndex) break;
        }
        return null;
    }

    @Override
    public V getValue(K key) {
        int index = hash1(key);
        int step = hash2(key);
        int initialIndex = index;

        // Traverse the table using double hashing to find the value
        while (!table[index].isEmpty()) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.key.equals(key)) {
                    return entry.value;
                }
            }
            index = (index + step) % table.length;
            if (index == initialIndex) break;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getValue(key) != null;
    }

    @Override
    public Iterator<K> getKeyIterator() {
        return null;  // Not implemented for simplicity
    }

    @Override
    public Iterator<V> getValueIterator() {
        return null;  // Not implemented for simplicity
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void clear() {
        table = new LinkedList[INITIAL_CAPACITY];  // Re-initialize the table
        size = 0;
        for (int i = 0; i < table.length; i++) {
            table[i] = new LinkedList<>();  // Re-initialize each LinkedList
        }
    }

    // Hash functions
    private int hash1(K key) {
        return Math.abs(key.hashCode()) % table.length;
    }

    private int hash2(K key) {
        return 1 + (Math.abs(key.hashCode()) % (table.length - 1));
    }
}
