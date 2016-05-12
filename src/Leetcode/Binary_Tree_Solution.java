package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Great Esmidth on 2016/3/26.
 * Stay Foolish
 */
public class Binary_Tree_Solution {
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        if (root == null) {
            return integerList;
        }
        TreeNode cur = root;
        sub_preorderTraversal(cur, integerList);
        return integerList;
    }

    public static void sub_preorderTraversal(TreeNode root, List<Integer> list) {
        if (root != null)
            list.add(root.val);
        else
            return;
        if (root.left != null) {
            sub_preorderTraversal(root.left, list);
        }
        if (root.right != null) {
            sub_preorderTraversal(root.right, list);
        }
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> integerList = new ArrayList<>();
        List<List<TreeNode>> treeList = new ArrayList<>();
        integerList.add(new ArrayList<Integer>());
        integerList.get(0).add(root.val);
        treeList.add(new ArrayList<TreeNode>());
        treeList.get(0).add(root);
        int i;
        int depth = 0;
        while (true) {
            treeList.add(new ArrayList<TreeNode>());
            int emptyCount = 0;
            for (i = 0; i < treeList.get(depth).size(); i++) {
                if (treeList.get(depth).get(i).left != null) {
                    treeList.get(depth + 1).add(treeList.get(depth).get(i).left);
                } else {
                    emptyCount++;
                }
                if (treeList.get(depth).get(i).right != null) {
                    treeList.get(depth + 1).add(treeList.get(depth).get(i).right);
                } else {
                    emptyCount++;
                }
            }
            if (emptyCount == i << 1) {
                break;
            }
            depth++;
        }
        for (i = 0; i < treeList.size() - 1; i++) {
            integerList.add(new ArrayList<Integer>());
        }
        for (i = 1; i < integerList.size(); i++) {
            for (int j = 0; j < treeList.get(i).size(); j++) {
                integerList.get(i).add(treeList.get(i).get(j).val);
            }
        }
        integerList.remove(integerList.size() - 1);
        return integerList;
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> integerList = new ArrayList<>();
        List<List<TreeNode>> treeList = new ArrayList<>();
        integerList.add(new ArrayList<Integer>());
        integerList.get(0).add(root.val);
        treeList.add(new ArrayList<TreeNode>());
        treeList.get(0).add(root);
        int i;
        int depth = 0;
        while (true) {
            treeList.add(new ArrayList<TreeNode>());
            int emptyCount = 0;
            for (i = 0; i < treeList.get(depth).size(); i++) {
                if (treeList.get(depth).get(i).left != null) {
                    treeList.get(depth + 1).add(treeList.get(depth).get(i).left);
                } else {
                    emptyCount++;
                }
                if (treeList.get(depth).get(i).right != null) {
                    treeList.get(depth + 1).add(treeList.get(depth).get(i).right);
                } else {
                    emptyCount++;
                }
            }
            if (emptyCount == i * 2)
                break;
            depth++;
        }
        for (i = 0; i < treeList.size() - 1; i++) {
            integerList.add(new ArrayList<Integer>());
        }
        for (i = 1; i < integerList.size(); i++) {
            for (int j = 0; j < treeList.get(i).size(); j++) {
                integerList.get(i).add(treeList.get(i).get(j).val);
            }
        }
        integerList.remove(integerList.size() - 1);
        List<List<Integer>> integerListReverse = new ArrayList<>();
        for (int j = integerList.size() - 1; j != -1; j--) {
            integerListReverse.add(integerList.get(j));
        }
        return integerListReverse;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode('F' - 'A');
        TreeNode l11 = new TreeNode('B' - 'A');
        TreeNode l12 = new TreeNode('G' - 'A');
        TreeNode l21 = new TreeNode('A' - 'A');
        TreeNode l22 = new TreeNode('D' - 'A');
        TreeNode l23 = new TreeNode('I' - 'A');
        TreeNode l31 = new TreeNode('C' - 'A');
        TreeNode l32 = new TreeNode('E' - 'A');
        TreeNode l33 = new TreeNode('H' - 'A');

        root.left = l11;
        root.right = l12;

        l11.left = l21;
        l11.right = l22;
        l12.right = l23;
        l22.left = l31;
        l22.right = l32;
        l23.left = l33;

        List<Integer> a = preorderTraversal(root);
        for (int i = 0; i < a.size(); i++) {
            System.out.print((char) (a.get(i) + 'A'));
            System.out.print(" ");
        }


    }

}
