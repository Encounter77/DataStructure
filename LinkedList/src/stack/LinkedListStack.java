package stack;


import util.LinkedList;

/**
 * @author by Jiangyf
 * @classname LinkedListStack
 * @description 链表栈
 * @date 2019/9/28 14:56
 */
public class LinkedListStack<E> implements Stack<E> {

    private LinkedList<E> list;

    public LinkedListStack() {
        this.list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) throws IllegalAccessException {
        list.addFirst(e);

    }

    @Override
    public E pop() throws IllegalAccessException {
        return list.removeFirst();
    }

    @Override
    public E peek() throws IllegalAccessException {
        return list.getFirst();
    }
}
