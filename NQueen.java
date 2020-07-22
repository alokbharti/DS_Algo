/*
	In this example, we'll be doing NQueen problem.
	By N Queen, what i mean is n number of queens given in a nxn chess board
	and you've to place those queens in such a way that no queen can attack 
	other queens.

	We'll be looking at backtracking method and time complexity of the solution is O(2^n)
*/

class NQueen{

	private static int n=0;

	public static void main(String args[]){
		int board[][] = {{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
                        	{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          	{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          	{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
                        	{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          	{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          	{ 0, 0, 0, 0, 0, 0, 0, 0 }, 
                          	{ 0, 0, 0, 0, 0, 0, 0, 0 }};
        n=8;

        solveNQUtil(board, 0);

        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) 
                System.out.print(" " + board[i][j] 
                                 + " "); 
            System.out.println(); 
        } 
	}

	private static boolean isSafe(int board[][], int row, int col){

		//check straight left side
		for(int i=0;i<col;i++){
			if (board[row][i]==1) {
				return false;
			}
		}

		//check left downside diagonal
		for(int i=row, j=col; i>=0 && j>=0; i--,j--){
			if (board[i][j]==1) {
				return false;
			}
		}

		//check left upside diagonal
		for(int i=row, j=col; i<n && j>=0; i++,j--){
			if (board[i][j]==1) {
				return false;
			}
		}

		return true;
	}

	private static boolean solveNQUtil(int board[][], int col){
		if (col>=n) {
			return true;
		}

		for(int i=0; i<n; i++){
			if (isSafe(board, i, col)) {
				board[i][col] = 1;

				if (solveNQUtil(board, col+1)) {
					return true;
				}

				board[i][col]=0;
			}
		}

		return false;
	}
}