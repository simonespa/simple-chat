package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void main(String[] args){
		try {
			new gui.FrameClient();
			ServerSocket s = new ServerSocket(8824);
			GestoreMessaggi gestore = new GestoreMessaggi();
			gestore.start();
			int ID = 0;
			while(true){
				Socket incoming = s.accept();
				ThreadServer t = new ThreadServer(ID,incoming,gestore);
				gestore.add(t);
				t.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}