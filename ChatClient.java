import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, PORT);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter your username: ");
            String username = scanner.nextLine();
            out.println(username);  // Send username to server
            
            System.out.println("Connected to the chat server as " + username);

            // Thread to listen for messages
            new Thread(() -> {
                try {
                    // Code that might throw IOException
                } catch (IOException e) {
                    e.printStackTrace();  // Handles the error properly
                }
                
                }
            }).start();

            // Sending messages
            while (true) {
                String message = scanner.nextLine();
                if (message.trim().isEmpty()) {  // Prevent sending empty messages
                    continue;
                }
                out.println(message);
            }
            
                out.println(username + ": " + userMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


