/**
 * 
 */
package linkedList;

import stack.Stack;

/**
 * @author dell
 *
 */
public class LinkedListStack<E> implements Stack<E> {
	
	private  LinkedList<E> list;
	
	public LinkedListStack(){
		list = new LinkedList<E>();
	} 

	@Override
	public int getSize() {
		
		return list.getSize();
	}

	
	@Override
	public boolean isEmpty() {
		
		return list.isEmpty();
	}

	
	@Override
	public void push(E e) {
		list.addFirst( e);
		
	}

	
	@Override
	public E pop() {
		
		return list.removeFirst();
	}

	
	@Override
	public E peek() {
		return list.getFirst();
	}
	
	@Override
	public String toString(){
		StringBuilder res =new StringBuilder();
		res.append("栈： top");
		res.append(list);
		return res.toString();
	}

	public static void main(String[] args){
		LinkedListStack<Integer> stack = new LinkedListStack<>();
		for(int i =0;i < 10;i ++){
			stack.push(i);
		}

		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
	}
	
	
	
	
}
