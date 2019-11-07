package homework19;

import java.util.Stack;

/**
 * Author: lisiyu
 * Created: 2019/11/7
 */

// 用两个栈实现队列

public class QueueBy2Stack {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    // 1. 入队列
    public void offer(int x) {
        // 把 B 中的元素都往 A 中出栈，
        // 全部出栈完成后，再把新元素入队列到 A 中
        while (!B.isEmpty()) {
            int tmp = B.pop();
            A.push(tmp);
        }
        A.push(x);
    }

    // 2. 出队列
    public Integer poll() {
        // 如果是空队列，则不需要出队列
        if (A.isEmpty() && B.isEmpty()) {
            return null;
        }
        // 把 A 中的元素都出栈到 B 中
        while (!A.isEmpty()) {
            int cur = A.pop();
            B.push(cur);
        }
        return B.pop();
    }

    // 3. 取队首元素
    public Integer peek() {
        // 如果是空队列，则不需要出队列
        if (A.isEmpty() && B.isEmpty()) {
            return null;
        }
        // 把 A 中的元素都出栈到 B 中
        while (!A.isEmpty()) {
            int cur = A.pop();
            B.push(cur);
        }
        return B.peek();
    }

    // 4. 判定队列为空
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}
