/**
 * Created by Great Esmidth on 2016/2/4.
 * Stay Foolish
 */
public class Solution {
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

        while(l1 != null && l2 != null)
            if (l1.val <= l2.val) {
                head.next = l1;
                head= head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        if(l1 == null)
        {
            head.next = l2;
            return start;
        }
        else
        {
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
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(7);
        ListNode l5 = new ListNode(9);

        ListNode r1 = new ListNode(2);
        ListNode r2 = new ListNode(4);
        ListNode r3 = new ListNode(6);
        ListNode r4 = new ListNode(8);

        r1.next = r2;
        r2.next = r3;
        r3.next = r4;


        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        //display(l1);
        //display(r1);
        display(mergeTwoLists(null,null));
    }

}
