package util;

/**
 * @author by Jiangyf
 * @classname LinkedList
 * @description 链表
 * @date 2019/9/28 13:08
 */
public class LinkedList<E> {

    /**
     * 节点内部类
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }

    private Node dummyHead;
    int size;

    public LinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // 从链表中间添加元素 先连后断
    public void add(int index, E e) throws IllegalAccessException {
        // 索引校验
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Add failed. Illegal index.");
        }
        // 创建前置节点
        Node prev = dummyHead;
        // 定位到待插入节点前一个节点，遍历index次原因为 dummyHead为head节点前一个节点
        for (int i = 0; i < index ; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size ++;
    }

    // 从链表头添加元素
    public void addFirst(E e) throws IllegalAccessException {
        add(0, e);
    }

    // 在链表尾部添加元素
    public void addLast(E e) throws IllegalAccessException {
        add(size, e);
    }

    public E get(int index) throws IllegalAccessException {
        // 索引校验
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Get failed. Illegal index.");
        }
        // 定位到head节点
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++)
            cur = cur.next;
        return cur.e;
    }

    public E getFirst() throws IllegalAccessException {
        return get(0);
    }

    public E getLast() throws IllegalAccessException {
        return get(size - 1);
    }

    public void set(int index, E e) throws IllegalAccessException {
        // 索引校验
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index ; i++)
            cur = cur.next;
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) throws IllegalAccessException {
        // 索引校验
        if (index < 0 || index > size) {
            throw new IllegalAccessException("Remove failed. Illegal index.");
        }
        // 定位到待删除节点的前一节点
        Node prev = dummyHead;
        for (int i = 0; i < index - 1 ; i++)
            prev = prev.next;
        // 保存待删除节点
        Node retNode = prev.next;
        // 跨过待删除节点进行连接
        prev.next = retNode.next;
        // 待删除节点next置空
        retNode.next = null;
        size --;
        return retNode.e;
    }

    public E removeFirst() throws IllegalAccessException {
        return remove(0);
    }

    public E removeLast() throws IllegalAccessException {
        return remove(size - 1);
    }






    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null) {
            res.append(cur.e + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
