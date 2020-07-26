/*
	In this example we'll implement stack using queue
*/
import java.util.*;
class StackUsingQueue{

	static Queue<Integer> q1 = new LinkedList<Integer>();
	static Queue<Integer> q2 = new LinkedList<Integer>();

	public static void main(String args[]){

		int a[] = {1,2,3,4,5,6,7,8,9};
		int n = a.length;
		for (int i=0; i<n; i++) {
			push(a[i]);
		}

		for (int i=0; i<n; i++) {
			int val = pop();
			System.out.println("poped item from stack: "+val);
		}
	}

	static void push(int x){
		q2.add(x);
		while (!q1.isEmpty()){
			q2.add(q1.peek());
			q1.remove();
		}

		Queue<Integer> q = new LinkedList<Integer>();
		q = q1;
		q1= q2;
		q2 = q;
	}

	static int pop(){
		int ans = q1.peek();
		q1.remove();
		return ans;
	}
}