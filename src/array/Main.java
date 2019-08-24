/**
 * 
 */
package array;

/**
 * @author dell
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArraySelf<Integer> arr=new ArraySelf<Integer>(20);
		for(int i=0;i<30;i++)
			arr.addLast(i+1);
		arr.addAtIndex(1, 100);
		arr.addFirst(-1);
		/*System.out.println(arr.contains(0));
		System.out.println(arr.find(1));
		System.out.println(arr.get(10));*/
		System.out.println(arr);
		arr.removeFirst();
		
		System.out.println(arr);
		arr.removeElement(100);
		System.out.println(arr);
		
		ArraySelf<Student> arr2=new ArraySelf<>(20);
		arr2.addFirst(new Student("zhang", 100));
		arr2.addFirst(new Student("li", 99));
		System.out.println(arr2);
		
	}

}
