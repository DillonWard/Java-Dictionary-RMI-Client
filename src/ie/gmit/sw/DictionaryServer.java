package ie.gmit.sw;

import java.rmi.Naming;

public class DictionaryServer {

	public static void main(String[] args) throws Exception {

		if(args.length < 0){
			System.exit(1);
		}
		
		DictionaryService dict = (DictionaryService)Naming.lookup("//localhost/dictionary");
	}
}