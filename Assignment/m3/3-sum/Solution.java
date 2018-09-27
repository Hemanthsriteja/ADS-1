import java.util.Scanner;
import java.util.Arrays;
/**
 *  class.
 **/
public final class Solution {
    /**
     *  args.
     *
     * @param      args  The arguments
     **/
    private Solution() {

    }
    final public static void main(String[] args) {
    /**
     *
     *{ var_description }
     **/
        Scanner Scanner = new Scanner(System.in);
        int arr_size = Scanner.nextInt();
        int[] arr = new int[arr_size];
        int count = 0;
        for (int i = 0; i < arr_size; i++) {
            arr[i] = Scanner.nextInt();
        }
        Arrays.sort(arr);
        int j = 0;
        int k = 0;
        for (int i = 0; i < arr_size; i++) {
            j = i + 1;
            k = arr_size - 1;
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