import java.util.*;
class Solution {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.println("Input no of elements you want to give as input:");
	int n = sc.nextInt();
	int a[] = new int[n];
	int i,j,check=1,count=0;
	System.out.println("enter numbers: ");
	for (i = 0; i< n ; i++) {
		a[i] = sc.nextInt();
	}
	Arrays.sort(a);
	for (i=0; i<a.length-1; i++ ) {
		if(a[i]==a[i+1]) {
			check+=1;
		} else {
		count += (check*(check-1))/2;
		check = 1;
		}
	} count += (check*(check-1))/2;
	System.out.println("count:"+count);
}
}



