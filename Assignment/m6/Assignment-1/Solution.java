/**.
 * { item_description }
 */
import java.util.Scanner;
/**.
 * Class for add large numbers.
 */
class AddLargeNumbers {
    public static LinkedList numberToDigits(String number) {
        LinkedList l = new LinkedList();
        int size = number.length();
        String[] ar = new String[size];
        ar = number.split("");
        for(int i = 0; i < size; i++) {
            l.push(ar[i]);
        }
        return l;
    }
    /**.
     * { function_description }
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(LinkedList list) {
        return list.displayAll();
    }
    /**.
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        return list1;
    }
}

/**.
 * Class for solution.
 */
public class Solution {
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
            case "numberToDigits":
                LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
                LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
                System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
                System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
                break;

            case "addLargeNumbers":
                 pDigits = AddLargeNumbers.numberToDigits(p);
                 qDigits = AddLargeNumbers.numberToDigits(q);
                LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
                System.out.println(AddLargeNumbers.digitsToNumber(result));
                break;
            default:
                break;
        }
    }

}
