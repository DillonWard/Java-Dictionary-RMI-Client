package ie.gmit.sw;

public class Worker {

	ReadFile rf = new ReadFile();

	private String definition;
	
	public void checkList(String word) throws Exception{
		
		rf.checkFile();
		
		System.out.println("Checking.");
		
		if(rf.map.containsKey(word)){
			setDefinition(rf.map.get(word));

			System.out.println(definition);
		}else{
			System.out.println("no");
		}	
		
		System.out.println("Checked.");
	}
	
	
	public void setDefinition(String definition){
		
		this.definition = definition;
	}
	
	public String getDefinition(){
		
		return definition;
	}

	
}
