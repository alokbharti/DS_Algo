/*
	Problem Statement: Given a list of coins i.e 1 cents, 5 cents and 10 cents,
	can you determine the total number of permutations of the coins in the given
	list to make up the number N?
	
*/
class CoinChangeProblem{

	public static void main(String args[]){

		int n = 12;
		int change[] = {1, 5, 10}; 

		int ans = numberOfPermutaionOfCoins(n, change);
		System.out.println("Number of ways to make 8 using {1, 5, 10} is: "+ans);
	}

	static int numberOfPermutaionOfCoins(int n, int change[]){
		
		int ways[] = new int[n+1];
		ways[0] = 1;

		for (int i=0; i<change.length; i++) {
			
			for (int j=0; j<=n; j++) {
				if (j>=change[i]) {
					ways[j] += ways[j-change[i]];	
				}
			}
		}

		return ways[n];
	}
}