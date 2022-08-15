package chat;

import java.util.LinkedList;
import java.util.List;

public class GestoreMessaggi extends Thread {
	
	List<ThreadServer> thread = new LinkedList<ThreadServer>();
	
	public void run(){
		while(true);
	}
	
	synchronized void add(ThreadServer t ) {
		thread.add(t);
	}
	
	synchronized void remove() {
		
	}
	
	synchronized void printAll(String msg ){
		for( ThreadServer t : thread ){
			t.send(msg);
		}
	}
}
