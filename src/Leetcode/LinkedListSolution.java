package Leetcode;

import java.util.*;

/**
 * Created by Great Esmidth on 2016/2/4.
 * Stay Foolish
 */
public class LinkedListSolution {
	public static ListNode partition(ListNode head, int x) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		ListNode lessHead;
		ListNode greatHead;
		ListNode less = new ListNode(-999);
		ListNode greater = new ListNode(999);
		lessHead = less;
		greatHead = greater;
		List<ListNode> lists = new ArrayList<>();
		while (head != null) {
			lists.add(head);
			head = head.next;
		}
		head = lists.get(0);
		for (int i = 0; i < lists.size(); i++) {
			if (lists.get(i).val >= x) {
				greater.next = lists.get(i);
				greater = greater.next;
			} else {
				less.next = lists.get(i);
				less = less.next;
			}
		}
		greater.next = null;
		less.next = greatHead.next;
		return lessHead.next;
	}

	public static ListNode reverseKGroup(ListNode head, int k) {
		ListNode tempHead = new ListNode(-999);
		ListNode tempH;
		ListNode temp;
		Stack<ListNode> stack = new Stack<>();
		tempHead.next = head;
		ListNode cur = head;
		int len = 0;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		cur = tempHead;
		tempH = tempHead;
		cur = cur.next;
		while (len >= k) {
			for (int i = 0; i < k; i++) {
				stack.push(cur);
				cur = cur.next;
			}
			temp = cur;
			cur = tempH;
			while (!stack.empty()) {
				cur.next = stack.pop();
				cur = cur.next;
			}
			cur.next = temp;
			len -= k;
			tempH = cur;
			cur = cur.next;
		}
		return tempHead.next;
	}


	public static boolean hasCycle2(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev == head && head != null && head.next != null;
	}


	public static void display(ListNode head) {
		if (head == null) {
			System.out.println("FUCKING A EMPTY POINTER");
			return;
		}
		while (head != null) {
			System.out.print(head.val);
			System.out.print("--> ");
			head = head.next;
		}
		System.out.println();
	}

	public static void display1(ListNode node) {
		if (node == null) {
			System.out.println("FUCKING A NULL POINTER");
			return;
		}
		System.out.println(node.val);
	}


	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(2);
		ListNode l7 = new ListNode(5);

		ListNode r1 = new ListNode(1);
		ListNode r2 = new ListNode(1);
		ListNode r3 = new ListNode(2);
		ListNode r4 = new ListNode(2);


		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		r1.next = r2;
		r2.next = r3;
		r3.next = r4;


		display(l1);
		//display(r1);
		display(partition(null, 3));

		//System.out.print(hasCycle(l2));

	}

}
