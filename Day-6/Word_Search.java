// 77. Combinations

// Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
// You may return the answer in any order.


// Example 1:

// Input: n = 4, k = 2
// Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
// Explanation: There are 4 choose 2 = 6 total combinations.
// Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.


// Example 2:

// Input: n = 1, k = 1
// Output: [[1]]
// Explanation: There is 1 choose 1 = 1 total combination.
 

// Constraints:

// 1 <= n <= 20
// 1 <= k <= n

// Recursive Solution 

class Solution {
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        boolean [][] isUsed=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(helper(board,word,i,j,isUsed,0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean helper(char [][] board,String word,int i,int j,boolean [][] isUsed,int idx){
        if(idx==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length){
            return false;
        }
        if(word.charAt(idx)!=board[i][j]){
            return false;
        }
        if(isUsed[i][j]){
            return false;
        }
        isUsed[i][j]=true;
        boolean a=helper(board,word,i-1,j,isUsed,idx+1);
        boolean b=helper(board,word,i,j-1,isUsed,idx+1);
        boolean c=helper(board,word,i+1,j,isUsed,idx+1);
        boolean d=helper(board,word,i,j+1,isUsed,idx+1);
        if(a || b || c || d){
            return true;
        }
        isUsed[i][j]=false;
        return false;
    }
}

// COMPLEXITY ANALYSIS

// Time Complexity -> O(n × m × 4^L)
// Space Complexity -> O(n × m)
