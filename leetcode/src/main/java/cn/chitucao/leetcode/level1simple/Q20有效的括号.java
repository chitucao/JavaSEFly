package cn.chitucao.leetcode.level1simple;

import java.util.Stack;

public class Q20有效的括号 {

    public static void main(String[] args) {
        String str = "{[{}]}{}";
        System.out.println(isValidA(str));
    }

    public static boolean isValidA(String s) {
        if (s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
                //pop为临界点，为最后一个压入栈的数据
                //这里的empty用于防止右边的字符大于左边字符长度
            } else if (stack.empty() || c != stack.pop()) {
                return false;
            }
        }
        //防止最终左边的字符大于右边的字符，还有剩余的情况
        return stack.isEmpty();
    }

    public static boolean isValidB(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }


                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
