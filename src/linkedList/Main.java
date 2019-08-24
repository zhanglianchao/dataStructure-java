package linkedList;


public class Main {


	public static void main(String[] args) {
		
		LinkedList<Integer> linkedList = new LinkedList<>();
		for(int i = 0;i < 10;i ++){
			linkedList.addFirst(i);
			System.out.println(linkedList);
		}
		linkedList.add(2,888);
		System.out.println(linkedList);
		for(int i = 100;i < 110;i ++){
			linkedList.addLast(i);
			System.out.println(linkedList);
		}
			
		System.out.println(linkedList.contains(10));

		System.out.println(linkedList.contains(100));
		System.out.println(linkedList.remove(2));
		System.out.println(linkedList);
		System.out.println(linkedList.removeFirst());
		System.out.println(linkedList);
		System.out.println(linkedList.removeLast());
		System.out.println(linkedList);
		
		
		
	}

}
