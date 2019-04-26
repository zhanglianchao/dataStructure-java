package array;

public class ArrayInJava {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[20];
		for(int i=0;i<arr.length;i++)
			arr[i]=i;
		int[] scores = new int[]{11,22,33};
		for(int i=0;i<scores.length;i++)
			System.out.println(scores[i]);
		for(int score:scores)
			System.out.println(score);
		
	}

}
