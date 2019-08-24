/**
 * 
 */
package queue;

/**
 * @author dell
 *
 */
public class LoopQueue<E> implements Queue<E> {
	
	private E[] data;
	private int front,tail;
	private int size;
	
	@SuppressWarnings("unchecked")
	public LoopQueue(int capacity){
		data = (E[]) new Object[capacity + 1];
		front = 0;
		tail = 0;
		size = 0;
	}
	
	public LoopQueue(){
			this(10);
		}
	
	public int getCapacity(){
		return data.length - 1;
	}
	
	@Override
	public boolean isEmpty(){
		return front == tail;
	}
	
	@Override
	public int getSize(){
		return size;
	}
	
	@Override
	public void enqueue(E e){
		if((tail + 1) % data.length == front)
			resize(getCapacity() * 2);
		data[tail] = e;
		tail = (tail + 1) % data.length;
		size ++;
	}

	@Override
	public E dequeue(){
		if(isEmpty())
			throw new IllegalArgumentException("队列为空");
		E ret = data[front];
		front = (front + 1) % data.length;
		size --;
		
		if(size == getCapacity()/4 && getCapacity()/2 != 0)
			resize(getCapacity() / 2);
		
		return ret;
	}
	
	@Override
	public E getFront(){
		if(isEmpty()){
			throw new IllegalArgumentException("队列为空");
		}
		return data[front];	
	}

	private void resize(int newCapacity) {

		@SuppressWarnings("unchecked")
		E[] newData = (E[])new Object[newCapacity+1];
		for(int i = 0;i<size;i++){
			newData[i] = data[(i + front) % data.length];
		}
		data = newData;
		front = 0;
		tail = size;
	}
	
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append("LoopQueue: ");
		res.append("front [");
		for(int i=0;i<size;i++){
			res.append(data[(front + i) % data.length] );
			if(i != size-1)
				res.append(", ");
		}
		res.append("] tail");
		return res.toString();
		
	}
	
}
