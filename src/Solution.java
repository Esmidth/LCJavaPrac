import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Great Esmidth on 2016/2/4.
 * Stay Foolish
 */
public class Solution {
	public static boolean hasCycle1(ListNode head) {
		//TLE
		if (head == null) {
			return false;
		}
		if (head.next == null) {
			return false;
		}
		ListNode cur = head;
		List<ListNode> res = new ArrayList<>();
		while (cur != null) {
			for (int i = 0; i < res.size(); i++) {
				if (cur == res.get(i)) {
					return true;
				}
			}
			res.add(cur);
			cur = cur.next;
		}
		return false;
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

	public static boolean hasCycle(ListNode head) {
		//20160207
		//BY MYSELF
		if (head == null) {
			return false;
		}
		if (head.next == null) {
			return false;
		}
		ListNode temp = new ListNode(999);
		ListNode cur = head;
		ListNode next;
		while (cur != null) {
			if (cur == temp) {
				return true;
			}
			next = cur.next;
			cur.next = temp;
			cur = next;
		}
		return false;
	}

	public static ListNode detectCycle2(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return null;
		}
		ListNode temp = new ListNode(999);
		ListNode cur = head;
		ListNode next = null;
		ListNode prev = null;
		while (cur != null) {
			if (cur.next == temp) {
				return cur;
			}
			next = cur.next;
			cur.next = temp;
			cur = next;
		}
		return null;
	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return null;
		}
		ListNode cur = head;
		ListNode next = null;
		while (cur != null) {
			if (cur.val % 911 == 0) {
				ListNode res = cur;
				cur = head;
				while (cur.val % 911 ==0)
				{
					cur.val /= 911;
					cur = cur.next;
				}
				return res;
			}
			cur.val = cur.val * 911;
			cur = cur.next;
		}
		cur = head;
		while (cur != null) {
			cur.val /= 911;
			cur = cur.next;
		}
		return null;

	}


	public static ListNode sortList(ListNode head) {
		//2016.02.07
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}
		List<ListNode> res = new ArrayList<ListNode>();
		ListNode cur = head;
		while (cur != null) {
			res.add(cur);
			cur = cur.next;
		}
		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		};
		Collections.sort(res, comparator);
		for (int i = 0; i < res.size() - 1; i++) {
			res.get(i).next = res.get(i + 1);
		}
		res.get(res.size() - 1).next = null;
		return res.get(0);

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


	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		//2.4.2016
		if (l1 == null && l2 == null) {
			return null;
		}
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode head;
		if (l1.val < l2.val) {
			head = l1;
			l1 = l1.next;
		} else {
			head = l2;
			l2 = l2.next;
		}
		ListNode start = head;

		while (l1 != null && l2 != null)
			if (l1.val <= l2.val) {
				head.next = l1;
				head = head.next;
				l1 = l1.next;
			} else {
				head.next = l2;
				head = head.next;
				l2 = l2.next;
			}
		if (l1 == null) {
			head.next = l2;
			return start;
		} else {
			head.next = l1;
			return start;
		}
	}


	public static ListNode removeNthFromEnd(ListNode head, int n) {
		//2.4.2016
		if (head == null) {
			return null;
		}
		if (head.next == null && n == 1) {
			return null;
		}
		int len = 0;
		ListNode cur = head;
		while (cur != null) {
			len++;
			cur = cur.next;
		}
		cur = head;
		int pos = len - n;
		if (pos < 0) {
			return null;
		}
		if (pos == 0) {
			return head.next;
		}
		for (int i = 0; i < pos - 1; i++) {
			cur = cur.next;
		}
		cur.next = cur.next.next;
		return head;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		ListNode r1 = new ListNode(2);
		ListNode r2 = new ListNode(4);
		ListNode r3 = new ListNode(6);
		ListNode r4 = new ListNode(8);

		r1.next = r2;
		r2.next = r1;


		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l2;

		//display(l1);
		//display(r1);
		display1(detectCycle(l1));
		display1(detectCycle(l2));

		//System.out.print(hasCycle(l2));

	}

}
