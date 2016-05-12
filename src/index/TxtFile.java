package index;
import java.util.*;
import java.io.*;

public class TxtFile extends AllFiles{
	STOP stop;
	public TxtFile(File f,File b){
		super(f);
		this.stop = new STOP(b);
		this.MakeTheIndex();
	}
	public void MakeTheIndex(){
		try {
			Scanner s = new Scanner(this.file);
			s.useDelimiter("\\Z");
			while(s.hasNext()){
			String string = s.next();
			String [] s_array = string.split("[^a-zA-Z0-9\']+");
			for(int i = 0;i < s_array.length;i++){
				if(this.SearchinAllwords(s_array[i]) == -1){
					boolean bool = false;
					for(int k = 0;k < this.stop.stop_words.size();k++){
						if(this.stop.stop_words.get(k).compareToIgnoreCase(s_array[i]) == 0){
							bool = true;
							break;
						}
					}
					if(!bool){
					Word w = new Word (s_array[i]);
					this.AllWords.add(w);
					}
				}
				else{
					int j = this.SearchinAllwords(s_array[i]);
					this.AllWords.get(j).IncreaseNum();
				}
			}
			}
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
