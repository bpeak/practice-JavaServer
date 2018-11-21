package com.bpeakblog;

public class HttpRequest {
	public String method;
	public String url;
	public HttpRequest(String requestString) {
		System.out.println(requestString);
		System.out.println("Interpreting the requestString...");
		final String[] lines = requestString.split("\n");
		final String[] firstLines = lines[0].split(" ");
		this.method = firstLines[0];
		this.url = firstLines[1];
		System.out.println("<< HTTP Request >>");
		System.out.println("method : " + this.method);
		System.out.println("url : " + this.url);
	}
}
