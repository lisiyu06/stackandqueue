package homework19;

/**
 * Author: lisiyu
 * Created: 2019/11/3
 */

// 实现一个基础的栈
// 使用数组

public class Stack {
    // 使用一个数组来表示栈
    // 先不考虑扩容
    private int[] array = new int[100];
    private int size = 0;

    // 栈的核心操作

    // 1. 入栈
    public void push(int x) {
        array[size] = x;
        size++;
    }

    // 2. 出栈
    public Integer pop() {
        if (size == 0) {
            return null;
        }
        int ret = array[size - 1];
        size--;
        return ret;
    }

    // 3. 取栈顶元素
    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return array[size - 1];
    }

    // 4. 判定栈为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 5. 栈的大小
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            int curFront = stack.peek();
            System.out.println(curFront);
            stack.pop();
        }
    }

}
