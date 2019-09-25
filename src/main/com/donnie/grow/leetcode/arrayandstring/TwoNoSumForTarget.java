package com.donnie.grow.leetcode.arrayandstring;

import java.util.HashMap;
import java.util.Map;

/**
 * "两数之和"
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class TwoNoSumForTarget {

    /*O(N*N)*/
    public int[] towSum1 (int[] nums, int target) {
        int[] res = new int[2];
        for ( int i = 0; i < nums.length-1; i++) {
            res[0] = i;
            int b = target - nums[i];
            for ( int j = i + 1; j < nums.length; j++) {
                if ( b == nums[j] ) {
                    res[1] = j;
                    return res;
                }
            }
        }
        return new int[2];
    }

    /*O(N)*/
    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for ( int i = 0; i < nums.length; i++) {
            res[1] = i;
            if ( map.containsKey(nums[i])) {
                res[0] = map.get(nums[i]);
                return res;
            }
            int tmp = target - nums[i];
            if (!map.containsKey(tmp)) {
                map.put(tmp, i);
            }
        }
        return new int[2];
    }
}
