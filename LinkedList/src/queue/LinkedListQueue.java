package queue;

/**
 * @author by Jiangyf
 * @classname LinkedListQueue
 * @description 链表队列
 * @date 2019/9/28 16:35
 */
public class LinkedListQueue<E> implements Queue<E> {

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

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        // 入队 从链表尾部进行
        if (tail == null) {
            // 表示链表为空
            tail = new Node(e);
            head = tail;
        } else {
            // 不为空，指向新创建的元素，尾指针后移
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        // 出队 从链表头部进行
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        // 获取待出队元素
        Node retNode = head;
        // 头指针后移
        head = head.next;
        // 待删除元素与链表断开
        retNode.next = null;
        if (head == null) {
            // 链表中仅有一个元素的情况，头指针移动后变为空链表
            tail = null;
        }
        size --;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }
}
