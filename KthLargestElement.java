/*
	In this example, we'll solve the problem mentioned below:
	Find the Kth largest element in an array

	Expected Time complexity is O(n + klogn), n = length of the array amd k is given
	We're using Min Heap to solve this question.  
*/

//Let build a class to create a heap

import java.util.*;

class MinHeap{
	private ArrayList<Integer> array;
	MinHeap(ArrayList<Integer> array){
		this.array = array;
	}

	//smaller helper function
	private int getLeftChildIndex(int index){
		return 2*index+1;
	}
	private int getRightChildIndex(int index){
		return 2*index+2;
	}
	private int getParentIndex(int index){
		return (index-1)/2;
	}

	private boolean hasLeftChild(int index) {
		return getLeftChildIndex(index)<array.size();
	}
	private boolean hasRightChild(int index){
		return getRightChildIndex(index)<array.size();
	}
	private boolean hasParent(int index){
		return getParentIndex(index)>=0;
	}

	private int leftChild(int index){
		return array.get(getLeftChildIndex(index));
	}
	private int rightChild(int index){
		return array.get(getRightChildIndex(index));
	}
	private int parent(int index){
		return array.get(getParentIndex(index));
	}

	private void swap(int i, int j){
		int temp = array.get(i);
		array.set(i, array.get(j));
		array.set(j, temp);
	}

	//create a method to insert an element to the heap
	public void add(int element){
		//add element at 0th index
		array.add(element);
		heapifyUp();
	}

	//method to get first/smallest element and remove it from the heap
	public int poll(){
		if (array.size()==0) {
			return -1;
		}
		int item = array.get(0);
		int len = array.size();
		array.set(0,array.get(len-1));
		array.remove(len-1);
		heapifyDown();

		return item;
	}

	public void heapifyUp(){
		int lastIndex = array.size()-1;
		while (hasParent(lastIndex) 
			&& parent(lastIndex) > array.get(lastIndex)){
			swap(lastIndex, getParentIndex(lastIndex));
			lastIndex = getParentIndex(lastIndex);
		}
	}

	public void heapifyDown(){
		int index = 0;
		while (hasLeftChild(index)) {
			int smallerChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) 
				&& rightChild(index)<leftChild(index)) {
				smallerChildIndex = getRightChildIndex(index);
			}

			if(array.get(index)<array.get(smallerChildIndex)){
				break;
			} else {
				swap(index, smallerChildIndex);
			}

			index = smallerChildIndex;
		}
	}

}

class KthLargestElement{
	public static void main(String args[]) {
		ArrayList<Integer> array = new ArrayList();
		
		MinHeap minHeap = new MinHeap(array);
		minHeap.add(10);
		minHeap.add(15);
		minHeap.add(20);
		minHeap.add(17);
		minHeap.add(25);

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your k number");
        int k = scanner.nextInt();
		int res =0;
		for(int i=0; i<k;i++){
			res = minHeap.poll();
		}
		System.out.println("Your kth largest element is: "+res);
	}
}