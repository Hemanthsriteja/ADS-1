/**.
 *@author:Hemanth Sriteja
 * Class for insertion.
 */
class Insertion {
	/**.
	 * { function_description }
	 *
	 * @param      a     Student[] a
	 * @param      i     int i
	 * @param      j     int j
	 */
	public void exchange(Student[] a, int i, int j) {
		Student swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	/**.
	 * it compares and return boolean values.
	 * So took s1, s2 as two parametrs for comparision
	 *
	 * @param      s1    The s 1
	 * @param      s2    The s 2
	 *
	 * @return     true if condition is satisfied else false.
	 */
	public boolean less(Student s1, Student s2) {
		return s1.compareTo(s2)<0;
	}
	/**.
	 * Insertion sort function, this is the main function which sorts.
	 *
	 * @param      stud  The stud
	 */
	public void sort(Student[] stud) {
		for (int i = 1; i < stud.length; i++) {
			for (int j = i; j > 0; j--) {
				if (less(stud[j - 1], stud[j])) {
					exchange(stud, j - 1, j);
				} else {
					break;
				}
			}
		}
	}
}