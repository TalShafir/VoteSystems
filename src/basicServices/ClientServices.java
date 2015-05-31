package basicServices;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Collection;

public class ClientServices {

	private Socket skt;
	private ObjectInputStream in;
	private ObjectOutputStream out;

	public ClientServices(InetAddress serverAddress, int port) throws IOException {
		this(new Socket(serverAddress, port));
	}

	public ClientServices(Socket skt) throws IOException {
		this.skt = skt;
		out = new ObjectOutputStream(skt.getOutputStream());
		out.flush();
		in = new ObjectInputStream(new BufferedInputStream(skt.getInputStream()));
	}

	public void sendBatchObjects(final Collection<Object> toSend) throws IOException {

		for (Object object : toSend)
			if (object != null)
				out.writeObject(object);
		out.flush();
	}

	public void sendObject(final Object o) throws IOException {
		if (o != null)
			out.writeObject(o);
		out.flush();
	}

	public Object readObject() throws ClassNotFoundException, IOException {
		Object o;
		do {
			o = in.readObject();
		} while (o == null);
		return o;
	}

	public void close() throws IOException {
		in.close();
		out.close();
		skt.close();
	}
}
