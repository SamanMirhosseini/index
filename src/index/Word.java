package index;

public class Word {
	String value;
	Integer HowMany;
	public Word(String s){
		this.value = s;
		this.HowMany = 1;
	}
	public void IncreaseNum(){
		this.HowMany++;
	}
}
