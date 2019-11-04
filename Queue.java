package homework19;

/**
 * Author: lisiyu
 * Created: 2019/11/4
 */

// 用链表实现队列

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
    }
}

public class Queue {
    // head 对应到队首元素
    private Node head = null;
    // tail 对应到队尾元素
    private Node tail = null;
    private int size = 0;

    // 队列的基本操作

    // 1. 入队列
    public void offer(int x) {
        Node newNode = new Node(x);
        // 插入到链表的尾部
        // 1. 空链表
        if (head == null) {
            head = newNode;
            tail = newNode;
            size++;
            return;
        }
        // 2. 非空链表
        tail.next = newNode;
        tail = tail.next;
        size++;
        return;
    }

    // 2. 出队列
    public Integer poll() {
        // 空队列，无法出队列
        if (head == null) {
            return null;
        }
        // 非空队列
        Integer ret = head.val;
        head = head.next;
        if (head == null) {
            // 如果当前队列就只有一个元素，
            // 删除这个元素的同时，也要修改 tail 的指向
            tail = null;
        }
        size--;
        return ret;
    }

    // 3. 取队首元素
    public Integer peek() {
        if (head == null) {
            return null;
        }
        return head.val;
    }

    // 4. 判定队列为空
    public boolean isEmpty() {
        return head == null;
    }

    // 5. 取队列中元素的个数
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        while (!queue.isEmpty()) {
            int curFront = queue.peek();
            System.out.println(curFront);
            queue.poll();
        }
    }
}
