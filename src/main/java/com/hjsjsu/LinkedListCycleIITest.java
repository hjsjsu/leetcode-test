package com.hjsjsu;

import org.junit.Test;

import java.util.*;

public class LinkedListCycleIITest {
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

//        ListNode listNode = detectCycle(a);
        ListNode listNode = detectCycleFastSlowPointer(a);
        System.out.println("listNode = " + listNode.val);
    }
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null) {
            if (set.contains(cur)) {
                break;
            }
            set.add(cur);
            cur = cur.next;
        }

        return cur;
    }

    public ListNode detectCycleFastSlowPointer(ListNode head) {
        if (head == null) return null;
        ListNode slow = head, fast = head;

        while(slow != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}
