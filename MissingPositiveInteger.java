/*
	Given a sorted array with its element from 1 to n with a missing number
	Ex: arr = [1,2,3,5,6,7], here 4 is missing
    find the first missing positive number
    Expected Time Complexity of the solution is O(logn)
*/

class MissingPositiveInteger{

	public static void main(String args[]){
		int arr[] = {1,2,3,5,6,7,8,9};
		int res = findMissingNumber(arr, 0, arr.length-1);
		System.out.println("Missing Number is "+res);
	}

	private static int findMissingNumber(int arr[], int start, int end){

		int mid = 0;
		while (start+1 < end){
			mid = (start+end)/2;
			if (arr[start]-start != arr[mid]-mid) {
				end = mid;
			} else if (arr[end]-end != arr[mid]-mid) {
				start = mid;
			}
		}

		return arr[mid]+1;
	} 
}