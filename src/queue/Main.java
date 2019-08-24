/**
 * 
 */
package queue;

/**
 * @author dell
 *s
 */
public class Main {

	public static void main(String[] args) {
		ArrayQueue<Integer> queue = new ArrayQueue<>();
		for(int i = 0; i < 100 ; i ++){
			queue.enqueue(i);
		}
		System.out.println(queue.toString());
		
		LoopQueue<Integer> loopQueue = new LoopQueue<>(10);
		for(int i = 0; i < 30 ; i ++){
			loopQueue.enqueue(i);
		}
		loopQueue.dequeue();
		System.out.println(loopQueue.toString());
	}

}
