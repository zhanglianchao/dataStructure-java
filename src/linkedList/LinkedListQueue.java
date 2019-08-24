/**
 * 
 */
package linkedList;

import queue.Queue;

/**
 * @author dell
 *
 */
public class LinkedListQueue<E> implements Queue<E>{
	private class Node{
		private E e;
		private Node next;
		
		public Node(){
			this.e = null;
			this.next = null;
		}
		
		public Node(E e){
			this.e = e;
			this.next = null;
		}
		
		public Node(E e,Node next){
			this.e = e;
			this.next = next;
		}
		
	}
	
	
	private Node head,tail;
	private int size;
	
	public LinkedListQueue(){
		head = null;
		tail = null;
		size = 0;
	}
	
	@Override
	public int getSize() {
		
		return size;
	}


	@Override
	public boolean isEmpty() {
		
		return size == 0;
	}


	@Override
	public void enqueue(E e) {
		if(size == 0){
			head = new Node(e);
			tail = head;
			size ++;
		}
		else{
			tail.next = new Node(e);
			tail = tail.next;
			size ++;
		}
	}


	@Override
	public E dequeue() {
		if(isEmpty())
			throw new IllegalArgumentException("队列为空");
		Node res = head;
		head = head.next;
		res.next = null;
		if(head == null)
			tail = null;
		size --;
		return res.e;
	}


	@Override
	public E getFront() {
		return head.e;
	}
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("队列：  front  ");
		Node cur = head;
		while(cur != null){
			res.append(cur.e + "-->");
			cur = cur.next;
		}
		res.append("null tail");
		return res.toString();
	}
	

	public static void main(String[] args){
		LinkedListQueue<Integer> queue = new LinkedListQueue<>();
		for(int i = 0;i < 10;i ++){
			queue.enqueue(i);
			System.out.println(queue);
		}
		for(int i = 0;i < 10;i ++){
			queue.dequeue();
			System.out.println(queue);
		}
		
	}

}