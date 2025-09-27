// 215. Kth Largest Element in an Array


// Given an integer array nums and an integer k, return the kth largest element in the array.
// Note that it is the kth largest element in the sorted order, not the kth distinct element.
// Can you solve it without sorting?

 
// Example 1:
// Input: nums = [3,2,1,5,6,4], k = 2
// Output: 5

// Example 2:
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
// Output: 4
 

// Constraints:

// 1 <= k <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
  

// Solution (Using Priority Queue)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        int ans=0;
        while(!pq.isEmpty() && k-->0){
            ans=pq.poll();
        }
        return ans;
    }
}

// Complexity Analysis

// Time Complexity -> O(n)
// Space Complexity -> O(n) extra space required for priority queue
