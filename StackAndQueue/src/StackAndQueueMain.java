import queue.ArrayQueue;
import queue.LoopQueue;
import queue.Queue;
import java.util.Random;

/**
 * 主函数
 */
public class StackAndQueueMain {

    private static double testQueue(Queue<Integer> q, int opCount) {
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

    public static void main(String[] args) {
        int opCount = 100000;
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        Queue<Integer> loopQueue = new LoopQueue<>();
        System.out.println("arrayQueue：" + testQueue(arrayQueue, opCount) + " s");
        System.out.println("loopQueue：" + testQueue(loopQueue, opCount) + " s");
    }
}
