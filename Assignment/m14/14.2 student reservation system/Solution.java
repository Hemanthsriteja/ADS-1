import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for Solution.
 */
public final class Solution {
  /**
   * Constructs the object.
   */
  private Solution() {
    // unused constructor
  }

  /**
   * Assigns seats to the remaining students.
   *
   * @param      arr     The arr
   * @param      arr1   To arr
   * @param      insert  The insert
   * @param      n       { parameter_description }
   * @param      strt1    The strt1
   */
  public static void add(final Student[] arr,
                         final Student[] arr1,
                         final int insert, final int n,
                         final int strt1) {
    int check = 0;
    int at = insert;
    for (int j = strt1; j < arr.length; j++) {
      if (!Arrays.asList(arr1).contains(arr[j])) {
        arr1[at] = arr[j];
        at += 1;
        check += 1;
      }

      if (check == n) {
        break;
      }
    }
  }

  /**
   * Fills the seats with desrving students.
   *
   * @param      stud1   The stud1
   * @param      totalVac   The total v
   * @param      unreserv  The unreserv
   * @param      bc     BC seats #.
   * @param      sc     SC seats #.
   * @param      st     ST seats #.
   *
   * @return     { description_of_the_return_value }
   */
  public static Student[] seatsFilled(final Student[] stud1,
                                      final int totalVac,
                                      final int unreserv,
                                      final int bc, final int sc,
                                      final int st) {

    Student[] seats = new Student[totalVac];
    for (int i = 0; i < unreserv; i++) {
      seats[i] = stud1[i];
    }
    int filled = unreserv;
    int totSz = stud1.length;

    for (int i = filled; bc > 0 && i < totSz; i++) {
      if (filled < unreserv + bc && stud1[i].getResCat().equals("BC")
          && filled <= totalVac) {
        seats[filled] = stud1[i];
        filled += 1;
      }
    }

    int tBc = filled - unreserv;

    // System.out.println(filled);
    // System.out.println(Arrays.toString(seats));

    for (int i = unreserv; st > 0 && i < totSz; i++) {
      if (stud1[i].getResCat().equals("ST")
          && filled <= totalVac) {
        seats[filled] = stud1[i];
        filled += 1;
        if (filled == unreserv + tBc + st) {
          break;
        }
      }
    }

    // System.out.println(filled);
    // System.out.println(Arrays.toString(seats));

    for (int i = unreserv; sc > 0 && i < totSz; i++) {
      if (stud1[i].getResCat().equals("SC")
          && filled <= totalVac) {
        seats[filled] = stud1[i];
        filled += 1;
        if (filled == unreserv + tBc + st + sc) {
          break;
        }
      }
    }

    if (filled < totalVac) {
      int toBeFilled = totalVac - filled;
      add(stud1, seats, filled, toBeFilled, unreserv);
    }
    // System.out.println(Arrays.toString(seats));
    HeapSort.sort(seats);
    return seats;
  }
  /**
   * Main function - reads in inputs and prints the output to console.
   *
   * @param      args  The arguments
   */
  public static void main(final String[] args) {
    Scanner scan = new Scanner(System.in);

    int studentsQual = Integer.parseInt(scan.nextLine());
    int totalvac = Integer.parseInt(scan.nextLine());
    int unreservedV = Integer.parseInt(scan.nextLine());
    int nBCVac = Integer.parseInt(scan.nextLine());
    int nSCVac = Integer.parseInt(scan.nextLine());
    int nSTVac = Integer.parseInt(scan.nextLine());

    int num = studentsQual;
    int size = 0;
    Student[] students = new Student[num];

    for (int i = 0; i < num; i++) {
      Student tempStu = new Student(scan.nextLine());
      // System.out.println(tempStu);
      students[size++] = tempStu;
    }
    scan.close();

    HeapSort.sort(students);
    for (int i = 0; i < num; i++) {
      System.out.println(students[i]);
    }

    System.out.println();

    Student[] filledSeats = seatsFilled(students,
                                        totalvac, unreservedV,
                                        nBCVac, nSCVac, nSTVac);
    for (int i = 0; i < totalvac; i++) {
      System.out.println(filledSeats[i]);
    }
  }
}