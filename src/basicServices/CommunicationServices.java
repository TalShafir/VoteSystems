package basicServices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

class CommunicationServices {
	
	private File file;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	
	public CommunicationServices(File file) throws FileNotFoundException, IOException {
		this.file=file;
		out = new ObjectOutputStream(new FileOutputStream(file));
		out.flush();
		//in = new ObjectInputStream(new FileInputStream(file));
	}
	public void sendBatchObjects(final Collection<Object> toSend) throws IOException{
		for(Object object : toSend)
			out.writeObject(object);
		out.flush();
	}
	
	public void sendObject(final Object o) throws IOException{
		if(o!=null){
			out.writeObject(o);
			out.flush();
		}
	}
	
	public Object readObject() throws  ClassNotFoundException, IOException{
		do{
			FileInputStream temp=new FileInputStream(file);
			System.out.println(temp==null);
			in=new ObjectInputStream(temp);
			if(in.available()==0){
				in.close();
			}
			else break;
		}while(true);
		Object o=in.readObject();
		in.close();
		return o;
	}
	
	public ArrayList<Object> readBatchObjects() throws FileNotFoundException, IOException, ClassNotFoundException  {
		ArrayList<Object> objects=new ArrayList<>();
		while(in.available()>0)
			objects.add(in.readObject());
		return objects;
	}
	
	public void close() throws IOException{
		in.close();
		out.close();
	}
}
