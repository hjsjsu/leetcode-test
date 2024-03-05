package com.hjsjsu;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArrayTest {
    @Test
    public void test() {
        int[] nums = {1,1,2,2,2,3,4,4,5};
        int a = removeDuplicates(nums);
        System.out.println(a);
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                if (q - p > 1) {
                    nums[p+1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }

}
