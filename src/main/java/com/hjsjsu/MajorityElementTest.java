package com.hjsjsu;

import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MajorityElementTest {
    @Test
    public void test() {
        int[] arr = {3,2,3};
        int i = majorityElement(arr);
        System.out.println("i = " + i);
    }
    public Map<Integer, Integer> countNums(int @NotNull [] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                countMap.put(num, countMap.get(num) + 1);
            } else {
                countMap.put(num, 1);
            }
        }
        return countMap;
    }
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = countNums(nums);

        Map.Entry<Integer, Integer> majorityEntity = null;
        Set<Map.Entry<Integer, Integer>> entries = counts.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (majorityEntity == null || entry.getValue() > majorityEntity.getValue()) {
                majorityEntity = entry;
            }
        }

        return majorityEntity.getKey();
    }
}
