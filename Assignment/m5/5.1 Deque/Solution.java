import java.util.Scanner;
/**.
Solution the class
*/
final  class Solution {
/**.
@Solution() the constructor
*/
    protected Solution() {

    }
/**.
@param args the arguments
*/

    public static void main(final String[] args) {
        Deque dequeue = new Deque();
        //LinkedList linklist = new LinkedList();
        Scanner s = new Scanner(System.in);
        String s1 = s.nextLine();
        int num = Integer.parseInt(s1);
        int j = 0;
        while (j < num) {
        String[] tokens = s.nextLine().split(" ");
        //System.out.println(tokens[0] + "  " + tokens[1]);

            switch (tokens[0]) {
                case "pushLeft" :
                                 dequeue.addFirst(Integer.parseInt(tokens[1]));
                                 //System.out.println("hello");
                                 System.out.println(dequeue.display());
                                 break;
                case "pushRight":
                                 dequeue.addLast(Integer.parseInt(tokens[1]));
                                 System.out.println(dequeue.display());
                                 break;
                case "popLeft":
                                if (!dequeue.isempty()) {
                                dequeue.removeFirst();
                                System.out.println(dequeue.display());
                            } else {
                                System.out.println("Deck is empty");
                            }
                                //System.out.println(linklist);
                                break;
                case "popRight":
                                if (!dequeue.isempty()) {
                                dequeue.removeLast();
                                System.out.println(dequeue.display());
                            } else {
                                System.out.println("Deck is empty");
                            }
                                break;
                case "size":
                            int size = dequeue.size();
                            System.out.println(size);
                            break;
                default:
                break;
            }
            j++;

        }
    }
}
