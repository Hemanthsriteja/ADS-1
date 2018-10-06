import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * function_description.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList ll = new LinkedList();
        while (sc.hasNextLine()) {
            String[] values = sc.nextLine().split(" ");
            switch (values[0]) {
                case "insertAt":
                try {
        ll.insertAt(Integer.parseInt(values[1]), new Node(values[2]));
                ll.display();
                } catch (Exception e) {
                    System.out.println("Can't insert at this position.");
                }
                break;
                case "reverse":
                try {
                    ll.reverse();
                ll.display();
                } catch (Exception e) {
                    System.out.println("No elements to reverse.");
                }
                break;
                default:
                break;
            }
        }
    }
}
/**
 * Class for node.
 */
class Node {
    /**
     * var_description.
     */
    String data;
    /**
     * var_description.
     */
    Node next;
    /**
     * Constructs the object.
     *
     * @param      val   The value
     */
    Node(final String val) {
        data = val;
    }
}
