// 40. Combination Sum II

// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

// Each number in candidates may only be used once in the combination.

// Note: The solution set must not contain duplicate combinations.

 

// Example 1:

// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: 
// [
// [1,1,6],
// [1,2,5],
// [1,7],
// [2,6]
// ]


// Example 2:

// Input: candidates = [2,5,2,1,2], target = 5
// Output: 
// [
// [1,2,2],
// [5]
// ]
 

// Constraints:

// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30

// Recursive Solution

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        helper(candidates,target,ans,new ArrayList<>(),0);
        return ans;
    }
    public static void helper(int [] nums,int target,List<List<Integer>> ans,List<Integer> temp,int idx){
        if(target==0){
            ans.add(new ArrayList<>(temp));            
            return;
        }
        if(target<0){
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(i>idx && nums[i]==nums[i-1]){
                continue;
            }
            temp.add(nums[i]);
            helper(nums,target-nums[i],ans,temp,i+1);
            temp.remove(temp.size()-1);
        }
    }
}

// COMPLEXITY ANALYSIS

// Time Complexity -> O(2^n × k + nlogn)
// Space Complexity -> O(k)             (excluding output list)
