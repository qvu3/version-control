import java.util.Random;

public class CompareSingleVsParallel {

	public static void main(String[] args) {
		
		Random rand = new Random();
		
		int[] arr = new int[200000000];
		
		for (int i = 0; i < arr.length; i++)
		{
			arr[i] = rand.nextInt(10) + 1;
		}
		
		long start = System.currentTimeMillis();
		
		System.out.println("Single result: " + Summation.sum(arr));
		
		System.out.println("Single runtime: " + (System.currentTimeMillis() - start));
		
		start = System.currentTimeMillis();
		
		System.out.println("Parallel result: " + Summation.parallelSum(arr));
		
		System.out.println("Parallel runtime: " + (System.currentTimeMillis() - start));
		
	}

}
