package chat;

import gui.FrameClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	private BufferedReader in;
	private PrintWriter out;
	
	public BufferedReader getIn(){
		return in;
	}
	
	public PrintWriter getOut(){
		return out;
	}
	
	public static void main(String[] args){
		Client c = new Client();
		try {
			Socket s = new Socket("127.0.0.1",8824);
			InputStream is = s.getInputStream();
			c.in = new BufferedReader(new InputStreamReader(is));
			OutputStream os = s.getOutputStream();
			c.out = new PrintWriter(os);
			while(true){
				
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
