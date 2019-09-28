package util;

/**
 * @Author: Jiangyanfei
 * @Date: 2019/4/27 11:35
 * @Version 1.0
 */
public class Array<E> {

    /**
     * 泛型数组
     */
    private E[] data;

    /**
     * 数组实际元素个数
     */
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * 获取数组元素的个数
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组容量
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 获取index索引处的元素
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is incorrect");
        }
        return data[index];
    }

    /**
     * 获取最后一个元素
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 获取第一个元素
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 查询数组是否存在元素e
     */
    public boolean contains(E e) {
        for (E element : data) {
            if (element.equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查询数组中元素e是否存在，返回索引，不存在返回 -1
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 改变index索引出的元素值
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is incorrect");
        }
        data[index] = e;
    }


    /**
     * 数组扩容方法
     */
    private void resize(int newCapacity) {
        E[] newData = ((E[]) new Object[newCapacity]);
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    /**
     * 指定索引处添加元素
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is incorrect");
        }
        // 数组扩容判断
        if (size == data.length) {
            resize(data.length * 2);
        }
        // 插入元素核心代码，指定索引后数组元素整体后移
        for (int i = size -1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }

    /**
     * 数组尾部添加元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 数组首部添加元素
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 指定索引处删除元素
     */
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Index is incorrect");
        }
        // 保存待删除数组元素
        E res = data[index];
        // 删除元素核心代码，指定索引后数组整体前移
        for (int i = index + 1; i < size; i++) {
            data[i-1] = data[i];
        }
        size --;
        // 数组缩容判断
        if (size == data.length / 4 && data.length /2 != 0) {
            resize(data.length / 2);
        }
        return res;
    }

    /**
     * 删除数组最后一个元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 删除数组第一个元素
     */
    public E removeFirst() {
        return remove(0);
    }
}
