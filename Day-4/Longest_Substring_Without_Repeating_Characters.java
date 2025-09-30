// 3. Longest Substring Without Repeating Characters

// Given a string s, find the length of the longest substring without duplicate characters.


// Example 1:

// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.


// Example 2:

// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.


// Example 3:

// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3.
// Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

// Constraints:

// 0 <= s.length <= 5 * 10^4
// s consists of English letters, digits, symbols and spaces.

// Optimal Solution(Using Sliding Window)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int lo=0,hi=0;
        int max=0;
        while(hi<n){
            char ch=s.charAt(hi);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.get(ch)>1){
                while(map.get(ch)>1){
                    char c=s.charAt(lo);
                    map.put(c,map.get(c)-1);
                    if(map.get(c)==0){
                        map.remove(c);
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
// Space Complexity -> O(n)
