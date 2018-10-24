import java.util.Scanner;
/**
 * Class for solution.
 **/
final class Solution {
    /**
     * Constructs the object.
     **/
    private Solution() { }
    /**
     * function_description.
     *
     * @param      args  The arguments
     **/
        public static void main(final String[] args) {
            Scanner sc = new Scanner(System.in);
            String line = sc.nextLine();
            String[] arr = line.split(" ");
            int size = arr.length;
            Searchtable<String, Integer> st = new Searchtable<String,
            Integer>(size);
            for (int i = 0; i < size; i++) {
                st.put(arr[i], i);
            }
            while (sc.hasNextLine()) {
                String[] newline = sc.nextLine().split(" ");
                switch (newline[0]) {
                    case "max":
                    System.out.println(st.max());
                    break;
                    case "floor":
                    System.out.println(st.floor(newline[1]));
                    break;
                    case "rank":
                    System.out.println(st.rank(newline[1]));
                    break;
                    case "deleteMin":
                    st.deleteMin();
                    break;
                    case "min":
                    System.out.println(newline[1]);
                    break;
                    case "contains":
                    System.out.println(st.contains(newline[1]));
                    break;
                    case "keys":
                    st.keys();
                    break;
                    case "get":
                    System.out.println(st.get(newline[1]));
                    break;
                    default:
                    break;
                }
            }
        }
    }
