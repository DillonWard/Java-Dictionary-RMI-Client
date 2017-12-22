package ie.gmit.sw;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DictionaryService extends Remote{

	// remote interface
	public String checkWord(String word) throws RemoteException, IOException;
	
}
