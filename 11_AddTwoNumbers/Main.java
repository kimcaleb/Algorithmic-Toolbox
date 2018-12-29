public class Main {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(4);
            ListNode curr = l1;
            curr.next = new ListNode(9);
            curr = curr.next;
            curr.next = new ListNode(9);
            curr = curr.next;
            curr.next = new ListNode(9);
        ListNode l2 = new ListNode(6);
            l2.next = new ListNode(5);
        ListNode answer = addTwoNumbers(l1,l2);
        ListNode curr2 = answer;
        while (curr2 != null) {
            System.out.println(curr2.val);
            curr2 = curr2.next;
        }

    }
	// 40 ms runtime My Solution
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carryOver = 0;
        while (p != null || q != null) {
            if (p == null) {
                int result = q.val + carryOver;
                if (result < 10) {
                    curr.next = new ListNode(result);
                    curr = curr.next;
                    q = q.next;
                    carryOver = 0;
                } else {
                    carryOver = 0;
                    curr.next = new ListNode(result%10);
                    carryOver++;
                    curr = curr.next;
                    q = q.next;
                }
            } else if (q == null) {
                int result = p.val + carryOver;
                if (result <10) {
                    curr.next = new ListNode(result);
                    p = p.next;
                    curr = curr.next;
                    carryOver = 0;
                } else {
                    carryOver = 0;
                    curr.next = new ListNode(result%10);
                    carryOver++;
                    curr = curr.next;
                    p = p.next;
                }

            }  else {
                int result = p.val + q.val + carryOver;
                if (result<10) {
                    curr.next = new ListNode(result);
                    curr = curr.next;
                    carryOver = 0;
                    p = p.next;
                    q = q.next;
                } else {
                    carryOver = 0;
                    curr.next = new ListNode(result%10);
                    curr = curr.next;
                    carryOver++;
                    p = p.next;
                    q= q.next;
                }
            }
        }
        if (carryOver >0) {
            curr.next = new ListNode(carryOver);
        }
        return dummyHead.next;
    }

//Leet Code's Solution 47 ms runtime
    public static ListNode addTwoNumber2(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }



}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x;}
}