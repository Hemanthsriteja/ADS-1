import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubesSum implements Comparable<CubesSum> {
    /**
     * Integer varaible.
     */
    private final int sum;
    /**
     * Integer varaible.
     */
    private final int i;
    /**
     * Integer varaible.
     */
    private final int j;
    /**
     * Constructs the object.
     *
     * @param      i1    I 1
     * @param      j1    The j 1
     */
    CubesSum(final int i1, final int j1) {
        this.sum = i1 * i1 *  i1 + j1 * j1 * j1;
        this.i = i1;
        this.j = j1;
    }
    /**
     * Gets the sum.
     * Time complexity is 1.
     *
     * @return     The sum.
     */
    public int getSum() {
        return this.sum;
    }
    /**
     * Gets i.
     * Time complexity is 1.
     *
     * @return     I.
     */
    public int getI() {
        return this.i;
    }
    /**
     * Gets the j.
     * Time complexity is 1.
     *
     * @return     The j.
     */
    public int getJ() {
        return this.j;
    }
    /**
     * compareTo method is using to compare the two objects.
     * Time complexity is 1.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final CubesSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     * Time complexity is 1.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return Integer.toString(sum);
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        // default constructor is not used.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final int num = 1200;
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int count = 0;
        int z1 = -1;
        MinPQ<CubesSum> pq = new MinPQ<CubesSum>();
        for (int i = 0; i <= num; i++) {
            pq.insert(new CubesSum(i, i));
        }
        while (!pq.isEmpty()) {
            CubesSum s = pq.delMin();
            if (z1 == s.getSum()) {
                count++;
            } else {
                count = 0;
            }
            if (count == m - 1) {
                n--;
                if (n == 0) {
                    System.out.println(s.getSum());
                    break;
                }
            }
            z1 = s.getSum();
            if (s.getJ() < num) {
                pq.insert(new CubesSum(s.getI(), s.getJ() + 1));
            }
        }
    }
}
