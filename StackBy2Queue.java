package homework19;

import java.util.LinkedList;

/**
 * Author: lisiyu
 * Created: 2019/11/6
 */

// 用两个队列实现栈

public class StackBy2Queue {
    // A始终是用来入栈的
    // B始终是空的（辅助取栈顶元素和出栈的）
    private LinkedList<Integer> A = new LinkedList<>();
    private LinkedList<Integer> B = new LinkedList<>();

    // 1. 入栈
    public void push(int x) {
        A.offer(x);
    }

    // 2. 出栈
    // 删除堆栈顶部的元素并返回该元素。
    public int pop() {
        // 需要将 A 中的元素全部出队列到 B 中，一直到 A 中只有一个元素
        // 就可以真正的出栈了
        // 最后要互换 A 和 B
        // 空栈的情况，直接返回
        if (A.isEmpty()) {
            return 0;
        }
        while (A.size() > 1) {
            int cur = A.removeFirst();
            B.addLast(cur);
        }
        // 最终要出栈的元素
        int ret = A.removeFirst();
        // 交换 AB
        swapAB();
        return ret;
    }

    private void swapAB() {
        LinkedList<Integer> tmp = A;
        B = A;
        B = tmp;
    }

    // 3. 取栈顶元素
    public int top() {
        if (A.isEmpty()) {
            return 0;
        }
        while (A.size() > 1) {
            int cur = A.removeFirst();
            B.addLast(cur);
        }
        int ret = A.removeFirst();
        B.addLast(ret);
        swapAB();
        return ret;
    }

    // 4. 判定栈为空
    public boolean empty() {
        return A.isEmpty();
    }
}
