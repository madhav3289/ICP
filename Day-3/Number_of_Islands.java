// 200. Number of Islands

// Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
// An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
// You may assume all four edges of the grid are all surrounded by water.

 

// Example 1:
// Input: grid = [
//   ["1","1","1","1","0"],
//   ["1","1","0","1","0"],
//   ["1","1","0","0","0"],
//   ["0","0","0","0","0"]
// ]
// Output: 1


// Example 2:
// Input: grid = [
//   ["1","1","0","0","0"],
//   ["1","1","0","0","0"],
//   ["0","0","1","0","0"],
//   ["0","0","0","1","1"]
// ]
// Output: 3
 

// Constraints:

// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 300
// grid[i][j] is '0' or '1'.

class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        Set<String> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && !set.contains(i+" "+j)){
                    count++;
                    helper(grid,set,i,j);
                }
            }
        }
        return count;
    }
    public static void helper(char [][] grid,Set<String> set,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return;
        }
        if(grid[i][j]=='0'){
            return;
        }
        if(set.contains(i+" "+j)){
            return;
        }
        else{
            set.add(i+" "+j);
            helper(grid,set,i-1,j);
            helper(grid,set,i,j-1);
            helper(grid,set,i+1,j);
            helper(grid,set,i,j+1);
        }
    }
}

// Complexity Analysis

// Time Complexity -> O(n*m)
// Space Complexity -> O(n*m)
