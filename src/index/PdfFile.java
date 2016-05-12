package index;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PdfFile extends AllFiles{
	PDDocument PDF;
	STOP stop;
	public PdfFile(File f,File b){
		super(f);
		this.stop = new STOP(b);
		this.MakeTheIndex();
	}
	public void MakeTheIndex(){
		try {
			PDF = PDDocument.load(this.file);
			PDFTextStripper stripper = new PDFTextStripper();
			String string = stripper.getText(PDF);
			String [] s_array = string.split("[^a-zA-Z0-9\']+");
			for(int i = 0;i < s_array.length;i++){
				if(this.SearchinAllwords(s_array[i]) == -1){
					if(!stop.stop_words.contains(s_array[i])){
					Word w = new Word (s_array[i]);
					this.AllWords.add(w);
					}
				}
				else{
					int j = this.SearchinAllwords(s_array[i]);
					this.AllWords.get(j).IncreaseNum();
				}
			}
			PDF.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
