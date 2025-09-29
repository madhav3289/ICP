// 74. Search a 2D Matrix

// You are given an m x n integer matrix matrix with the following two properties:

// Each row is sorted in non-decreasing order.
// The first integer of each row is greater than the last integer of the previous row.
// Given an integer target, return true if target is in matrix or false otherwise.

// You must write a solution in O(log(m * n)) time complexity.

 

// Example 1:

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
// Output: true


// Example 2:

// Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
// Output: false
 

// Constraints:

// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 100
// -10^4 <= matrix[i][j], target <= 10^4


// APPROACH 1
// Brute Force Solution

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
// Complexity Analysis
// Time Complexity -> O(n*m);
// Space Complexity -> O(1);


// APPROACH 2
// Better Solution

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            int lo=0;
            int hi=m-1;
            if(matrix[i][hi]<target){
                continue;
            }
            else{
                while(lo<=hi){
                    int mid=lo+(hi-lo)/2;
                    if(matrix[i][mid]<target){
                        lo=mid+1;
                    }
                    else if(matrix[i][mid]>target){
                        hi=mid-1;
                    }
                    else{
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
// Complexity Analysis
// Time Complexity -> O(nlog(m));
// Space Complexity -> O(1);


// APPROACH 3
// Optimised Solution

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int lo=0;
        int hi=n-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(matrix[mid][0]<=target && matrix[mid][m-1]>=target){
                int l=0;
                int h=m-1;
                while(l<=h){
                    int md=l+(h-l)/2;
                    if(matrix[mid][md]<target){
                        l=md+1;
                    }
                    else if(matrix[mid][md]>target){
                        h=md-1;
                    }
                    else{
                        return true;
                    }
                }
                return false;
            }
            else if(matrix[mid][0]<target && matrix[mid][m-1]<target){
                lo=mid+1;
            }
            else if(matrix[mid][0]>target && matrix[mid][m-1]>target){
                hi=mid-1;
            }
        }
        return false;
    }
}
// Complexity Analysis
// Time Complexity -> O(log(n*m));
// Space Complexity -> O(1);
