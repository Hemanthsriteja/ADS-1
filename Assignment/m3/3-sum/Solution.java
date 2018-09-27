import java.util.Scanner;
import java.util.Arrays;
/**
 *  class.
 **/
public final class Solution {

    /**.
     * Constructs the object.
     */
    private Solution() {

    }
    /**.
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
    /**
     *
     *{ var_description }
     **/
        Scanner scan = new Scanner(System.in);
        int arrsize = scan.nextInt();
        int[] arr = new int[arrsize];
        int count = 0;
        for (int i = 0; i < arrsize; i++) {
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        int j = 0;
        int k = 0;
        for (int i = 0; i < arrsize; i++) {
            j = i + 1;
            k = arrsize - 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] < 0) {
                    j += 1;
                } else if (arr[i] + arr[j] + arr[k] > 0) {
                    k -= 1;
                } else {
                    j += 1;
                    k -= 1;
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}