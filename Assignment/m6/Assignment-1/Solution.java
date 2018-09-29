import java.util.Scanner;
class AddLargeNumbers {
    public static LinkedList numberToDigits(String number) {
        LinkedList l = new LinkedList();
        int size = number.length();
        String[] ar = new String[size];
        ar = number.split(" ");
        for(int i = 0; i < size; i++) {
            l.push(ar[i]);
        }
        return l;
    }

    public static String digitsToNumber(LinkedList list) {
        return list.displayAll();
    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        return list1;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch(input){
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
        }
    }

}
