package array;
/*
 * 封装自己的数组，动态可扩展
 * 
 */
	//E表示类型
public class ArraySelf<E> {
	private E[] data;
	private int size;//数组大小

	//指定初始容量初始化
	public ArraySelf(int capacity){
		//data = new E[capacity];//Java不支持这种语法
		data =(E[])new Object[capacity];
		size =0;
	}
	//不指定初始容量初始化
	public ArraySelf(){
		this(10);
	}
	
	//获取数组中元素个数
	public int getSize(){
		return size;
	}
	
	//获取数组中元素容量
	public int getCapacity(){
		return data.length;
	}
	
	//是否为空
	public boolean isEmpty(){
		return size==0;
	}
	
	//末尾添加元素
	public void addLast(E e){
		/*if(size==data.length)
			throw new IllegalArgumentException("数组添加元素失败，数组已满");
		
		data[size]=e;
		size++;*/
		//重写
		addAtIndex(size,e);
		
	}
	
	//头添加元素
	public void addFirst(E e){
		addAtIndex(0,e);
	}
	
	
	//指定位置添加新元素
	public void addAtIndex(int index,E e){
		
		if(index<0||index>size)
			throw new IllegalArgumentException("数组添加元素失败，索引非法");
		if(size==data.length){
			resize(2*data.length);
		}
		//throw new IllegalArgumentException("数组添加元素失败，数组已满");

		//依次移位实现后移
		for(int i=size-1;i>=index;i--){
			data[i+1]=data[i];
		}
		data[index]=e;
		size++;
		
	}

	
	//从数组中删除index位置元素，返回删除的元素
	public E remove(int index){
		E res = data[index];
		if(index<0||index>=size)
			throw new IllegalArgumentException("数组删除元素失败，索引非法");
		for(int i=index+1;i<size;i++){
			data[i-1] = data[i];
		}
		data[size] = null;//将不引用的对象置空，正确被垃圾回收
		size--;
		
		if(size == data.length/4 && data.length / 2 != 0 )//  /4才缩小容量，防止时间复杂度震荡，即删除和添加反复操作，
			resize(data.length / 2);
		
		return res;
	}
	
	public E removeFirst(){
		return remove(0);
	}
	public E removeLast(){
		return remove(size-1);
	}
	
	//删除指定元素,只删除第一个
	public void removeElement(int e){
		int index = find(e);
		if(index != -1){
			remove (index);
		}
		
	}
	
	
	//获取指定位置的元素
	public E get(int index){
		if(index<0||index>=size)
			throw new IllegalArgumentException("数组获取元素失败，索引非法");
		return data[index];
	}
	
	//获取最后一个元素
	public E getLast(){
		return get(size-1);
	}
	
	//获取第一个元素
	public E getFirst(){
		return get(0);
	}
	
	
	//修改指定位置的元素
		public void set(int index,E e){
			if(index<0||index>=size)
				throw new IllegalArgumentException("数组修改元素失败，索引非法");
			data[index] = e;
		}
	
		//是否包含某个元素
		public boolean contains(int e) {
			for(int i=0;i<size;i++){
				if(data[i].equals(e))
					return true;
			}
			return false;
		}
		
		//某个元素的索引
		public int find(int e) {
			for(int i=0;i<size;i++){
				if(data[i].equals(e))
					return i;
			}
			return -1;
		}
	
						
	@Override
	public String toString(){
		StringBuilder res = new StringBuilder();
		res.append(String.format("Array:size = %d,capacity = %d \n", size,data.length));
		
	
		res.append('[');
		for(int i=0;i<size;i++){
			res.append(data[i]);
			if(i!=size-1)
				res.append(", ");
		}
		res.append("]");
		return res.toString();
		
	}
	
	/**
	 * @param i
	 */
	private void resize(int newCapacity) {
		E[] newData = (E[]) new Object[newCapacity];
		for(int i = 0;i < size;i++){
			newData[i] = data[i];
		}
		data = newData;
		newData = null;
		
	}
	
	
}
