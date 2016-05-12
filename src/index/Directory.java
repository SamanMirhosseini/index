package index;
import java.io.*;
import java.util.*;

public class Directory {
	Vector <TxtFile> txt = new Vector<TxtFile>();
	Vector <PdfFile> pdf = new Vector<PdfFile>();
	File stop;
	public Directory(File f){
		this.stop = new File("C:\\Users\\sam\\Desktop\\new\\STOP.txt");
		this.readFromFiles(f);
	}
	public Directory(String s){
		File f = new File(s);
		this.readFromFiles(f);
	}
	/*private void find_stop(File mydir){
        for (File f: mydir.listFiles()){
        	if(!f.isDirectory()){
        	if(f.getName() == "STOP.txt"){
        		System.out.println("yes");
        		this.stop =f;    	
        	}
        	}else 
        //recursively read all the files in the directory
                find_stop(f);
        }   
        }
        */
	private void readFromFiles(File mydir){
		AllFiles help = new AllFiles(mydir);
        for (File f: mydir.listFiles()){
            if (!f.isDirectory()){
                switch(help.getFileExtension(f)){
                case "pdf":
                	PdfFile pdfFile = new PdfFile(f,this.stop);
                	pdf.add(pdfFile);
                break;
                case "txt":
                	TxtFile txtFile = new TxtFile(f,this.stop);
                	txt.add(txtFile);
                break;
                }
            }else {
        //recursively read all the files in the directory
                readFromFiles(f);
            }
        }
    }
	public void find_indexes(String string){
		Vector <String> w = new Vector<String>();
		Vector <Token> tok_vector = new Vector<Token>();
		Tokeniser tok = new Tokeniser(string);
		tok_vector = tok.getTok_vector();
		for(int k = 0;k < tok_vector.size();k++){
			if(tok_vector.get(k).type == Type.word){
				w.add(tok_vector.get(k).value);
			}
		}
		for(int i = 0;i < this.pdf.size();i++){
			CalcP p = new CalcP(string, this.pdf.get(i).file,this.stop);
			if(p.lastvalue == 1){
				System.out.println(this.pdf.get(i).file.getName() +"   " + "Which has:");
				for(int y = 0;y < w.size();y++){
					this.pdf.get(i).Show(w.get(y));
				}
			}
		}
		for(int j = 0;j < this.txt.size();j++){
			CalcT t = new CalcT(string, this.txt.get(j).file,this.stop);
			if(t.lastvalue == 1){
				System.out.println(this.txt.get(j).file.getName()+"   " + "Which has:");
				for(int y = 0;y < w.size();y++){
					this.txt.get(j).Show(w.get(y));
				}
			}
		}
	}
}
