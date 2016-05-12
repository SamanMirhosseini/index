package index;

import java.io.File;
import java.util.*;

public class CalcT {
	Stack <String> calculating_stack = new Stack<String>();
	ToPostFix toPost;
	Integer lastvalue;
	public CalcT (String s,File f,File b){
		this.toPost = new ToPostFix(s, f,b);
		this.the_post_fix_calculator();
		lastvalue = new Integer(this.calculating_stack.pop());
	}
	private void the_post_fix_calculator(){
		while(!this.toPost.output_queue.isEmpty()){
			 String temp = this.toPost.output_queue.pollLast();
			 switch(temp){
			 case "&":
				 this.and_handell();
			 break;
			 case "|":
				 this.or_handell();
			 break;
			 case "!":
				 this.not_handell();
		     break;
		     default:
		    	 this.calculating_stack.push(temp);
		     break;
			 }
		}
	}
	private void not_handell(){
		Integer help = new Integer(this.calculating_stack.pop());
		if(help == 1)
			help = 0;
		else
			help = 1;
		this.calculating_stack.push(help.toString());
	}
	private void or_handell(){
		Integer a = new Integer(this.calculating_stack.pop());
		Integer b = new Integer(this.calculating_stack.pop());
		a = a | b;
		this.calculating_stack.push(a.toString());
	}
	private void and_handell(){
		Integer a = new Integer(this.calculating_stack.pop());
		Integer b = new Integer(this.calculating_stack.pop());
		a = a & b;
		this.calculating_stack.push(a.toString());
	}
}

