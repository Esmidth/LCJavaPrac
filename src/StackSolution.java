import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Great Esmidth on 2/20/16.
 */
public class StackSolution {
    public static int calculate(String s) {
        Stack<Integer> level = new Stack<>();
        Stack<Integer> car = new Stack<>();
        int sum = 0;
        int total = 0;
        boolean pos = true;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case ' ':
                    break;
                case '+':
                    pos = true;
                    break;
                case '-':
                    pos = false;
                    break;
                case '(':
                    level.push(sum);
                    if (pos) {
                        car.push(1);
                    } else {
                        car.push(-1);
                    }
                    pos = true;
                    sum = 0;
                    break;
                case ')':
                    sum = sum*car.pop()+level.pop();
                    pos = true;
                    break;
                default:
                    int len = 0;
                    while ((i + len) < s.length() && !(s.charAt(i + len) == ' ' || s.charAt(i + len) == '+' || s.charAt(i + len) == '-' || s.charAt(i + len) == '(' || s.charAt(i + len) == ')')) {
                        len++;
                    }
                    if (pos) {
                        sum += Integer.parseInt(s.substring(i, i + len));
                    } else {
                        sum -= Integer.parseInt(s.substring(i, i + len));
                    }
                    i += len - 1;
                    break;
            }
        }
        return sum;
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case '}':
                    if (!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '[':
                    stack.push(s.charAt(i));
                    break;
                case ']':
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        if (!stack.empty()) {
            return false;
        } else {
            return true;
        }
    }


    static class MinStack {
        private List<Integer> data = new ArrayList<>();
        private int min;


        public void push(int x) {
            if (data.size() == 0) {
                min = x;
            }
            if (x < min) {
                min = x;
            }
            data.add(x);
        }

        public void pop() {
            if (data.get(data.size() - 1) == min) {
                min = data.get(0);
                for (int i = 0; i < data.size() - 1; i++) {
                    if (data.get(i) < min) {
                        min = data.get(i);
                    }
                }
            }
            data.remove(data.size() - 1);
        }

        public int top() {
            return data.get(data.size() - 1);
        }

        public int getMin() {
            return min;
        }
    }

    public static void main(String[] args) {
        System.out.println(calculate("1-(5)"));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(calculate("1 + 1"));
        System.out.println(calculate("2-1 + 2"));
        System.out.println(calculate("2-(5-6)"));

    }
}
