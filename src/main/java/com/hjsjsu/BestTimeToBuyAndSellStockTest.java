package com.hjsjsu;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStockTest {
    @Test
    public void test() {
        int[] prices = {7,1,5,3,6,4};
        System.out.println("maxProfit(prices) = " + maxProfit(prices));
    }
//    public int maxProfit(int[] prices) {
//        int maxProfit = 0;
//        for (int i = 0; i < prices.length; i++) {
//            for (int j = i+1; j < prices.length; j++) {
//                int profit = prices[j] - prices[i];
//                if (profit > maxProfit) {
//                    maxProfit = profit;
//                }
//            }
//        }
//        return maxProfit;
//    }
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxPrice = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxPrice) {
                maxPrice = price - minPrice;
            }
        }
        return maxPrice;
    }
}
