import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
public class CalculatorClient {
    public static void main(String[] args) {
        final String server_ip = "localhost";
        final int server_port = 9876;
        try(
            Socket socket = new Socket(server_ip, server_port);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        ){
            System.out.println("Connected to Calculator Server... Enter expressions to calculate... Or exit from client");
            String input;
            while(true){
                System.out.print("Expression: ");
                input = userInput.readLine();
                if(input.equalsIgnoreCase("exit")){
                    break;
                }
                out.println(input);
                String result = in.readLine();
                System.out.println("Server: " + result);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
