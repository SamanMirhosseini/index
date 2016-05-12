package index;

import java.util.*;
import java.io.*;

public class STOP {
    Vector <String> stop_words;
	File file;
	public STOP(File f){
		this.file = f;
		this.stop_words = new Vector<String>();
		this.MakeTheStop();
	}
	public void MakeTheStop(){
		try {
			Scanner s = new Scanner (this.file);
			while(s.hasNext()){
				this.stop_words.add(s.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
