package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class ReadFile {
	
	String txtFile = "C:\\Users\\dillo\\neonWorkspace\\RMI-Dictionary-Service-Implementation\\dictionary.txt";
	BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ":";
	String[] dict;
	HashMap<String, String> map = new HashMap<String, String>();

	public ReadFile(){
		
	}

	
	public void checkFile() throws Exception{

		br = new BufferedReader(new FileReader(txtFile));
		System.out.println("CHECKFILE");

		while ((line = br.readLine()) != null) {

			// use comma as separator
			dict = line.split(cvsSplitBy);
			map.put(dict[0], dict[1]);
		}
	}
}
