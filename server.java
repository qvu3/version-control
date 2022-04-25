
import java.net.*;
import java.io.*;

public class server {

	public static void main(String[] args) throws IOException {
		try
		{
			int port = 4949, number;
			boolean isprime = true;
			String result = "";
			ServerSocket server = new ServerSocket(port);
			System.out.println("Server started on port " + port);
			Socket client = server.accept();
			DataInputStream in = new DataInputStream(client.getInputStream());
			DataOutputStream out = new DataOutputStream(client.getOutputStream());
			number = in.readInt();
			
			if ( number < 1)
				System.out.println("Number needs to be greater than 1");
			else if (number == 1)
				System.out.println("1 is not Prime");
			else {
				for (int divisor = 2; divisor <= (number/2); divisor++) {
					if ((number % divisor) == 0) {
						isprime = false;
						result = number + " is not prime";
						break;
					}
				}
				if (isprime)
					result = number + " is a prime number";
				else
					result = number + " is a composite number";
			}
			out.writeBytes(result);
			client.close();
			server.close();
		}catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
}
