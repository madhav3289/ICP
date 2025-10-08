// 150. Evaluate Reverse Polish Notation

// You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
// Evaluate the expression. Return an integer that represents the value of the expression.

// Note that:

// The valid operators are '+', '-', '*', and '/'.
// Each operand may be an integer or another expression.
// The division between two integers always truncates toward zero.
// There will not be any division by zero.
// The input represents a valid arithmetic expression in a reverse polish notation.
// The answer and all the intermediate calculations can be represented in a 32-bit integer.
 

// Example 1:

// Input: tokens = ["2","1","+","3","*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9


// Example 2:

// Input: tokens = ["4","13","5","/","+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6


// Example 3:

// Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
// Output: 22
// Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
// = ((10 * (6 / (12 * -11))) + 17) + 5
// = ((10 * (6 / -132)) + 17) + 5
// = ((10 * 0) + 17) + 5
// = (0 + 17) + 5
// = 17 + 5
// = 22
 

// Constraints:

// 1 <= tokens.length <= 10^4
// tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].


// Stack Based Solution

class Solution {
    public int evalRPN(String[] tokens) {
        int n=tokens.length;
        Set<String> set=new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("/");
        set.add("*");
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            String s=tokens[i];
            if(set.contains(s)){
                int num1=st.pop();
                int num2=st.pop();
                int res=0;
                if(s.equals("+")) res=num1+num2;
                else if(s.equals("-")) res=num2-num1;
                else if(s.equals("*")) res=num1*num2;
                else res=num2/num1;
                st.push(res);
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}

// COMPLEXITY ANALYSIS

// Time Complexity -> O(n)
// Space Complexity -> O(n)
