import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;

public class Server extends JFrame {
	private static final long serialVersionUID = 1L;
	
	public static ServerSocket serverSocket;
	private static Socket socket;
	private static BufferedReader bReader;
	private static InputStreamReader inputStream;
	private static String message = "";

	public Server() {
		setSize(new Dimension(400, 400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) throws IOException {
		new Server();
		try {
			while (true) {
				serverSocket = new ServerSocket(5000);
				socket = serverSocket.accept();
				
				inputStream = new InputStreamReader(socket.getInputStream());
				bReader = new BufferedReader(inputStream);
				message = bReader.readLine();

				System.out.println("Client Sent: " + message);

				inputStream.close();
				bReader.close();
				serverSocket.close();
				socket.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
