public class lc19 {


      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode ya = new ListNode();
            ya.next=head;
            ListNode second = ya;
            ListNode first = head;
            for(int i=0;i<n-1;i++){
                first=first.next;
            }
            while(first.next!=null){
                second=second.next;
                first=first.next;
            }
            second.next=second.next.next;
            return ya.next;
        }
    }

}
