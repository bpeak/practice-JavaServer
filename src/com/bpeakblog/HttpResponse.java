package com.bpeakblog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class HttpResponse {
	private static final String __rootDir = "C:\\root";
	public String response;
	public HttpResponse(HttpRequest req) {
		File f = new File(__rootDir + req.url);
		
		response = "HTTP/1.1 200";
		response += "Server: Our Java Server/1.0 \r\n";
		response += "Content-Type: text/html \r\n";
		response += "Connection: close \r\n";
		response += "Content-Length: " + f.length() + "\r\n";
		response += "\r\n";
		
		try {
			FileInputStream fis = new FileInputStream(f);
			int s;
			while((s = fis.read()) != -1) {
				response += (char) s;
			}
			fis.close();
			System.out.println("<< HTTP Response >>");
			System.out.println(response);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
