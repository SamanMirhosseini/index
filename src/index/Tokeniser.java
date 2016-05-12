package index;

import java.util.*;

public class Tokeniser {
	private Vector <Token> tok_vector = new Vector<Token>();
	public Tokeniser(String s) {
		this.tokenise(s);
	}
	private void tokenise(String s){
		StringTokenizer st = new StringTokenizer(s);
		while(st.hasMoreTokens()){
			Token temp = new Token(st.nextToken());
			this.tok_vector.addElement(temp);
		}
	}
	public Vector<Token> getTok_vector() {
		return tok_vector;
	}
}
