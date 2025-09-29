// 54. Spiral Matrix

// Given an m x n matrix, return all elements of the matrix in spiral order. 


// Example 1:

// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Output: [1,2,3,6,9,8,7,4,5]


// Example 2:

// Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
// Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 
// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100


// Solution 
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int t=n*m;
        List<Integer> list=new ArrayList<>(); 
        int rs=0,cs=0;
        int re=n-1,ce=m-1;
        while(t>0){
            // rs cs->ce
            // rs++
            for(int i=cs;i<=ce && t-->0;i++){
                list.add(matrix[rs][i]);
            }
            rs++;

            // ce rs->re
            // ce--
            for(int i=rs;i<=re && t-->0;i++){
                list.add(matrix[i][ce]);
            }
            ce--;

            // re ce->cs
            // re--;
            for(int i=ce;i>=cs && t-->0;i--){
                list.add(matrix[re][i]);
            }
            re--;

            // cs re->rs
            // cs++;
            for(int i=re;i>=rs && t-->0;i--){
                list.add(matrix[i][cs]);
            }
            cs++;
        }
        return list;
    }
}

// Complexity Analysis

// Time Complexity -> O(n*m)
// Space Complexity -> O(1)
