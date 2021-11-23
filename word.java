package i192015_A3;

public class word {

	private String word;
	private int frequency;
	
	public word()
	{
		word=null;
		frequency=0;
	}
	
	public void Printword(int i) {
		System.out.println("Word has frequency " + getFrequency()); 		
		
	}
	
	public word(String w,int f)
	{
		this.word=w;
		this.frequency=f;
	}
	
	public String getWord() {
		
		return word;
	}
	
	public void setWord(String word) {
		
		this.word = word;
	}
	
	public int getFrequency() {
		
		return frequency;
	}
	
	public void setFrequency(int f) {
		
		this.frequency = f;
	}
	
}
