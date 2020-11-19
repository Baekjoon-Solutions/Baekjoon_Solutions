import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		BinaryTree Tree = new BinaryTree();
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		s.nextLine();

		while (num > 0) {
			String str = s.nextLine();

			char a = str.charAt(0);
			char b = str.charAt(2);
			char c = str.charAt(4);

			Tree.add(a, b, c);

			num--;
		}

		Tree.Preorder(Tree.getRoot());
		System.out.println();
		Tree.Inorder(Tree.getRoot());
		System.out.println();
		Tree.Postorder(Tree.getRoot());
		System.out.println();
	}

	public static class BinaryTree {
		private TreeNode root;

		public TreeNode getRoot() {
			return root;
		}

		public void setRoot(TreeNode root) {
			this.root = root;
		}

		public void add(Object data, Object leftData, Object rightData) {
			if (root == null) {
				if (!data.equals('.'))
					root = new TreeNode(data);
				if (!leftData.equals('.')) {
					TreeNode newNode = new TreeNode(leftData);
					root.setLeft(newNode);
				}
				if (!rightData.equals('.')) {
					TreeNode newNode = new TreeNode(rightData);
					root.setRight(newNode);
				}
			}
			else
				search(root, data, leftData, rightData);
		}

		public void search(TreeNode root, Object data, Object leftData, Object rightData) {
			if (root == null)
				return;

			else if (root.getData().equals(data)) {
				if (!leftData.equals('.')) {
					TreeNode newNode = new TreeNode(leftData);
					root.setLeft(newNode);
				}
				if (!rightData.equals('.')) {
					TreeNode newNode = new TreeNode(rightData);
					root.setRight(newNode);
				}
			} else {
				search(root.getLeft(), data, leftData, rightData);
				search(root.getRight(), data, leftData, rightData);
			}
		}

		public void Preorder(TreeNode root) {
			if (root == null)
				return;
			System.out.print(root.getData());
			Preorder(root.getLeft());
			Preorder(root.getRight());
		}

		public void Inorder(TreeNode root) {
			if (root == null)
				return;
			Inorder(root.getLeft());
			System.out.print(root.getData());
			Inorder(root.getRight());
		}

		public void Postorder(TreeNode root) {
			if (root == null)
				return;
			Postorder(root.getLeft());
			Postorder(root.getRight());
			System.out.print(root.getData());
		}

		class TreeNode {
			private TreeNode left;
			private TreeNode right;
			private Object data;

			public TreeNode() {
				left = null;
				right = null;
				data = null;
			}

			public TreeNode(Object item) {
				left = null;
				right = null;
				data = item;
			}

			public TreeNode getLeft() {return left;}

			public void setLeft(TreeNode left) {this.left = left;}

			public TreeNode getRight() {return right;}

			public void setRight(TreeNode right) {this.right = right;}

			public Object getData() {return data;}

			public void setData(Object data) {this.data = data;}
		}
	}
}
