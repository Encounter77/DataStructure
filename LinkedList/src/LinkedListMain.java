import queue.ArrayQueue;
import queue.LinkedListQueue;
import queue.LoopQueue;
import queue.Queue;
import stack.Stack;

import java.util.Random;

/**
 * @author by Jiangyf
 * @classname LinkedListMain
 * @description 链表
 * @date 2019/9/28 11:50
 */
public class LinkedListMain {

    private static double testStack(Stack<Integer> stack, int opCount) throws IllegalAccessException {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i ++)
            stack.push(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < opCount; i ++)
            stack.pop();
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static double testQueue(Queue<Integer> q, int opCount) throws Exception {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) throws Exception {
//        int opCount = 10000000;
//        ArrayStack<Integer> arrayStack = new ArrayStack<>();
//        double time1 = testStack(arrayStack, opCount);
//        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
//        double time2 = testStack(linkedListStack, opCount);
//        System.out.println("ArrayStack：" + time1);
//        System.out.println("LinkedListStack：" + time2);

        int opCount = 100000000;
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> loopQueue = new LoopQueue<>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
//        System.out.println("arrayQueue：" + testQueue(arrayQueue, opCount) + " s");
        System.out.println("loopQueue：" + testQueue(loopQueue, opCount) + " s");
        System.out.println("linkedListQueue：" + testQueue(linkedListQueue, opCount) + " s");
    }
}
