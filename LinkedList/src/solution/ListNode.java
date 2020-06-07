package solution;

/**
 * @author Jiangyf
 * @version 1.0.0
 * @ClassName ListNode
 * @Description 节点类
 * @createTime 2019年11月10日 10:16:00
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {val = x;}

    /**
     * 链表节点构造函数，自定义
     * @param arr
     */
    ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
