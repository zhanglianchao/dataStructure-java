package binarySearchTree;

import java.util.Queue;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.LinkedBlockingQueue;

public class BST<E extends Comparable<E>> {
	
	private class Node{
		E e;
		int deep;
		Node left,right;
		public Node(E e){
			this.e = e;
			this.left = this.right = null;
		}
	}

	private Node root;
	private int size = 0;
	public BST(){
		root = null;
		size = 0;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void add(E e){
		//两种实现方式
	/*	if(size == 0){
			root = new Node(e);
			root.deep = 0;
			root.print = 1;
			size ++;
			return;
		}
		add(root,e);*/
		root = add(root,e,0);
	}
	
	
	private void add(Node node, E e) {
		if(node.e.equals(e))
			return;
		else if(e.compareTo(node.e) < 0 && node.left == null){
			node.left = new Node(e);
			node.left.deep = node.deep + 1;
			size ++;
			return;
		}
		else if(e.compareTo(node.e) > 0 && node.right == null){
			node.right = new Node(e);
			node.right.deep = node.deep + 1;
			size ++;
			return;
		}
		else if(e.compareTo(node.e) < 0){
			add(node.left,e);
		}
		else if(e.compareTo(node.e) > 0){
			add(node.right,e);
		}
		
	}

	private Node add(Node node,E e,int deep){
		if(node == null){
			size ++;
			Node ret = new Node(e);
			ret.deep = deep; 
			return ret;
		}
			
		else if(e.compareTo(node.e) < 0)
			node.left = add(node.left,e,deep + 1);
		else 
			node.right = add(node.right,e,deep + 1);
		return node;
	}
	
	//查询是否包含某个元素
	public boolean contains(E e){
		
		return contains(root,e);
	}
	
	private boolean contains(Node root,E e){
		if(root == null)
			return false;
		if(e.compareTo(root.e) == 0)
			return true;
		else if(e.compareTo(root.e) < 0)
			return contains(root.left,e);
		else 
			return contains(root.right,e);
		
	}
	
	//前序遍历
	public void preOrder(){
		preOrder(root);
	}
	
	private void preOrder(Node root){
		if(root == null)
			return;
		preOrder(root.left);
		System.out.print(root.e + "     ");
		preOrder(root.right);
	}
	
	  // 二分搜索树的非递归前序遍历
    public void preOrderNR(){

        if(root == null)
            return;

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);

            if(cur.right != null)
                stack.push(cur.right);
            if(cur.left != null)
                stack.push(cur.left);
        }
    }

	
	
	
	
	//后序遍历
	public void postOrder(){
		postOrder(root);
	}
	
	private void postOrder(Node root){
		if(root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.e + "     ");
	}
	
	public E removeMax(){
		Node ret = findMaxNode();
		E temp = ret.e;
		root = removeMax(root);
		return temp;
	}
	
	private Node removeMax(Node root){
		if(root == null)
			throw new IllegalAccessError("树为空");
		if(root.right  == null){
			Node ret = root.left;
			root.left = null;
			size --;
			return ret;
		}
			
		
		root.right = removeMax(root.right);
		return root;
	}
	
	
	public E findMin(){
		return findMinNode(root).e;
	}
	
	private Node findMinNode(Node root){
		if(size == 0)
			throw new IllegalAccessError("树为空");
		Node cur = root;
		while(cur.left != null){
			cur = cur.left;
		}
		return cur;
	}
	
	
	public E removeMin(){
		Node ret = findMinNode(root);
		E temp = ret.e;
		root = removeMin(root);
		return temp;
	}
	
	private Node removeMin(Node root){
		if(root == null)
			throw new IllegalAccessError("树为空");
		if(root.left  == null){
			Node ret = root.right;
			root.right = null;
			size --;
			return ret;
		}
		root.left = removeMax(root.left);
		return root;
	}
	
	
	public E findMax(){
		return findMaxNode().e;
	}
	
	private Node findMaxNode(){
		if(size == 0)
			throw new IllegalAccessError("树为空");
		Node cur = root;
		while(cur.right != null){
			cur = cur.right;
		}
		return cur;
	}
	
	
	 // 从二分搜索树中删除元素为e的节点
    public void remove(E e){
        root = remove(root, e);
    }

    // 删除掉以node为根的二分搜索树中值为e的节点, 递归算法
    // 返回删除节点后新的二分搜索树的根
    private Node remove(Node node, E e){

        if( node == null )
            return null;

        if( e.compareTo(node.e) < 0 ){
            node.left = remove(node.left , e);
            return node;
        }
        else if(e.compareTo(node.e) > 0 ){
            node.right = remove(node.right, e);
            return node;
        }
        else{   // e.compareTo(node.e) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = findMinNode(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }

	
	
	
	
	@Override
	public String toString(){
		Queue<Node> q = new LinkedBlockingQueue<>();
		q.add(root);
		int currentDeep = 0;
		while(!q.isEmpty()){
			Node current = q.poll();
			if(current.left != null)
				q.add(current.left);
			if(current.right != null)
				q.add(current.right);
			if(currentDeep == current.deep){
				System.out.print(current.e);
				System.out.print("    ");
			}
			else{
				currentDeep = current.deep;
				if(currentDeep != 0)
					System.out.println("");
				System.out.print(current.e);
				System.out.print("    ");
			}
			
		}
		
		return "";

	}
	
	
	
	
	public static void main(String[] args) {
		BST bst = new BST();
		Random random = new Random();
		for(int i = 0;i < 10;i ++)
		bst.add(random.nextInt(100));
		bst.add(10);
		bst.toString();
		System.out.println("\n" + bst.contains(20));
		//System.out.println(bst.removeMax());
		bst.remove(10);
		bst.toString();
		
		
		/*bst.preOrder();
		System.out.println("");
		bst.postOrder();*/
	}
	
}
