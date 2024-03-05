package com.hjsjsu;

import org.junit.Test;

import java.util.*;

public class ThreeSumTest {
    @Test
    public void test() {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println("lists = " + lists);

    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            if (first > 0) {
                break;
            }
            if (i != 0 && first == nums[i-1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                if (l != i+1 && nums[l] == nums[l-1]) {
                    l++;
                    continue;
                }
                if (r != nums.length - 1 && nums[r] == nums[r + 1]) {
                    r--;
                    continue;
                }
                if (first + nums[l] + nums[r] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(nums[l]);
                    list.add(nums[r]);
                    result.add(list);
                    l++;
                    r--;
                } else if (first + nums[l] + nums[r] > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return result;
    }
}
