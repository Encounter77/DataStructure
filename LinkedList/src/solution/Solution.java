package solution;

/**
 * @author Jiangyf
 * @version 1.0.0
 * @ClassName Solution
 * @Description TODO
 * @createTime 2019年11月10日 10:17:00
 */
public class Solution {
    public ListNode removeElement(ListNode head, int val) {
        // 链表头部节点删除
        while (head != null && head.val == val)
            head = head.next;

        // 链表尾部节点删除
        if (head == null) {
            return null;
        }

        // 链表中间部分节点删除
        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return head;
    }


    public ListNode removeElementNew(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElementNew(head.next, val);
        return head.val == val? head.next : head;
    }

}
