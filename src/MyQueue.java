import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Stack;

/**
 * Created by Esmidth on 2/18/16.
 */
public class MyQueue {
    private Stack<Integer> in = new Stack<>();
    private Stack<Integer> out = new Stack<>();

    public void push(int x) {
        in.push(x);
    }

    public void pop() {
        if (!out.empty()) {
            out.pop();
        } else if (in.empty()) {
            return;
        } else {
            while (!in.empty()) {
                out.push(in.pop());
            }
            out.pop();
        }
    }

    public int peek() {
        if(out.empty())
        {
            while (!in.empty())
            {
                out.push(in.pop());
            }
            return out.peek();
        }
        else
        {
            return out.peek();
        }
    }

    public boolean empty() {
        return (in.empty() && out.empty());
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        System.out.println(myQueue.empty());
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        System.out.println(myQueue.empty());

        System.out.println(myQueue.peek());
        myQueue.pop();
        System.out.println(myQueue.peek());


    }
}
