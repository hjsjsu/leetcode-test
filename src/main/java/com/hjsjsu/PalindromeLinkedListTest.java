package com.hjsjsu;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PalindromeLinkedListTest {
    @Test
    public void test () {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(2);
        ListNode d = new ListNode(1);

        a.next = b;
        b.next = c;
        c.next = d;

        boolean palindrome = isPalindrome(a);
        System.out.println("palindrome = " + palindrome);

    }
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> vals = new ArrayList<>();

        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

//        使用双指针判断是否回文
        int front = 0, back = vals.size() - 1;
        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
