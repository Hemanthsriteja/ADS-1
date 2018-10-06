import java.util.Scanner;
/**.
 *@author: Hemanth Sriteja
 * class for solution
 */
final class Solution {
    /**
     * Constructs the object.
     */
    /**.
     * Constructs the object.
     */
    private Solution() { }
    /**
     * function_description.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        int size = 0;
        Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
        Student[] stud = new Student[n];
        Insertion in = new Insertion();
        while (sc.hasNext()) {
            String line = sc.nextLine().split(",");
            stud[size++] = new Student(line[0], Integer.parseInt(line[1]),
                    Integer.parseInt(line[2]), Integer.parseInt(line[3]),
                    Integer.parseInt(line[4]), Integer.parseInt(line[5]), line[6] );
        }
        in.sort(stud);
        //need to write meritlist()
}

