import java.util.*;
/**
 *this the class for main.
 */
final class Solution {
    /**
     *empty constructor.
     */
    private Solution() {
    }
    /**
     * the main to read the input.
     *
     * @param  args  The arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        LinearProbingHashST<Integer, Student> obj = new
        LinearProbingHashST<>();
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(",");
            Student input1 = new Student(Integer.parseInt(input[0]), input[1],
             Double.parseDouble(input[2]));
            obj.put(Integer.parseInt(input[0]), input1);
        }
}
}

