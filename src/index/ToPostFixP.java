package index;

import java.io.File;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Vector;

public class ToPostFixP {
	Vector <Token> process;
	LinkedList<String> output_queue;
	Stack <String> operators_stack;
	PdfFile file;
	public ToPostFixP(String s,File f,File b) {
		this.operators_stack = new Stack<String>();
		this.output_queue = new LinkedList<String>();
		Tokeniser t = new Tokeniser(s);
		this.process = t.getTok_vector();
		this.file = new PdfFile(f,b);
		this.full_stack_and_queue();
	}
	private void full_stack_and_queue(){
		for(int i = 0;i < process.size();i++){
			switch(this.process.get(i).type){
			case word:
				Integer help = this.file.SearchinAllwords(this.process.get(i).value);
				switch(help){
				case -1:
					help = 0;
				break;
				default:
					help = 1;
				break;
				}
				this.output_queue.push(help.toString());
			break;
			case operator:
				if(this.operators_stack.isEmpty() == true){
					this.operators_stack.push(this.process.get(i).value);
				}
				else{
					Token temp = new Token(this.operators_stack.pop());
					switch(temp.type){
					case operator:
						if(this.process.get(i).priority <= temp.priority){
							this.operators_stack.push(this.process.get(i).value);
							this.output_queue.push(temp.value);
						}
						else{
							this.operators_stack.push(temp.value);
							this.operators_stack.push(this.process.get(i).value);
						}
					break;
					default:
						this.operators_stack.push(temp.value);
						this.operators_stack.push(this.process.get(i).value);
					break;
					}
				}
			break;
			case par_open:
				this.operators_stack.push(this.process.get(i).value);
			break;
			case par_close:
				while(!this.operators_stack.isEmpty()){
					String stm = this.operators_stack.pop();
					Token r = new Token(stm);
					if(r.type == Type.par_open){
						break;
					}
					if(stm != "("){
					this.output_queue.push(stm);
					}
				}
			break;
			}
		}
		while(!this.operators_stack.isEmpty()){
			String jio = this.operators_stack.pop();
			this.output_queue.push(jio);
		}
	}
}
