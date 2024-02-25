# Basic-Calculator-Using-Client-Server-Architecture

## Introduction
- This project centers around the creation of a console-based calculator application using Java and implementing a client-server architecture. The primary focus is on acquiring proficiency in socket programming, a crucial aspect of networked applications. The application enables communication between clients and a server through Java sockets, facilitating the exchange of mathematical expressions and results in real-time. The incorporation of server-side multithreading enhances the system's efficiency, allowing simultaneous handling of multiple client connections.
- Clients interactively input mathematical expressions through the console, sending requests to the server for computation. The server, equipped with robust error-handling mechanisms, processes these expressions, providing detailed feedback in case of arithmetic exceptions. The project places emphasis on creating an interactive user interface, ensuring a seamless experience for users interacting with the calculator. While limited to console-based interaction, the project serves as a foundational exploration into socket programming, multithreading, and client-server communication, offering valuable insights into networked application development.

## Problem Statement
- The core challenge of this project lies in developing a console-based calculator application that operates on a client-server architecture using Java. The user interacts with the system by entering mathematical expressions through the console on the client side. These expressions are then transmitted to the server using Java sockets for processing. The server, implemented with server-side multithreading, handles the computational tasks efficiently, ensuring concurrent processing of multiple client requests.
- Upon receiving the mathematical expressions, the server performs the necessary calculations and returns the results to the clients. The system incorporates error-handling mechanisms to address arithmetic exceptions, providing informative feedback to the users through the console interface. The communication between the clients and the server relies on socket programming, establishing a networked data exchange infrastructure. 
- The server processes the mathematical expressions, performs calculations, and sends results back to the clients. Constraints play a vital role in shaping the project. The application is confined to console-based interaction, restricting the use of graphical user interfaces. Furthermore, the communication is text-based, limiting the sophistication of user interactions. The project focuses on arithmetic calculations and error handling, excluding advanced functionalities or persistent storage mechanisms. These constraints emphasize the project's simplicity and serve as a foundation for understanding key aspects of client-server architecture and socket programming.

## Methodology
#### Algorithm
- Socket class:
Socket is a class in Java that represents a client's endpoint for communication with the server. The accept() method of ServerSocket returns a Socket instance when a client connects to the server.
- try-catch-finally block:
The code is wrapped in a try-catch block to handle potential exceptions, particularly IOException. IOExceptions can occur when working with sockets, such as if there's an issue with the network connection.
- ServerSocket instantiation:
ServerSocket serverSocket = new ServerSocket(PORT);: This line creates a new ServerSocket instance that binds to a specific port (9876 in this case) and listens for incoming client connections.
- Infinite While Loop:
while (true) { ... }: The server runs in an infinite loop, continuously waiting for clients to connect.
- Accepting Client Connection:
Socket clientSocket = serverSocket.accept();: This line blocks until a client connects to the server. Once a connection is established, it returns a Socket instance representing the connection.
- Thread Creation:
CalculatorServerThread clientThread = new CalculatorServerThread(clientSocket);: A new instance of CalculatorServerThread is created for each client, passing the client's socket to the thread.
- Thread Start:
Thread thread = new Thread(clientThread); and thread.start();: A new thread is created for each client, and the start() method is called to begin the execution of the thread. This allows the server to handle multiple clients concurrently.
- ClientThread Class:
The assumption is that there is a class named CalculatorServerThread that implements the Runnable interface and contains the logic for handling communication with a specific client.
- ServerSocket Closing in Finally Block:
serverSocket.close();: In the finally block, the server socket is closed to release the port when the server is stopped or encounters an exception.

## Result and Interpretation
All the three Client Command Prompts are connected with a single Server Command Prompt which simultaniously 
Accept the connection requests from all of the Client Command Prompts that are requesting it to connect. The Server side uses Multi-threading to provide simultanious execution. After the connection was establishes the client provide some expression and the server evaluate the expression and print the result of the expression provided by the client part.
- Example:-
Client Side: 
Expression: 3 + 2 // finding the value of the expreesion(It displayed on client window)
Server side:	
  Server: Result: 5//evaluate and print the value(It also displayed on client window)

## Conclusion
In conclusion, the project delivers a functional console-based calculator that employs socket programming and server-side multithreading. The application provides an interactive client interface with robust error handling, showcasing proficiency in Java programming and networking concepts. The constraints highlight the simplicity and scope of the project, serving as a foundational exercise in client-server architecture.
