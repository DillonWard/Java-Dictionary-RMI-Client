package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.util.HashMap;

public class DictionaryServiceImpl extends UnicastRemoteObject implements DictionaryService {

	private static final long serialVersionUID = 1L;
	
	private String txtFile;
	private BufferedReader br = null;
	private String line = "";
	private String cvsSplitBy = ":";
	private String[] dict;
	
	HashMap<String, String> map = new HashMap<String, String>();

	public DictionaryServiceImpl(String file) throws IOException{
		txtFile = file;
	}
	
	public void readIn() throws IOException{

		br = new BufferedReader(new FileReader(txtFile));

		while ((line = br.readLine()) != null) {

			// use comma as separator
			dict = line.split(cvsSplitBy);
			map.put(dict[0].toLowerCase(), dict[1].toLowerCase());
		}
		
		System.out.println(map);
	}
	
	public String checkWord(String word) throws RemoteException, IOException {

		String res = "";
		
		readIn();
		if(map.containsKey(word)){
			
			res =  map.get(word);
		}else{
			res = "No word found.";
		}
		
		return res;
	}
}
