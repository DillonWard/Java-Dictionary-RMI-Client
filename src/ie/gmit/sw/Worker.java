package ie.gmit.sw;

public class Worker {

	ReadFile rf = new ReadFile();

	public void checkList(String word) throws Exception{
		
		rf.checkFile();
		
		if(rf.map.containsKey(word)){
			String definition = rf.map.get(word);
			System.out.println(definition);
		}else{
			System.out.println("no");
		}
				
	}
	
}
