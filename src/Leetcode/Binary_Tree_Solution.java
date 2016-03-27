package Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Great Esmidth on 2016/3/26.
 * Stay Foolish
 */
public class Binary_Tree_Solution {
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
		levelOrder(null);
		System.out.println("HelloBI");
	}

}
