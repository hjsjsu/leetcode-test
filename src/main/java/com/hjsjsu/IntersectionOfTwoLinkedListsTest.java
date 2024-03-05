package com.hjsjsu;

import org.junit.Test;

public class IntersectionOfTwoLinkedListsTest {
    @Test
    public void Test() {
        ListNode headA = new ListNode(4);
        ListNode headA1 = new ListNode(1);
        ListNode headA2 = new ListNode(8);
        ListNode headA3 = new ListNode(4);
        ListNode headA4 = new ListNode(5);

        headA.next = headA1;
        headA1.next = headA2;
        headA2.next = headA3;
        headA3.next = headA4;

        ListNode headB = new ListNode(5);
        ListNode headB1 = new ListNode(6);
        ListNode headB2 = new ListNode(1);
        ListNode headB3 = new ListNode(8);
        ListNode headB4 = new ListNode(4);
        ListNode headB5 = new ListNode(5);

        headB.next = headB1;
        headB1.next = headB2;
        headB2.next = headB3;
        headB3.next = headB4;
        headB4.next = headB5;

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println("intersectionNode = " + intersectionNode);
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        // 1.让二者分别走到链表末尾，测出各自长度
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != null) {
            pA = pA.next;
            ++lenA;
        }
        while (pB != null) {
            pB = pB.next;
            ++lenB;
        }
        pA = headA;
        pB = headB;
        // 2.得到分别链长的差值，让长的先走这个差值
        int diff = lenA - lenB;
        if (diff > 0) {
            int step = diff;
            while (step > 0) {
                pA = pA.next;
                --step;
            }
        } else if (diff < 0) {
            int step = diff;
            while (step < 0) {
                pB = pB.next;
                ++step;
            }
        }
        // 3.两指针往前走，相遇即为所求
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }

    public int eachListNode(ListNode listNode) {
        ListNode cur = listNode;
        int val = 0;
        while (cur != null) {
            val = cur.val;
            cur = cur.next;
        }
        return val;
    }
}

