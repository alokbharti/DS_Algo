/*
	In this example, we wiil check if a sum can be formed by any pair from array
	Expected time complexity - O(n)
*/

import java.util.*;
class PairSumArray{

	public static void main(String args[]){
		int a[] = {1, 4, 7, 2, 3, 9, 5};
		int k = 6;
		int n = a.length;

		boolean found = false;
		HashSet<Integer> set = new HashSet();
		int i=0;
		for(i=0; i<n;i++){
			if (set.contains(k-a[i])) {
				found = true;
				break;
			} else {
				set.add(a[i]);
			}
		}

		if (found == true) {
			System.out.println("Pairs found with sum "+k+" is: ("+a[i]+", "+(k-a[i])+")");
		} else {
			System.out.println("No pairs found with sum "+k);
		}
	}
}