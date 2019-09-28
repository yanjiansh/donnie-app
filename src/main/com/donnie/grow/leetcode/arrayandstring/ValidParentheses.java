package com.donnie.grow.leetcode.arrayandstring;

import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ValidParentheses {

    public List<Character> leftList = Arrays.asList('(', '{', '[');
    public List<Character> rightList = Arrays.asList(')', '}', ']');

    public ValidParentheses() {
    }

    public boolean isValid (String s) {
        if ("".equals(s) || null == s) {
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (leftList.contains(c)) {
                stack.push(c);
            } else if (rightList.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character c1 = stack.pop();
                if (!isPair(c1, c)) {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isPair(Character c1, Character c2) {

        if (c1 == '(' && c2 == ')') {
            return true;
        }

        if (c1 == '{' && c2 == '}') {
            return true;
        }

        if (c1 == '[' && c2 == ']') {
            return true;
        }

        return false;
    }
}
