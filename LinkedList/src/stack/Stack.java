package stack;

/**
 * @Author: Jiangyanfei
 * @Date: 2019/5/2 11:54
 * @Version 1.0
 */
public interface Stack<E> {

    /**
     * 获取栈内元素容量
     * @return
     */
    int getSize();

    /**
     * 栈空判断
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈
     * @param e
     */
    void push(E e) throws IllegalAccessException;

    /**
     * 出栈
     * @return
     */
    E pop() throws IllegalAccessException;

    /**
     * 获取栈顶元素
     * @return
     */
    E peek() throws IllegalAccessException;

}
