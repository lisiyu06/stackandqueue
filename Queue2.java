package homework19;

/**
 * Author: lisiyu
 * Created: 2019/11/4
 */

// 用数组实现队列

public class Queue2 {
    private int data[] = new int[100];
    // [head, tail)
    private int head = 0;   // 取队首元素的值
    private int tail = 0;   // 取队尾元素的值
    private int size = 0;

    // 1. 入队列，如果插入成功，返回 true ，否则返回 false
    //    如果队列满了，插入就会失败
    public boolean offer(int x) {
        if (size == data.length) {
            return false;
        }
        // 将新元素放在 tail 的位置上
        data[tail] = x;
        tail++;
        if (tail == data.length) {
            tail = 0;
        }
        size++;
        return true;
    }

    // 2. 出队列
    public Integer poll() {
        if (size == 0) {
            return null;
        }
        Integer ret = data[head];
        head++;
        if (head == data.length) {
            head = 0;
        }
        size--;
        return ret;
    }

    // 3. 取队首元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return data[head];
    }

    // 4. 判定为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 5. 取长度
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue2 queue2 = new Queue2();
        queue2.offer(1);
        queue2.offer(2);
        queue2.offer(3);
        queue2.offer(4);
        while (!queue2.isEmpty()) {
            Integer cur = queue2.peek();
            System.out.println(cur);
            queue2.poll();
        }
    }
}
