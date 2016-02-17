import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Great Esmidth on 2016/2/4.
 * Stay Foolish
 */
public class Solution {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode cur1 = l1;
		ListNode cur2 = l2;
		int len1 = 0;
		int len2 = 0;
		while (cur1 != null) {
			len1++;
			cur1 = cur1.next;
		}
		while (cur2 != null) {
			len2++;
			cur2 = cur2.next;
		}
		if (len2 > len1) {
			cur2 = l1;
			cur1 = l2;
		} else {
			cur1 = l1;
			cur2 = l2;
		}

		while (cur2 != null) {
			cur1.val += cur2.val;
			cur2 = cur2.next;
			cur1 = cur1.next;
		}

		if (len2 > len1) {
			cur1 = l2;

		} else {
			cur1 = l1;
		}
		while (cur1 != null) {
			while (cur1.val >= 10) {
				if (cur1.next == null) {
					cur1.next = new ListNode(1);
				} else {
					cur1.next.val += 1;
				}
				cur1.val -= 10;
			}
			cur1 = cur1.next;
		}
		if (len2 > len1) {
			return l2;
		} else {
			return l1;
		}
	}

	public static ListNode mergeKList(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}
		if (lists.length == 1) {
			return lists[0];
		}
		List<ListNode> temp = new ArrayList<ListNode>();
		for (int i = 0; i < lists.length; i++) {
			ListNode cur = lists[i];
			while (cur != null) {
				temp.add(cur);
				cur = cur.next;
			}
		}
		Comparator<ListNode> comparator = new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		};
		Collections.sort(temp, comparator);
		for (int i = 0; i < temp.size() - 1; i++) {
			temp.get(i).next = temp.get(i + 1);
		}
		if (temp.size() == 0) {
			return null;
		}
		return temp.get(0);
	}


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

	public static ListNode detectCycle3(ListNode head) {
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
				while (cur.val % 911 == 0) {
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

	public static ListNode detectCycle(ListNode head) {
		ListNode slowptr = head;
		ListNode fastptr = head;
		while (fastptr != null && fastptr.next != null) {
			slowptr = slowptr.next;
			fastptr = fastptr.next.next;
			if (slowptr == fastptr) {
				break;
			}
		}
		if (fastptr == null || fastptr.next == null) {
			return null;
		}
		slowptr = head;
		while (slowptr != fastptr) {
			slowptr = slowptr.next;
			fastptr = fastptr.next;
		}
		return slowptr;
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
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(-4);
		ListNode l5 = new ListNode(5);

		ListNode r1 = new ListNode(9);
		ListNode r2 = new ListNode(9);
		ListNode r3 = new ListNode(4);
		ListNode r4 = new ListNode(8);


		r1.next = r2;
		display(l1);
		//display(r1);
		display(addTwoNumbers(l1, r1));

		//System.out.print(hasCycle(l2));

	}

}
