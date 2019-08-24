/**
 * 
 */
package linkedList;

/**
 * @author dell
 *
 */
public class LinkedList<E> {
	
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
		private Node dummyHead;
		private int size;
		
		//构造方法
		public LinkedList(){
			this.dummyHead = new Node(null,null);
			this.size = 0;
		}
		
		public int getSize(){
			return this.size;
		} 
		
		public boolean isEmpty(){
			return this.size == 0;
		}
		
		//添加元素
		public void add(int index,E e){
			if(index < 0 || index > size)
				throw new IllegalArgumentException("链表索引非法");
		/*	if(index == 0){
				Node newNode = new Node(e);
				newNode.next = head;
				head = newNode;
				head = new Node(e,head);
				size ++;
			}
			
			else{*/
				Node pre = dummyHead;
				for(int i = 0;i < index ;i ++){
					pre = pre.next;
				}
				Node node = new Node(e,pre.next);
				pre.next = node;
				size ++;
			/*}*/
			
		}
		
		public void addFirst(E e){
			add(0,e);
		}

		public void addLast(E e){
			add(size,e);
		}
		
		//获得链表的第index(0-based)个元素
		public E get(int index){
			if(index < 0 || index > size)
				throw new IllegalArgumentException("链表索引非法");
			Node cur = dummyHead.next;
			for(int i = 0;i < index;i ++){
				cur = cur.next;
			}
			return cur.e;
		}
		
		public E getFirst(){
			return get(0);
		}
		
		public E getLast(){
			return get(size - 1);
		}
		
		public void set(int index,E e){
			if(index < 0 || index > size)
				throw new IllegalArgumentException("链表索引非法");
			Node cur = dummyHead.next;
			for(int i = 0;i < index;i ++){
				cur = cur.next;
			}
			cur.e = e;
		}
		
		public boolean contains(E e){
			Node cur = dummyHead.next;
			for(int i = 0;i < size;i ++){
				if(cur.e.equals(e))
					return true;
				cur = cur.next;
			}
			return false;
		}
		
		public E remove (int index){
			Node pre = dummyHead;
			for(int i = 0;i < index;i ++){
				pre = pre.next;
			}
			Node res = pre.next;
			pre.next = res.next;
			res.next = null;
			size --;
			return res.e;
		}
		
		public E removeFirst(){
			return remove(0);
		}
		
		public E removeLast(){
			return remove(size - 1);
		}
		
		@Override
		public String toString(){
			StringBuilder res = new StringBuilder();
			res.append("链表： head ");
			Node cur = dummyHead.next;
			while(cur != null){
				res.append(cur.e + "-->");
				cur = cur.next;
			}
			return res.toString();
		}
}







