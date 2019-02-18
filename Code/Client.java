import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		String number = "";
		Scanner scanner = new Scanner(System.in);
		Socket socket = new Socket("127.0.0.1", 5000);
		PrintStream printStream = new PrintStream(socket.getOutputStream());

		while (!number.equals("stop")) {



			System.out.println("Enter any number");

			number = scanner.nextLine();


			printStream.println(number);

		}
	}
}
