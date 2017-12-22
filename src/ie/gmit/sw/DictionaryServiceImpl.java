package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.HashMap;

/* Adapted from - (1) https://www.mkyong.com/java/how-to-read-and-parse-csv-file-in-java/
 * Adapted from - (2) https://stackoverflow.com/questions/1789679/get-string-value-from-hashmap-depending-on-key-name
 */
public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {

	private static final long serialVersionUID = 1L;
	
	private String txtFile;
	private BufferedReader br = null;
	private String line = "";
	private String split = ":";
	private String[] dict;
	
	HashMap<String, String> map = new HashMap<String, String>();

	public DictionaryServiceImpl(String file) throws IOException{
		txtFile = file; // the name of the file or 'dictionary' will be passed in here from the server
	}
	
	// Checks the word that is passed in to see if it's in the dictionary (2)
	public String checkWord(String word) throws RemoteException, IOException {

		String res = "";
		
		readFile(); // first populate the dictionary
		if(map.containsKey(word)){// check the word by seeing if it's a key in the hashmap
			
			res =  map.get(word);// if it's a key get the value associated with it
		}else{
			res = "No word found."; // otherwise return this
		}
		
		return res.toLowerCase(); 
	}

	// Read in a file and split the data into a map (1)
	public void readFile() throws IOException{
		InputStream in = getClass().getResourceAsStream(txtFile);
		br = new BufferedReader(new InputStreamReader(in));

		//br = new BufferedReader(new FileReader(txtFile));

		// reads the entire file OR while the file isn't empty continue reading
		while ((line = br.readLine()) != null) {

			dict = line.split(split); // 'split' is what is used to divide the data read in 'Key: Value'
			map.put(dict[0].toLowerCase(), dict[1].toLowerCase()); // the data read in is put into a map in lower case for when comparing
			

		}	
		
		System.out.println(map+"!");
	}
}
