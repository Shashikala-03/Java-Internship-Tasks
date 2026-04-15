import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer {
    static Vector<ClientHandler> clients = new Vector<>();

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            ClientHandler client = new ClientHandler(socket);
            clients.add(client);

            Thread t = new Thread(client);
            t.start();
        }
    }
}

class ClientHandler implements Runnable {
    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public ClientHandler(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }

    public void run() {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                System.out.println("Message: " + message);

                for (ClientHandler client : ChatServer.clients) {
                    client.out.println(message);
                }
            }
        } catch (IOException e) {
            System.out.println("Client disconnected");
        }
    }
}