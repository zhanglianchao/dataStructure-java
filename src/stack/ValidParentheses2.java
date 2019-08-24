/**
 * 
 */
package stack;

/**
 * @author dell
 *
 */
public class ValidParentheses2 {

	public static void main(String[] args) {
		System.out.println(isValid("[][(]"));

	}
	
	private static boolean isValid(String s){
		ArrayStack<Character> stack = new ArrayStack<Character>();
		for(int i = 0;i < s.length();i ++){
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '[')
				stack.push(c);
			else {
				if(stack.isEmpty())
					return false;
				char topChar = stack.pop();
				if(c == ')' && topChar != '(')
					return false;
				if(c == '}' && topChar != '{')
					return false;
				if(c == ']' && topChar != '[')
					return false;
			}
		}
		return stack.isEmpty();
	}

}
