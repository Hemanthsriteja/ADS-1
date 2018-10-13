/**.
 * Class for binary search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
public class BinarySearchST <Key extends Comparable<Key>, Value> {
    private static final int newcap = 2;
    private Key[] keys;
    private Value[] values;
    private int n = 0;
    /**.
     * Constructs the object.
     */
    BinarySearchST() {
        this(newcap);
    }
    /**.
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }
    public int size() {
        return n;
    }
    /**.
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
    /**.
     * { function_description }
     *
     * @param      capacity  The capacity
     */
    private void resize(int capacity) {
        assert capacity >= n;
        Key[]   tempkey = (Key[])   new Comparable[capacity];
        Value[] tempvalue = (Value[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            tempkey[i] = keys[i];
            tempvalue[i] = values[i];
        }
        values = tempvalue;
        keys = tempkey;
    }
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(Key k) {
        return (get(k) != null);
    }
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
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
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
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
    /**.
     * { function_description }
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(Key key, Value val)  {
        if (val == null) {
            delete(key);
            return;
        }
        int i = rank(key);
        if (i < n && keys[i].compareTo(key) == 0) {
            values[i] = val;
            return;
        }
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
    /**.
     * { function_description }
     *
     * @param      key   The key
     */
    public void delete(Key key) {
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < n-1; j++)  {
            keys[j] = keys[j+1];
            values[j] = values[j+1];
        }
        n--;
        keys[n] = null;
        values[n] = null;
        if (n > 0 && n == keys.length/4) {
            resize(keys.length/2);
        }
        assert check();
    }
    /**.
     * { function_description }
     *
     * @param      k     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
     public Key select(int k) {
        return keys[k];
    }
    public void deleteMin() {
        delete(min());
    }
    public void deleteMax() {
        delete(max());
    }
    public Key min() {
        return keys[0];
    }
    /**.
     * { function_description }
     *
     * @return     { description_of_the_return_value }
     */
    public Key max() {
        return keys[n-1];
    }
     private boolean check() {
        return isSorted() && rankCheck();
    }
    /**.
     * Determines if sorted.
     *
     * @return     True if sorted, False otherwise.
     */
    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (keys[i].compareTo(keys[i-1]) < 0) return false;
        return true;
    }
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
    /**.
     * { function_description }
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
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