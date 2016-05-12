package index;

import java.io.File;
import java.util.*;

public class AllFiles {
	File file;
	private String Extension;
	Vector <Word> AllWords = new Vector <Word>();
	public AllFiles (File whichFile){
		this.file = whichFile;
		this.Extension = getFileExtension(this.file);
	}
	public int SearchinAllwords(String arg){
		int help = -1;
		for(int i = 0;i < this.AllWords.size();i++){
			if(this.AllWords.get(i).value.compareToIgnoreCase(arg) == 0){
				help = i;
				break;
			}
		}
		return help;
	}
	public void Show(String arg){
		int j = this.SearchinAllwords(arg);
		switch(j){
		case -1:
			//just for sake of default
		break;
		default:
			System.out.println(this.AllWords.get(j).HowMany + " " +this.AllWords.get(j).value); 
		break;
		}
	}
	public String getExtension() {
		return Extension;
	}
	public void setExtension(String extension) {
		Extension = extension;
	}
	public String getFileExtension(File f){
		return f.getName().substring(f.getName().lastIndexOf(".") + 1);
    }
}

