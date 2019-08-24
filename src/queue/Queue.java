/**
 * 
 */
package queue;

/**
 * @author dell
 *
 */
public interface Queue<E> {
	int getSize();
	boolean isEmpty();
	void enqueue(E e);
	E dequeue();
	E getFront();
}
