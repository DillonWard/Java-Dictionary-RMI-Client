package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class ReadFile {

	public static void main(String[] args) throws Exception {

		String csvFile = "dictionary.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		br = new BufferedReader(new FileReader(csvFile));
		
		while ((line = br.readLine()) != null) {

			// use comma as separator
			String[] country = line.split(cvsSplitBy);

			System.out.println("Word - " + country[0] + " , Definition - " + country[1]);

		}

	}
}
