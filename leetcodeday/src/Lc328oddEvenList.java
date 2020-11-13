public class Lc328oddEvenList {

//    给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
//
//    请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
//
//    示例 1:
//
//    输入: 1->2->3->4->5->NULL
//    输出: 1->3->5->2->4->NULL
//    示例 2:
//
//    输入: 2->1->3->5->6->4->7->NULL
//    输出: 2->3->6->7->1->5->4->NULL



//      Definition for singly-linked list.
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {

        //空链表则直接返回头指针
        if(head == null) return head;
        //dummy 指向偶数链表的头结点
        ListNode dummy = head.next;

        ListNode odd = head;//奇指针
        ListNode even = head.next;//偶指针


        while(odd.next != null && even.next != null){
            odd.next = even.next;
            odd = even.next;

            if(odd.next != null){
                even.next = odd.next;
                even = odd.next;
            }
        }

        //如果链表只有一个节点，忽略此步
        if(even!= null) even.next = null;

        //奇数链表指向偶数链表的头指针
        odd.next = dummy;
        return head;
    }
}
