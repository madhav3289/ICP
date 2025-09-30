// 567. Permutation in String


// Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
// In other words, return true if one of s1's permutations is the substring of s2.


// Example 1:

// Input: s1 = "ab", s2 = "eidbaooo"
// Output: true
// Explanation: s2 contains one permutation of s1 ("ba").


// Example 2:

// Input: s1 = "ab", s2 = "eidboaoo"
// Output: false
 

// Constraints:

// 1 <= s1.length, s2.length <= 10^4
// s1 and s2 consist of lowercase English letters.

// Solution

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] freq=new int[26];
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            freq[ch-'a']++;
        }
        int lo=0,hi=0;
        while(hi<s2.length()){
            char x=s2.charAt(hi);
            freq[x-'a']--;
            if(hi-lo+1>s1.length()){
                char ch=s2.charAt(lo);
                freq[ch-'a']++;
                lo++;
            }
            if(hi-lo+1==s1.length() && isZero(freq)){
                return true;
            }
            hi++;
        }
        return false;
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
