import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int currNum = 0;
        int lastSign = '+';
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (lastSign == '+') {
                    st.push(currNum);
                } else if (lastSign == '-') {
                    st.push(-currNum);
                } else if (lastSign == '*') {
                    st.push(st.pop() * currNum);
                } else if (lastSign == '/') {
                    st.push(st.pop() / currNum);
                }

                currNum = 0;
                lastSign = c;
            }
        }

        while (!st.isEmpty()) {
            res = res + st.pop();
        }

        return res;
    }
}

//TC: O(n), SC: O(n)

//Approach - 2
class Solution {
    public int calculate(String s) {
        int calc = 0;
        int tail = 0;
        int currNum = 0;
        int lastSign = '+';
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                currNum = currNum * 10 + c - '0';
            }

            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (lastSign == '+') {
                    calc = calc + currNum;
                    tail = currNum;
                } else if (lastSign == '-') {
                    calc = calc - currNum;
                    tail = -currNum;
                } else if (lastSign == '*') {
                    calc = calc - tail + (tail * currNum);
                    tail = tail * currNum;
                } else if (lastSign == '/') {
                    calc = calc - tail + (tail / currNum);
                    tail = tail / currNum;
                }

                currNum = 0;
                lastSign = c;
            }
        }

        return calc;
    }
}

//TC: O(n), SC: O(1)