import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String args[]) {
		
		Scanner wow = new Scanner(System.in);
		Template temp = new Template();

    	
 	    boolean notExit = true;
    	while(notExit) {
    		
    	System.out.println("1) Add ");
    	System.out.println("2) Remove ");
    	System.out.println("3) Search");
   		System.out.println("4) Exit");
 		
 		System.out.println("Please enter the number: ");
 		int choice = wow.nextInt();
 		
 		
 		
 		switch (choice){
 			case 1:
 				
 				String name = "";
 				int number = 0;

 				System.out.println("Please enter the name: ");
 				name = wow.nextLine();
 				name = wow.nextLine();
 				
 					
 				System.out.println("Please enter the person's number: ");
 				number = wow.nextInt();
 				 				
 				temp.Add(name, number);
 				
 				
 				
 				break;
 			case 2:
				
 				System.out.println("Please enter the name to remove: ");
 				name = wow.nextLine();
 				name = wow.nextLine();
 				
 				temp.Remove(name);
 				
 				break;
 			case 3:
 				
 				System.out.println("Please enter the name to search for: ");
 				name = wow.nextLine();
 				name = wow.nextLine();
 				
 				temp.Search(name);
 				
 				break;
 			case 4:
 				
 				notExit = false;
 				
 				break;

 		}
    	}
	}

}
