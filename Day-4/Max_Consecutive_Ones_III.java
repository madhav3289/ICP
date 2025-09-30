// 1004. Max Consecutive Ones III

// Given a binary array nums and an integer k, 
// return the maximum number of consecutive 1's in the array 
// if you can flip at most k 0's.


// Example 1:

// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6
// Explanation: [1,1,1,0,0,1,1,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


// Example 2:

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
// Output: 10
// Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
// Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 

// Constraints:

// 1 <= nums.length <= 10^5
// nums[i] is either 0 or 1.
// 0 <= k <= nums.length

 // Optimised Solution(Using Sliding Window)

class Solution {
    public int longestOnes(int[] nums, int k) {
        int max=0;
        int lo=0,hi=0;
        while(hi<nums.length){
            if(nums[hi]==0){
                k--;
                while(k<0){
                    if(nums[lo]==0){
                        k++;
                    }
                    lo++;
                }
            }
            max=Math.max(max,hi-lo+1);
            hi++;
        }
        return max;
    }
}

// Complexity Analysis

// Time Complexity -> O(n)
// Space Complexity -> O(1)
