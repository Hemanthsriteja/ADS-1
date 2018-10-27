/**
 * @author @Hemanth Sriteja
 */
/**.
 * Class for student.
 */
class Student {
    /**.
     * roll number of the student.
     */
    private int rollnum;
    /**.
     * name of the student.
     */
    private String studentName;
    /**.
     * total marks of the student.
     */
    private double totalmarks;
    /**.
     * Constructs the object.
     *
     * @param      rollnum   The roll number
     * @param      studentName  The student name
     * @param      totalmarks   The total marks
     */
    Student(final int rollnum1, final String studentName1,
        final double totalmarks1) {
        this.rollnum = rollnum1;
        this.studentName = studentName1;
        this.totalmarks = totalmarks1;
    }
    /**.
     * Gets the rollnum
     *
     * @return     The roll.
     */
    public int getRoll() {
        return this.rollnum;
    }
    /**.
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return this.studentName;
    }
    /**.
     * Gets the total.
     *
     * @return     The total.
     */
    public double getTotal() {
        return this.totalmarks;
    }
}
