/**.
 * Class for student.
 */
class Student implements Comparable<Student> {
	/**.
	 * Student name.
	 */
	private String studentname;
	/**.
	 * dob
	 */
	private String dob;
	/**
	 * mark1
	 */
	private Integer mark1;
	/**.
	 * mark2
	 */
	private Integer mark2;
	/**.
	 * mark3
	 */
	private Integer mark3;
	/**.
	 * total
	 */
	private Integer total;
	/**.
	 * category
	 */
	private String category;
	/**.
	 *
	 * Constructs the object.
	 *
	 * @param      studentname1  The studentname 1
	 * @param      dob1          The dob 1
	 * @param      marks1        The marks 1
	 * @param      marks2        The marks 2
	 * @param      marks3        The marks 3
	 * @param      total1        The total 1
	 * @param      category1     The category 1
	 */
	Student(String studentname1, String dob1, Integer marks1, Integer marks2, Integer marks3, Integer total1, String category1) {
		this.studentname = studentname1;
		this.dob = dob1;
		this.mark1 = marks1;
		this.mark2 = marks2;
		this.mark3 = marks3;
		this.total = total1;
		this.category = category1;
	}
	/**./
	 * Gets the student.
	 *
	 * @return     The student.
	 */
	public String getStudent() {
		return this.studentname;
	}
	/**.
	 * Gets the dob.
	 *
	 * @return     The dob.
	 */
	public String getDob() {
		return this.dob;
	}
	/**.
	 * Gets the mark 1.
	 *
	 * @return     The mark 1.
	 */
	public int getMark1() {
		return this.mark1;
	}
	/**.
	 * Gets the mark 2.
	 *
	 * @return     The mark 2.
	 */
	public int getMark2() {
		return this.mark2;
	}
	/**.
	 * Gets the mark 3.
	 *
	 * @return     The mark 3.
	 */
	public int getMark3() {
		return this.mark3;
	}
	/**.
	 * Gets the totalmark.
	 *
	 * @return     The totalmark.
	 */
	public int getTotalmark() {
		return this.total;
	}
	/**.
	 * Gets the cat.
	 *
	 * @return     The cat.
	 */
	public String getCat() {
		return this.category;
	}
	public int compareTo(final Student that) {
		if (this.getTotalmark() > that.getTotalmark()) {
			return 1;
		} else if (this.getTotalmark() < that.getTotalmark()) {
			return -1;
		} else if (this.getMark3() < that.getMark3()) {
			return -1;
		} else if (this.getMark2() > that.getMark2()) {
			return 1;
		} return 0;

	}
}
