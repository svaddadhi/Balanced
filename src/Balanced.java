import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * Seshasai Vishal Vaddadhi
 * Professor Finklestein
 * CMPS12B
 * HW3
 *This program reads in a statement and checks if the parenthesis in each are balanced 
 */
public class Balanced {
	public static void main(String[] args) throws IOException{

		 // check number of command line arguments is at least 2
		 if(args.length < 2){
			 System.out.println("Usage: java –jar Balanced.jar <input file> <output file>");
			 System.exit(1);
		 }
		 // open files
		 Scanner in = new Scanner(new File(args[0]));
		 PrintWriter out = new PrintWriter(new File(args[1]));
		 // read lines from in, write lines to out
		 while( in.hasNextLine() ){
			 String line = in.nextLine().trim();
			 
			 if(checkParenthesis(line)){
				 out.println("Y");
			 }
			 else{
				 out.println("N");
			 }
			 
		 }
		 // close files
		 in.close();
		 out.close();
	}
	
	
	public static boolean checkParenthesis(String s){
		//making sure the stack is empty when starting
		if(s.isEmpty()){
			return true;
		}
		
		RefStack<Character> stack = new RefStack<>();
		for(int i = 0; i < s.length(); i++){
			char curr = s.charAt(i);
			//first checking the open parenthesis and pushing them onto the stack
			if(curr == '{' || curr == '(' || curr == '[' || curr == '<'){
				stack.push(curr);
			}
			// then checking the closing parenthesis 
			if(curr == '}' || curr == ')' || curr == ']' || curr == '>'){
				//this is to make sure that the first few parenthesis put in are not closing parenthesis
				if(stack.isEmpty()){
					return false;
				}
				//now comparing the top of the stack aka the ending parenthesis with the open ones
				//then popping as we match the parenthesis
				char end = (char)stack.peek();
				if((curr == '}' && end == '{') || (curr == ')' && end == '(') || (curr == ']' && end == '[') || (curr == '>' && end == '<') ){
					stack.pop();
				}
				else{
					return false;
				}
			}
		}
		//if the stack is empty then we have a balanced statement 
		//if not then the statement is not balanced
		return stack.isEmpty();
	}
}

