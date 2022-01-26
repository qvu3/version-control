

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		palindromChecker("hanna","srars","hihshih","dol","unerorenu");
		
		

	}
	
	public static void palindromChecker(String...strings)
	{
		for (String x:strings)
		{
			StringBuilder sb = new StringBuilder(x);
			StringBuilder rsb = sb.reverse();
			String reversedString = rsb.toString();
			if (x.equals(reversedString))
			{
				System.out.println(x);
			}
		}	
	}

}
