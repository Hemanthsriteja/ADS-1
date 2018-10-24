/**.
 * Class for searchtable.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class Searchtable <Key extends Comparable<Key>, Value> {
    /**.
     * { variable capacity }.
     */
    private static final int newcap = 2;
    /**.
     * { key array of type Key }
     */
    private Key[] keys;
    /**.
     * { val array of type value }.
     */
    private Value[] values;
    /**
     * { variable n of type integer }.
     */
    private int n = 0;
    /**.
     * Constructs the object for searchtable.
     */
    Searchtable() {
        this(newcap);
    }
    /**.
     * Constructs the object for searchtable.
     *
     * @param      capacity  The capacity
     */
    public Searchtable(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }
    /**
     * { gives size of array }.
     * The time complexity is constant because
     * the statment executes only once.
     * @return  returns size of array.
     */
    public int size() {
        return n;
    }
    /**
     * Determines if empty.
     * The time complexity is constant because
     * the statment executes only once.
     * @return    returns true if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**.
     * The time complexity is O(N) as it iterates for N times.
     *
     * @param      capacity  The capacity
     */
    private void resize(int capacity) {
        assert capacity >= n;
        Key[]   tempk = (Key[])   new Comparable[capacity];
        Value[] tempv = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }
    /**
     * { checks whether the key is present int the array }.
     *
     * @param      keys  The keys
     *
     * @return  returns true if key is present otherwise false.
     */
    public boolean contains(Key k) {
        return (get(k) != null);
    }
    /**
     * { gets the value of key }.
     *
     * @param      keys  The keys
     *
     * @return  returns value of the given key.
     */
    public Value get(Key k) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(k);
        if (i < n && keys[i].compareTo(k) == 0) {
            return values[i];
        }
        return null;
    }
    /**
     * { gives the rank }.
     *
     * @param      keys  The keys
     *
     * @return   returns index lo.
     */
    public int rank(Key k) {
        int lo = 0, hi = n-1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = k.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
    /**
     * { updates the value of key }.
     *
     * @param      keys  The keys
     * @param      val  The val
     */
    public void put(Key key, Value val)  {
        if (val == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        // key is already in table
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = val;
            return;
        }
        // insert new key-value pair
        if (n == keys.length) {
            resize(2*keys.length);
        }
        for (int j = n; j > i; j--)  {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = val;
        n++;

        assert check();
    }
    /**
     * { deletes the key }.
     *
     * @param      keys  The keys
     */
    public void delete(Key key) {
        if (isEmpty()) {
            return;
        }
        // compute rank
        int i = rank(key);
        // key not in table
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }
        n--;
        keys[n] = null;  // to avoid loitering
        values[n] = null;
        // resize if 1/4 full
        if (n > 0 && n == keys.length/4) {
            resize(keys.length/2);
        }
        assert check();
    }
     public Key select(int k) {
        return keys[k];
    }
    /**.
     * deletes min key in array
     */
    public void deleteMin() {
        delete(min());
    }
    /**.
     * delete max key in array
     */
    public void deleteMax() {
        delete(max());
    }
    /**.
     * finds min key
     */
    public Key min() {
        return keys[0];
    }
    /**.
     * finds max key
     */
    public Key max() {
        return keys[n-1];
    }
     private boolean check() {
        return isSorted() && rankCheck();
    }

    // are the items in the array in ascending order?
    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (keys[i].compareTo(keys[i-1]) < 0) return false;
        return true;
    }

    // check that rank(select(i)) = i
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++) {
            if (i != rank(select(i))) {
                return false;
            }
        }
        for (int i = 0; i < size(); i++) {
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * floor method
     *
     * @param      keys  The keys
     *
     * @return  returns key value.
     */
    public Key floor(Key key) {
        int i = rank(key);
        if (i < n && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keys[i-1];
        }
    }
     public void keys() {
        for(int i = 0;i< n;i++) {
            System.out.println(keys[i] + " " + values[i]);
        }
    }

}