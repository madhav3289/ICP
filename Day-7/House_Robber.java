// 198. House Robber

// You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
// the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected 
// and it will automatically contact the police if two adjacent houses were broken into on the same night.

// Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.



// Example 1:

// Input: nums = [1,2,3,1]
// Output: 4
// Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
// Total amount you can rob = 1 + 3 = 4.


// Example 2:

// Input: nums = [2,7,9,3,1]
// Output: 12
// Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
// Total amount you can rob = 2 + 9 + 1 = 12.
 

// Constraints:

// 1 <= nums.length <= 100
// 0 <= nums[i] <= 400

// Recusive Solution -> will give TLE

class Solution {
    public int rob(int[] nums) {
        return helper(nums,0);
    }
    public static int helper(int [] nums,int idx){
        if(idx>=nums.length){
            return 0;
        }
        // we can either rob one house and then skip one and move to another
        int inc=nums[idx]+helper(nums,idx+2);
        // or we can skip current house and move to next house
        int exc=helper(nums,idx+1);
        return Math.max(inc,exc);
    }
}

// COMPLEXITY ANALYSIS

// Time Complexity -> O(2^n)
// Space Complexity  -> O(1) 


// Better Approach -> Using Memoization

class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int [] memo=new int[n];
        Arrays.fill(memo,-1);
        return helper(nums,0,memo);
    }
    public static int helper(int [] nums,int idx,int [] memo){
        if(idx>=nums.length){
            return 0;
        }
        if(memo[idx]!=-1){
            return memo[idx];
        }
        // we can either rob one house and then skip one and move to another
        int inc=nums[idx]+helper(nums,idx+2,memo);
        // or we can skip current house and move to next house
        int exc=helper(nums,idx+1,memo);
        return memo[idx]=Math.max(inc,exc);
    }
}

// COMPLEXITY ANALYSIS

// Time Complexity -> O(n)
// Space Complexity  -> O(n) 
