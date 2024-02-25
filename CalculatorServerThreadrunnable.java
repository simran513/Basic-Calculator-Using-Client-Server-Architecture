import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServerThreadrunnable implements Runnable {
    private Socket clientSocket;

    public CalculatorServerThreadrunnable(Socket socket) {
        this.clientSocket = socket;
    }

    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);) {
            String input;
            while ((input = in.readLine()) != null) {
                try {
                    double result = evaluateExpression(input);
                    out.println("Result: " + result);
                } catch (ArithmeticException e) {
                    out.println("Error: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private double evaluateExpression(String expression) {
        try (Scanner scanner = new Scanner(System.in)) {
            double operand1 = scanner.nextDouble();
            String operator = scanner.next();
            double operand2 = scanner.nextDouble();
            switch (operator) {
                case "+":
                    return operand1 + operand2;
                case "-":
                    return operand1 - operand2;
                case "*":
                    return operand1 * operand2;
                case "/":
                    if (operand2 != 0) {
                        return operand1 / operand2;
                    } else {
                        throw new ArithmeticException("Division by zero");
                    }
                default:
                    throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid expression format: " + expression);
        }
    }
}
