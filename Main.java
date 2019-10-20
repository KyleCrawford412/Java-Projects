import java.util.Scanner;

public class Main {
	public static void main(String args[]){
		
	
		Scanner wow = new Scanner(System.in);
 	    boolean notExit = true;
    	while(notExit) {
    		
    	System.out.println("1) Evaluate Postfix");
    	System.out.println("2) Convert infix to postfix");
    	System.out.println("Exit");
 		
 		System.out.println("Please enter the number: ");
 		int choice = wow.nextInt();;
 		
 		switch(choice){
 		case 1: 
 			
 			Scanner reader = new Scanner(System.in);
 			Evaluate evaluator = new Evaluate();
 			String query = "Y";
 			while(query.equalsIgnoreCase("Y")){
 				System.out.print("Enter a postfix expression: ");
 				String input = reader.nextLine();
 				String output = evaluator.run(input);
 				System.out.println(output);
 				System.out.print("Evaluate another expression [y/n]");
 				query = reader.nextLine();
 			}
 			
 			break;
 		case 2: 
 			
 			Evaluate.convert();
 			
 			break;
 		case 3:
 			
 			notExit = false;
 			
 			break;
 		}
    	}
	}
}
