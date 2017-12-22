package ie.gmit.sw;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class DictionaryServer {

	public static void main(String[] args) throws IOException {
		String file = "dictionary.txt";

		DictionaryService dictionaryService = new DictionaryServiceImpl(file); 
		LocateRegistry.createRegistry(1099);
		Naming.rebind("dictionary", dictionaryService);

	}
}
