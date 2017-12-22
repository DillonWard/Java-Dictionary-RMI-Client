package ie.gmit.sw;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/* Adapted from - (1) https://docs.oracle.com/javase/7/docs/technotes/guides/rmi/hello/hello-world.html
 */
public class DictionaryServer {

	public static void main(String[] args) throws IOException {
		String file = "dictionary.txt"; // name of the file to be read in - can be changed to read in a new file

		// creates an instance of the remote object implementation (1)
		// the remote object is exported and is bound to the RMI registry
		DictionaryService dictionaryService = new DictionaryServiceImpl(file); // pass in the name of the file
		LocateRegistry.createRegistry(1099); // RMI registry uses port 1099 in its process
		Naming.rebind("dictionary", dictionaryService); // binds a name to the dictionaryService so it can be used in the 'lookup' service
		System.out.println("Server Ready.");
	}
}