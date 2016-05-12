package index;

import java.io.*;
import java.util.*;

public class TheMainClass  {
	public static void main(String []args) {
	Scanner s = new Scanner(System.in);
	File f = new File("C:\\Users\\sam\\Desktop\\new");
	String what = s.nextLine();
	Directory directory = new Directory(f);
	directory.find_indexes(what);
	s.close();
	}
}
/*File pdf = new File("C:\\Users\\sam\\Downloads\\Documents\\cpptutorial.pdf");
PDDocument p;
Scanner s;
try {
	s = new Scanner(f);
	s.useDelimiter("\\Z");
	System.out.println(s.next());
} catch (FileNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
try {
	p = PDDocument.load(pdf);
	PDFTextStripper elio = new PDFTextStripper();
	String j = elio.getText(p);
} catch (IOException e2) {
	// TODO Auto-generated catch block
	e2.printStackTrace();
}
String s1 = "YES you I fuck you. You love it to";
String s2 = ".";
String[] a = s1.split("[^a-zA-Z\']+");*/