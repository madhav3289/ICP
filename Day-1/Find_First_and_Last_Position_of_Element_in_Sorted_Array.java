// 34. Find First and Last Position of Element in Sorted Array

// Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
// If target is not found in the array, return [-1, -1].
// You must write an algorithm with O(log n) runtime complexity.

// Example 1:
// Input: nums = [5,7,7,8,8,10], target = 8
// Output: [3,4]

// Example 2:
// Input: nums = [5,7,7,8,8,10], target = 6
// Output: [-1,-1]

// Example 3:
// Input: nums = [], target = 0
// Output: [-1,-1]

// Constraints:

// 0 <= nums.length <= 105
// -10^9 <= nums[i] <= 10^9
// nums is a non-decreasing array.
// -10^9 <= target <= 10^9


// Linear Search(Brute-force)
// Step 1: iterate through the entire array and find the indexes of first occurence of target value.
// Step 2: iterate through the entire array and find the indexes of last occurence of target value.
// return value from step 1 & step 2 in form of array...

// Complexity Analysis
// Time Complexity -> O(n)
// Space Complexity -> O(1)

// Optimal Way(using Binary Search)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstIdx=-1;
        int lo=0,hi=nums.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<target){
                lo=mid+1;
            }
            else if(nums[mid]>=target){
                if(nums[mid]==target){
                    firstIdx=mid;
                }
                hi=mid-1;
            }
        }
        int lastIdx=-1;
        lo=0;
        hi=nums.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<=target){
                if(nums[mid]==target){
                    lastIdx=mid;
                }
                lo=mid+1;
            }
            else if(nums[mid]>target){
                hi=mid-1;
            }
        }
        return new int[]{firstIdx,lastIdx};
    }
}

// Complexity Analysis

// Time Complexity -> O(logn)
// Space Complexity -> O(1) (no extra space is needed except for the answer array which is of size 2);
