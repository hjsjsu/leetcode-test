package com.hjsjsu;

import org.junit.Test;

import java.util.HashSet;

public class LinkedListCycleTest {
    @Test
    public void test() {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(0);
        ListNode d = new ListNode(-4);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;
//        boolean b1 = hasCycle(a);
        boolean b1 = hasCycleDoublePointer(a);
        System.out.println("b1 = " + b1);
    }
    public boolean hasCycle(ListNode head) {
        HashSet<Integer> seen = new HashSet<>();
        while (head != null) {
            if (!seen.add(head.val)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }

    public boolean hasCycleDoublePointer(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
