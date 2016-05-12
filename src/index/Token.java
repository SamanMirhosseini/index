package index;

public class Token {
	String value;
	Type type;
	int priority;
	public Token(String s) {
		this.value = s;
		switch(s){
		case "&":
			this.type = Type.operator;
			this.priority = 2;
		break;
		case "|":
			this.type = Type.operator;
			this.priority = 1;
		break;
		case "!":
			this.type = Type.operator;
			this.priority = 3;
		break;
		case "(":
			this.type = Type.par_open;
			this.priority = 0;
		break;
		case ")":
			this.type = Type.par_close;
			this.priority = 0;
		break;
		default:
			this.type = Type.word;
			this.priority = 0;
		break;
		}
	}

}
