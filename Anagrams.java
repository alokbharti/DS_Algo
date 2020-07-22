/*
	In this example, we are solving the below question:
	Print all anagrams together in array of strings
	
	Expected time complexity should be O(MN).
	Where M is length of an array and N is length of each word.
	
	Ex- { cat,dog, act,god,tac}
	O/p- [[cat, act, tac] [dog,god]]
*/
import java.util.*;

class Anagrams{

	public static void main(String args[]){
		String[] input = {"cat","dog","act","god","tac"};
        ArrayList<ArrayList<String>> res = new ArrayList();
        HashMap<Integer,ArrayList<String>> ans = new HashMap();
        for(String word: input){
            int hash = getHash(word);
            if (ans.get(hash)!=null) {
                ans.get(hash).add(word);
            } else {
                ArrayList<String> temp = new ArrayList();
                temp.add(word);
                ans.put(hash, temp);
            }
        }

        for(int hash: ans.keySet()){
            res.add(ans.get(hash));
        }
        System.out.println(res.toString());
    }

    private static int getHash(String word){
        int sum =0;
        for(int i=0;i<word.length();i++){
            sum+= (int) word.charAt(i);
        }

        return sum;
    }
}