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
        // dequeue from head.
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        // get dequeue element
        Node retNode = head;
        // head move
        head = head.next;
        //
        retNode.next = null;
        if (head == null) {
            // if linkedList has only one element, moved head point and tail point set null
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
