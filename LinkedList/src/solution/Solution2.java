package solution;

/**
 * @author Jiangyf
 * @version 1.0.0
 * @ClassName Solution2
 * @Description TODO
 * @createTime 2019年11月10日 10:33:00
 */
public class Solution2 {

    public ListNode removeElement(ListNode head, int val) {
        // 建立虚拟头结点，保证链表中每一个节点前面均有节点
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        // 链表节点删除
        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val)
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }

        return dummyHead.next;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        ListNode res = new ListNode(arr);
        System.out.println(res);
        new Solution2().removeElement(res, 6);
        System.out.println(res);
    }
}
