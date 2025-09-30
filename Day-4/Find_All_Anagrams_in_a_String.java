// 438. Find All Anagrams in a String


// Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.


// Example 1:

// Input: s = "cbaebabacd", p = "abc"
// Output: [0,6]
// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".


// Example 2:

// Input: s = "abab", p = "ab"
// Output: [0,1,2]
// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".
 

// Constraints:

// 1 <= s.length, p.length <= 3 * 10^4
// s and p consist of lowercase English letters.

// Solution

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int [] freq=new int[26];
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            freq[ch-'a']++;
        }
        List<Integer> ans=new ArrayList<>();
        int lo=0,hi=0;
        while(hi<s.length()){
            char x=s.charAt(hi);
            freq[x-'a']--;
            if(hi-lo+1>p.length()){
                char ch=s.charAt(lo);
                freq[ch-'a']++;
                lo++;
            }
            if(hi-lo+1==p.length() && isZero(freq)){
                ans.add(lo);
            }
            hi++;
        }
        return ans;
    }
    public static boolean isZero(int [] freq){
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
} 

// Complexity Analysis

// Time Complexity -> O(n)
// Space Complexity -> O(26)==O(1)
