/**.
 * Import the scanner package
 */
import java.util.Arrays;
/**
 * Class for priority.
 *
 * @param      <E>   of generic type
 */
class Priority<E extends Comparable<E>> {
	E[] array;
	int size;
	/**
	 * Constructs the object for class Priority
	 *
	 * @param      a     array
	 */
	Priority(final E[] a) {
		this.array = a;
	}
	/**.
	 * Here, we check if the array is minPQ or not.
	 *
	 * @return     returns True if minimum pq, False otherwise.
	 *
	 * Time Complexity: N to check for skewed trees(Worst Case)
	 *
	 */
	public boolean isminHeap() {
		for(int i = 1; i < array.length; i++) {
			if(2 * i < array.length && greater(2 * i,i)) {
				return false;
			} if((2 * i) + 1 < array.length && greater(2 * i+1,i)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Compare two elements of array
	 *
	 * @param      i     index of array
	 * @param      j     index of array
	 *
	 * @return     returns true if condition is satisfied fasle otherwise.
	 *
	 * The time complexity is constant because the statment is executed once.
	 */
    public boolean greater(int i, int j) {
    	return array[i].compareTo(array[j]) < 0;
    }
}