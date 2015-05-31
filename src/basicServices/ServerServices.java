package basicServices;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerServices {

	private ServerSocket sSkt;
	private Socket skt;
	private Thread thread;
	// private ObjectInputStream in;
	// private ObjectOutputStream out;

	public static final int PORT = 9999;

	public ServerServices(Runnable run) throws IOException {
		Thread.currentThread().setPriority(9);
		while (true) {
			sSkt = new ServerSocket(PORT);
			skt = sSkt.accept();
			thread=new socketThread(skt, run);
			thread.setPriority(5);
			thread.start();
		}

	}
}

class socketThread extends Thread{
	
	private Socket skt;
	private Runnable run;
	
	public socketThread(Socket skt,Runnable run) throws IOException {
		super(run);
		this.skt=skt;
		this.run=run;
	}
	

	
}
