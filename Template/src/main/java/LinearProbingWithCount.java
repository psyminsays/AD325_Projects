import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinearProbingWithCount<K, V> implements DictionaryInterface<K, V> {
    private static final int INITIAL_CAPACITY = 1009; // prime number for hash table size
    private static final double LOAD_FACTOR_THRESHOLD = 0.7; // Load factor threshold
    private static final int RESIZE_FACTOR = 2; // Resize factor when rehashing
    private int size;

    @SuppressWarnings("unchecked")
    private Entry<K, V>[] table; // Using array of Entry<K, V> objects

    // Dummy Entry used to mark deleted slots (instead of null, which can cause confusion)
    private static class Entry<K, V> {
        K key;
        V value;
        boolean isDeleted;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.isDeleted = false;
        }

        Entry(K key) {
            this.key = key;
            this.value = null;
            this.isDeleted = true;
        }
    }

    public LinearProbingWithCount() {
        this.table = (Entry<K, V>[]) new Entry[INITIAL_CAPACITY]; // Create the array with the right type
        this.size = 0;
    }

    @Override
    public V add(K key, V value) {
        // Resize if load factor exceeds threshold
        if (size >= table.length * LOAD_FACTOR_THRESHOLD) {
            resize(table.length * RESIZE_FACTOR);
        }

        int index = hash(key);
        while (table[index] != null && !table[index].key.equals(key) && !table[index].isDeleted) {
            index = (index + 1) % table.length;
        }

        if (table[index] != null && table[index].key.equals(key)) {
            V oldValue = table[index].value;
            table[index].value = value;
            return oldValue;
        }

        // If we find an empty or deleted slot
        if (table[index] == null || table[index].isDeleted) {
            table[index] = new Entry<>(key, value);
            size++;
        }

        return null;
    }

    @Override
    public V getValue(K key) {
        int index = hash(key);

        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].key.equals(key)) {
                return table[index].value;
            }
            index = (index + 1) % table.length;
        }

        return null;
    }

    @Override
    public V remove(K key) {
        int index = hash(key);

        while (table[index] != null) {
            if (!table[index].isDeleted && table[index].key.equals(key)) {
                V value = table[index].value;
                table[index] = new Entry<>(key); // Mark the slot as deleted
                size--;

                // Resize down if the table is too sparse
                if (size <= table.length / 4) {
                    resize(table.length / 2);
                }

                return value;
            }
            index = (index + 1) % table.length;
        }

        return null;
    }

    @Override
    public boolean contains(K key) {
        return getValue(key) != null;
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
        table = (Entry<K, V>[]) new Entry[INITIAL_CAPACITY]; // Reset table
        size = 0;
    }

    @Override
    public Iterator<K> getKeyIterator() {
        return new KeyIterator();
    }

    @Override
    public Iterator<V> getValueIterator() {
        return new ValueIterator();
    }

    private class KeyIterator implements Iterator<K> {
        private int currentIndex;

        KeyIterator() {
            currentIndex = 0;
            while (currentIndex < table.length && (table[currentIndex] == null || table[currentIndex].isDeleted)) {
                currentIndex++;
            }
        }

        @Override
        public boolean hasNext() {
            while (currentIndex < table.length && (table[currentIndex] == null || table[currentIndex].isDeleted)) {
                currentIndex++;
            }
            return currentIndex < table.length;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return table[currentIndex++].key;
        }
    }

    private class ValueIterator implements Iterator<V> {
        private int currentIndex;

        ValueIterator() {
            currentIndex = 0;
            while (currentIndex < table.length && (table[currentIndex] == null || table[currentIndex].isDeleted)) {
                currentIndex++;
            }
        }

        @Override
        public boolean hasNext() {
            while (currentIndex < table.length && (table[currentIndex] == null || table[currentIndex].isDeleted)) {
                currentIndex++;
            }
            return currentIndex < table.length;
        }

        @Override
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return table[currentIndex++].value;
        }
    }

    private int hash(K key) {
        if (key == null) {
            return 0; // Null keys handled as a special case
        }
        return key.hashCode() % table.length;
    }

    private void resize(int newCapacity) {
        Entry<K, V>[] oldTable = table;
        table = (Entry<K, V>[]) new Entry[newCapacity];
        size = 0;

        // Rehash all entries into the new table
        for (Entry<K, V> entry : oldTable) {
            if (entry != null && !entry.isDeleted) {
                add(entry.key, entry.value); // Re-add the entry
            }
        }
    }
}