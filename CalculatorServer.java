import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
public class CalculatorServer{
    public static void main(String[] args) {
        final int port = 9876;
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Calculator Server is running and waiting for connections...");
            while(true){
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);
                // Create a new Thread for each client
                CalculatorServerThreadrunnable clientThread = new CalculatorServerThreadrunnable(clientSocket);
                Thread thread = new Thread();
                thread.start();
            }
        } catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(serverSocket != null){
                    serverSocket.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}