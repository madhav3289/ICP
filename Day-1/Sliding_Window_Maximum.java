// 239. Sliding Window Maximum


// You are given an array of integers nums, there is a sliding window of size k
// which is moving from the very left of the array to the very right. 
// You can only see the k numbers in the window. Each time the sliding window moves right by one position.
// Return the max sliding window.


// Example 1:

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]
// Explanation: 
// Window position                Max
// ---------------               -----
// [1  3  -1] -3  5  3  6  7       3
//  1 [3  -1  -3] 5  3  6  7       3
//  1  3 [-1  -3  5] 3  6  7       5
//  1  3  -1 [-3  5  3] 6  7       5
//  1  3  -1  -3 [5  3  6] 7       6
//  1  3  -1  -3  5 [3  6  7]      7

// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
 

// Constraints:

// 1 <= nums.length <= 10^5
// -10^4 <= nums[i] <= 10^4
// 1 <= k <= nums.length


// Optimal Solution but with extra space

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int [] left=new int[n];
        for(int i=0;i<n;i++){
            if(i%k==0){
                left[i]=nums[i];
            }
            else{
                left[i]=Math.max(left[i-1],nums[i]);
            }
        }
        int [] right=new int[n];
        for(int i=n-1;i>=0;i--){
            if(i==n-1 || (i+1)%k==0){
                right[i]=nums[i];
            }
            else{
                right[i]=Math.max(right[i+1],nums[i]);
            }
        }
        int [] ans=new int[n-k+1];
        for(int i=0;i<n-k+1;i++){
            ans[i]=Math.max(right[i],left[i+k-1]);
        }
        return ans;
    }
}

// Complexity Analysis

// Time Complexity -> O(n)
// Space Complexity -> O(n) {we are creating extra arrays for left and right.}
