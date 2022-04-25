
import java.net.*;
import java.io.*;

public class client {

	public static void main(String[] args) throws IOException {
		try
		{
			int port = 4949, number=0;
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Socket client started");
			Socket server = new Socket("127.0.0.1",port);
			BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
			DataOutputStream out = new DataOutputStream(server.getOutputStream());
			System.out.println("Connected to server 127.0.0.1 on port " + port);
			System.out.print("Please enter a number:");
			number = Integer.parseInt(br.readLine());
			out.writeInt(number);
			String result = in.readLine();
			System.out.println("Server: " + result);
			server.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
