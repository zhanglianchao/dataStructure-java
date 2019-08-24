/**
 * 
 */
package test;

import java.util.Random;

import linkedList.LinkedListQueue;
import linkedList.LinkedListStack;
import queue.ArrayQueue;
import queue.LoopQueue;
import queue.Queue;
import stack.ArrayStack;
import stack.Stack;

/**
 * @author dell
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//对比栈
		/*ArrayStack<Integer> arrayStack = new ArrayStack<>();
		System.out.println("数组栈：    " + testStack(arrayStack,10000000));
		LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
		System.out.println("链表栈：    " + testStack(linkedListStack,10000000));
*/
		//对比队列
		/*int opCount = 10000000;
		ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
		System.out.println("数组队列：    " + testQueue(arrayQueue,opCount));
		
		LoopQueue<Integer> loopQueue = new LoopQueue<>();
		System.out.println("循环队列：    " + testQueue(loopQueue,opCount));
		
		LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
		System.out.println("链表队列：    " + testQueue(linkedListQueue,opCount));*/
		
	}
	
	
	private static  double  testQueue(Queue<Integer> queue,int opCount){
		long startTime = System.nanoTime();
		Random random = new Random();
		for(int i = 0;i < opCount;i ++){
			queue.enqueue(random.nextInt(Integer.MAX_VALUE));
		}
		for(int i = 0;i < opCount;i ++){
			//System.out.println(i);
			queue.dequeue();
		}
		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}
	
	
	private static  double  testStack(Stack<Integer> stack,int opCount){
		long startTime = System.nanoTime();
		Random random = new Random();
		for(int i = 0;i < opCount;i ++){
			stack.push(random.nextInt(Integer.MAX_VALUE));
		}
		for(int i = 0;i < opCount;i ++){
			//System.out.println(i);
			stack.pop();
		}
		long endTime = System.nanoTime();

		return (endTime - startTime) / 1000000000.0;
	}
	

}
