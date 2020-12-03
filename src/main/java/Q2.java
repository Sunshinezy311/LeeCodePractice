public class Q2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        int temp = l1.val + l2.val;
        res.val = temp % 10;
        int carry = temp / 10;
        ListNode index = res;
        while (l1.next != null || l2.next != null) {
            index.next = new ListNode();
            index = index.next;
            if (l1.next == null) {
                l2 = l2.next;
                index.val = (l2.val + carry) % 10;
                carry = (l2.val + carry) / 10;
            } else if (l2.next == null) {
                l1 = l1.next;
                index.val = (l1.val + carry) % 10;
                carry = (l1.val + carry) / 10;
            } else {
                l1 = l1.next;
                l2 = l2.next;
                index.val = (l1.val + l2.val + carry) % 10;
                carry = (l1.val + l2.val + carry) / 10;
            }
        }
        if (carry!=0){
            index.next = new ListNode(1,null);
        }
        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9,null)));
        ListNode l2 = new ListNode(9, new ListNode(9, null));
        ListNode res = addTwoNumbers(l1, l2);
        System.out.println(res);
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
