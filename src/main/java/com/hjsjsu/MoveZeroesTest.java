package com.hjsjsu;

import org.junit.Test;

public class MoveZeroesTest {
    @Test
    public void test() {
        int[] nums = {0,1,0,3,12,2};
        moveZeroes(nums);
    }
    public void moveZeroes(int[] nums) {
        final int length = nums.length;
        int j = 0;

        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }
}
