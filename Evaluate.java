import java.util.*;

public class Evaluate {

	public String run(String input){
		Stack<String> stack = new Stack<String>();
		StringTokenizer tokens = new StringTokenizer(input);
		String operand1 = null, operand2 = null;
		String error = null;
		while(tokens.hasMoreTokens() && error == null){
			String token = tokens.nextToken();
			if(isOperand(token))
				stack.push(token);
			else if(isOperator(token)){
				if(! stack.empty()){
					operand2 = stack.pop();
					if(! stack.empty()){
						operand1 = stack.pop();
						String result = computeValue(operand1, token, operand2);
						if(result != null)
							stack.push(result);
						else 
							error = "attempt to divide by 0";
					}else
						error = "Malformed expression";
				}else
					error = "Malformed expression";
			}else
				error = "Malformed expression";
		}
		if(stack.size() != 1)
			error = "Malformed expression";
		if(error != null)
			return error;
		else
			return stack.pop();
	}
	
	private boolean isOperand(String s){
		for(int i = 0; i < s.length(); i++)
			if(! Character.isDigit(s.charAt(i)))
				return false;
		return true;
	}
	
	private boolean isOperator(String s){
		return s.equals("+") ||
			   s.equals("-") ||
			   s.equals("*") ||
			   s.equals("^") ||
			   s.equals("/");
	}
	
	private String computeValue(String op1, String op, String op2){
		int result = 0;
		int intOp1 = Integer.parseInt(op1);
		int intOp2 = Integer.parseInt(op2);
		double result2;
		if(op.equals("+")){
			result = intOp1 + intOp2;
			System.out.println(intOp1);
			System.out.println(intOp2);
		}
		else if(op.equals("-"))
			result = intOp1 - intOp2;
		else if(op.equals("*"))
			result = intOp1 * intOp2;
		else if(op.equals("^")){
			result2 = Math.pow(intOp1, intOp2);
			result = (int) result2;
		}
		else if(op.equals("/"))
			if(intOp2 == 0)
				return null;
			else
				result = intOp1 / intOp2;
		return "" + result;
	}
	
	public static boolean isEqual(String one, String two){
		if((one.equals("(") || one.equals(")")) && (two.equals("(") || two.equals(")"))) return true;
		if(one.equals("^") && two.equals("^")) return true;
		if((one.equals("*") || one.equals("/")) && (two.equals("*") || two.equals("/"))) return true;
		if((one.equals("+") || one.equals("-")) && (two.equals("+") || two.equals("-"))) return true;
		return false;
	}
	
	public static boolean isHigher(String one, String two){
		if(isEqual(one, two)) return false;
		else if(one.equals("(") || one.equals(")")) return true;
		else if(two.equals("(") || two.equals(")")){
			if(one.equals("^")) return true;
			if(!two.equals("^") && (one.equals("*") || one.equals("/"))) return true;
		}
		else if((one.equals("+") || one.equals("-"))) return false;
		
		return true;
	}
	
	public static boolean isNumeric(String str){
		try{
			double x = Double.parseDouble(str);
		}
		catch(NumberFormatException nfe){
			return false;
		}
		return true;
	}
	
	public static void convert(){
		Scanner wow = new Scanner(System.in);
		Stack<String> stack = new Stack<String>();
		System.out.println("Enter and infix expression");
		StringTokenizer x = new StringTokenizer(wow.nextLine());
		String post = "";
		while(x.hasMoreTokens()){
			String r = x.nextToken();
			if(isNumeric(r)) post = post + r + "";
			else if(r.equals("(") || stack.isEmpty() || stack.peek().equals("("))
				stack.push(r);
			else if(r.equals(")")){
				while(!(stack.peek().equals("("))){
					post = post + stack.pop() + "";
				}
				stack.pop();
			}
			else{
				while(!stack.isEmpty()){
					if(isHigher(r, stack.peek())) break;
					else if(isEqual(r, stack.peek())){
						post = post + stack.pop() + "";
						break;
					}
					else if(!isHigher(r,stack.peek()) && !isEqual(r, stack.peek())){
						post = post + stack.pop() + "";
					}
				}
				stack.push(r);
			}	
		}
		while(!stack.isEmpty()){
			post = post + stack.pop() + "";
		}
		System.out.println(post);
	}
	
	
}