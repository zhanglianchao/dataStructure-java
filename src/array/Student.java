/**
 * 
 */
package array;

/**
 * @author dell
 *
 */

public class Student {

	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}
	private String name;
	private int score;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}
	
	
}
