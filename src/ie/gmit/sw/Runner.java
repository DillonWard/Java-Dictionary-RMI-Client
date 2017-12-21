package ie.gmit.sw;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Runner {

	public static void main(String[] args) throws Exception {

		DictionaryService stub = new DictionaryServiceImpl("dictionary.txt"); 
		LocateRegistry.createRegistry(1099);
		Naming.rebind("dictionaryService", stub);
	}
}