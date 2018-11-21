package com.bpeakblog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler extends Thread{
	
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	
	public ConnectionHandler(Socket socket) {
		try {
			this.socket = socket;
			InputStream inputStream = socket.getInputStream();
			this.br = new BufferedReader(new InputStreamReader(inputStream));	
			this.pw = new PrintWriter(socket.getOutputStream());
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			String requestString = "";
			while(br.ready()) {
				requestString += (char) br.read();
			}
			HttpRequest req = new HttpRequest(requestString);
			HttpResponse res = new HttpResponse(req);
			pw.write(res.response);
			pw.close();
			br.close();
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
