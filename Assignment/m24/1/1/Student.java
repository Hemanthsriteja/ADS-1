/**
 * @author @Hemanth Sriteja
 */
/**.
 * import Scanner class
 */
import java.util.Scanner;
/**.
 * Class for student.
 */
class Student {
	/**.
	 * roll number of the student.
	 */
	private int roll_number;
	/**.
	 * name of the student.
	 */
	private String student_name;
	/**.
	 * total marks of the student.
	 */
	private double total_marks;
	/**.
	 * Constructs the object.
	 *
	 * @param      roll_number   The roll number
	 * @param      student_name  The student name
	 * @param      total_marks   The total marks
	 */
	Student(int roll_number, String student_name, double total_marks) {
		this.roll_number = roll_number;
		this.student_name = student_name;
		this.total_marks = total_marks;
	}
	/**.
	 * Gets the rollnum
	 *
	 * @return     The roll.
	 */
	public int getRoll() {
		return this.roll_number;
	}
	/**.
	 * Gets the name.
	 *
	 * @return     The name.
	 */
	public String getName() {
		return this.student_name;
	}
	/**.
	 * Gets the total.
	 *
	 * @return     The total.
	 */
	public double getTotal() {
		return this.total_marks;
	}
}