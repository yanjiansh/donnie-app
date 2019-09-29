package com.donnie.grow.leetcode.arrayandstring;

public class ReverseString_344 {

    public void reverseString(char[] s) {
        char tmp;
        for (int i=0; i<s.length/2; i++) {
            tmp = s[i];
            s[i] = s[s.length -i -1];
            s[s.length - i - 1] = tmp;
        }
    }

    public String reverseWords(String s) {
        StringBuilder resp = new StringBuilder();
        String[] words = s.split(" ");
        for ( int i=0; i<words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }

        for ( int i=0; i<words.length; i++) {
            resp.append(" ").append(words[i]);
        }

        return resp.toString().trim();
    }

    public static void main(String[] args) {
        ReverseString_344 instance = new ReverseString_344();
        String str = "Let's go";
        System.out.println(instance.reverseWords(str));
    }
}
