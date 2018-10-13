/**.
 * { item_description }
 */
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**.
 * Class for maximum pq.
 *
 * @param      <Key>  The key
 */
public class MaxPQ<Key> implements Iterable<Key> {
    private Key[] pq;
    private int n;
    private Comparator<Key> comparator;

    /**
     * Constructs the object.
     *
     * @param      initCapacity  The initialize capacity
     */
    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    public MaxPQ() {
        this(1);
    }

    /**.
     * Constructs the object.
     *
     * @param      initCapacity  The initialize capacity
     * @param      comparator    The comparator
     */
    public MaxPQ(int initCapacity, Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**.
     * Constructs the object.
     *
     * @param      comparator  The comparator
     */
    public MaxPQ(Comparator<Key> comparator) {
        this(1, comparator);
    }

    /**.
     * Constructs the object.
     *
     * @param      keys  The keys
     */
    public MaxPQ(Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++)
            pq[i+1] = keys[i];
        for (int k = n/2; k >= 1; k--)
            sink(k);
        assert isMaxHeap();
    }



    /**.
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return n;
    }

    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Key max() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        return pq[1];
    }
    private void resize(int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }
    /**.
     * { function_description }
     *
     * @param      x     { parameter_description }
     */
    public void insert(Key x) {

        // double size of array if necessary
        if (n == pq.length - 1) resize(2 * pq.length);

        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
        assert isMaxHeap();
    }

    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Key delMax() {
        if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n+1] = null;     // to avoid loiterig and help with garbage collection
        if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
        assert isMaxHeap();
        return max;
    }
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     */
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     */
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    /**.
     * { function_description }
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    private boolean less(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }
    /**.
     * { function_description }
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    private void exch(int i, int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    /**.
     * Determines if maximum heap.
     *
     * @return     True if maximum heap, False otherwise.
     */
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    /**.
     * Determines if maximum heap.
     *
     * @param      k     { parameter_description }
     *
     * @return     True if maximum heap, False otherwise.
     */
    private boolean isMaxHeap(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && less(k, left))  return false;
        if (right <= n && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right);
    }
    public Iterator<Key> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<Key> {
        private MaxPQ<Key> copy;
        public HeapIterator() {
            if (comparator == null) copy = new MaxPQ<Key>(size());
            else                    copy = new MaxPQ<Key>(size(), comparator);
            for (int i = 1; i <= n; i++)
                copy.insert(pq[i]);
        }
        public boolean hasNext()  { return !copy.isEmpty();                     }
        public void remove()      { throw new UnsupportedOperationException();  }
        public Key next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.delMax();
        }
    }
}