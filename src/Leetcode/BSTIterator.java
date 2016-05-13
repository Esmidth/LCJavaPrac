package Leetcode;

import java.util.Stack;

/**
 * Created by Esmidth on 5/13/16.
 */
public class BSTIterator {
//思路从最初就错了
    Stack<TreeNode> stk = new Stack<>();
    int nextmin;

    public BSTIterator(TreeNode root) {
        pushNode(root);
    }

    public boolean hasNext() {
        if (!stk.empty()) {
            TreeNode top = stk.peek();
            stk.pop();
            nextmin = top.val;
            TreeNode cur = top.right;
            if (cur != null) {
                stk.push(cur);
                cur = cur.left;
                while (cur != null) {
                    stk.push(cur);
                    cur = cur.left;
                }
            }
            return true;
        }
        else
            return false;
    }

    public int next() {
        return nextmin;
    }

    public void pushNode(TreeNode root) {
        while (root != null) {
            stk.push(root);
            root = root.left;
        }
    }


}
