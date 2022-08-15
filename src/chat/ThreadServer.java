package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ThreadServer extends Thread {
	int IDnumber;
	private Socket socket;
	private GestoreMessaggi gestore;
	private BufferedReader in;
	private PrintWriter out;
	
	public ThreadServer(int ID, Socket incoming, GestoreMessaggi gestore){
		this.socket = incoming;
		this.gestore = gestore;
		this.IDnumber = ID;
		try{
			InputStream is = socket.getInputStream();
			in = new BufferedReader(new InputStreamReader(is));
			OutputStream os = socket.getOutputStream();
			out = new PrintWriter(os);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run(){
		
		String msg = "";
		try {
			while( true ){
				msg = in.readLine();
				gestore.printAll(msg);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public void send(String msg){
		out.println(msg);
		out.flush();
	}
	
}
