// 53. Maximum Subarray

// Given an integer array nums, find the subarray with the largest sum, and return its sum.



// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.


// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.


// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 

// Constraints:

// 1 <= nums.length <= 10^5
// -104 <= nums[i] <= 10^4

// Solution 1

class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums,1,nums[0],nums[0]);
    }
    public static int helper(int [] nums,int idx,int sum,int max){
        if(idx==nums.length){
            return max;
        }
        sum=Math.max(sum+nums[idx],nums[idx]);
        max=Math.max(max,sum);
        return helper(nums,idx+1,sum,max);
    }
}

// COMPLEXITY ANALYSIS

// Time Complexity -> O(n)
// Space Complexity  -> O(1)


// Solution 2 (just remove extra recursive stack)

class Solution {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int max=nums[0];
        for(int i=1;i<nums.length;i++){
            sum=Math.max(sum+nums[i],nums[i]);
            max=Math.max(max,sum);
        }
        return max;
    }
}

// COMPLEXITY ANALYSIS

// Time Complexity -> O(n)
// Space Complexity  -> O(1)
