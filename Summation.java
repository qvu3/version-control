
public class Summation extends Thread {

	private int[] arr;
	
	private int low, high, partial;
	
	public Summation(int[] arr, int low, int high)
	{
		this.arr = arr;
		this.low = low;
		this.high = Math.min(high, arr.length);
	}
	
	public int getPartialSum()
	{
		return partial;
	}
	
	public void run()
	{
		partial = sum(arr, low, high);
	}
	
	// single sum function. This calls the sum method below
	public static int sum(int[] arr)
	{
		return sum(arr, 0, arr.length);
	}
	
	// single sum function
	public static int sum(int[] arr, int low, int high)
	{
		int total = 0;
		
		for (int i = low; i< high; i++)
		{
			total += arr[i];
		}
		
		return total;
	}
	
	// parallel sum function calls the function below it
	public static int parallelSum(int[] arr)
	{
		return parallelSum(arr, Runtime.getRuntime().availableProcessors());
	}
	
	// actual parallel sum function
	public static int parallelSum(int[] arr, int threads)
	{
		int size = (int) Math.ceil(arr.length * 1.0 / threads);
		
		Summation[] sums = new Summation[threads];
		
		for (int i = 0; i < threads; i++)
		{
			sums[i] = new Summation(arr, i * size, (i + 1) * size);
			sums[i].start();
		}
		
		try 
		{
			for (Summation sum : sums)
			{
				sum.join();
			}
		} catch (InterruptedException e) {}
		
		int total = 0;
		
		for (Summation sum : sums)
		{
			total += sum.getPartialSum();
		}
		
		return total;
	}
}
