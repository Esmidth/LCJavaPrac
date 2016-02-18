import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Great Esmidth on 2/18/16.
 */
public class MyStack {
    private Deque<Integer> deque = new ArrayDeque<>();
    public void push(int x) {
        deque.add(x);
    }

    public void pop() {
        deque.removeLast();
    }

    public int top() {
        return deque.getLast();
    }

    public boolean empty() {
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        MyStack a = new MyStack();
        System.out.println(a.empty());
        a.push(1);
        System.out.println(a.top());
        a.push(2);
        a.push(3);
        System.out.println(a.top());
        a.pop();
        System.out.println(a.top());
    }

}
