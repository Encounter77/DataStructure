package queue;

/**
 * @Author: Jiangyanfei
 * @Date: 2019/5/2 13:02
 * @Version 1.0
 */
public interface Queue<E> {

    /**
     * 获取队列容量大小
     * @return
     */
    int getSize();

    /**
     * 队列空判断
     * @return
     */
    boolean isEmpty();

    /**
     * 入队
     * @param e
     */
    void enqueue(E e) throws Exception;

    /**
     * 出队
     * @return
     */
    E dequeue();

    /**
     * 获取队首元素
     * @return
     */
    E getFront();
}
