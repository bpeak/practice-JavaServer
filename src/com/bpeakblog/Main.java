package com.bpeakblog;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	
	private static final int PORT = 80;

	public static void main(String[] args) {
		System.out.println("Running Server...");
		runServer();
	}

	private static final void runServer() {
		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("Client is accessing server ! ");
				ConnectionHandler connectionHandler = new ConnectionHandler(socket);
				System.out.println("--- connection handle thread start ---");
				connectionHandler.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
