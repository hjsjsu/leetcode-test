package com.hjsjsu;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequenceTest {
    @Test
    public void test() {
        int[] nums = {100,4,200,1,3,2};
        int i = longestConsecutive(nums);
        System.out.println("i = " + i);
    }
    @Test
    public void test2() {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int i = longestConsecutive(nums);
        System.out.println("i = " + i);
    }

    @Test
    public void test3() {
        int[] nums = {0,0};
        int i = longestConsecutive(nums);
        System.out.println("i = " + i);
    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        int longestStreak = 0;
        for (Integer i : hashSet) {
            if (!hashSet.contains(i - 1)) {
                int currentNum = i;
                int currentStreak = 1;

                while (hashSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
