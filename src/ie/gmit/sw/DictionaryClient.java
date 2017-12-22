package ie.gmit.sw;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DictionaryClient {

	public static void main(String[] args) throws IOException {
		DictionaryService stub = new DictionaryServiceImpl("dictionary.txt"); 
		LocateRegistry.createRegistry(1099);
		Naming.rebind("dictionary", stub);

	}
}
