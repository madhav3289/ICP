// 62. Unique Paths

// There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). 
// The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
// Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
// The test cases are generated so that the answer will be less than or equal to 2 * 10^9.
 

// Example 1:

// Input: m = 3, n = 7
// Output: 28


// Example 2:

// Input: m = 3, n = 2
// Output: 3
// Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Down -> Down
// 2. Down -> Down -> Right
// 3. Down -> Right -> Down
 

// Constraints:

// 1 <= m, n <= 100

// Recursive Solution

class Solution {
    public int uniquePaths(int m, int n) {
        return helper(m,n,0,0);
    }
    public static int helper(int m,int n,int row,int col){
        if(row==m-1 && col==n-1){
            return 1;
        }
        if(row>=m || col>=n){
            return 0;
        }
        int count=0;
        count+=helper(m,n,row,col+1);
        count+=helper(m,n,row+1,col);
        return count;
    }
}

// COMPLEXITY ANALYSIS

// Time Complexity -> O(2^(m+n))
// Space Complexity  -> O(m+n)


// Better Approach -> Using Memoization

class Solution {
    public int uniquePaths(int m, int n) {
        int [][] dp=new int[m][n];
        for(int [] arr:dp){
            Arrays.fill(arr,-1);
        }
        return helper(m,n,0,0,dp);
    }
    public static int helper(int m,int n,int row,int col,int [][] dp){
        if(row==m-1 && col==n-1){
            return 1;       // return 1 which will add in count since this is a valid path
        }
        if(row>=m || col>=n){
            return 0;       // return 0 since this is invalid path means no change in count
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int count=0;
        // we can either move right
        count+=helper(m,n,row,col+1,dp);
        // or we can move down
        count+=helper(m,n,row+1,col,dp);
        return dp[row][col]=count;
    }
}

// COMPLEXITY ANALYSIS

// Time Complexity -> O(m*n)
// Space Complexity  -> O(m*n)
