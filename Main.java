import java.util.Scanner;

public class Main {

    public static void main(String args[]) {
    	
    	Scanner wow = new Scanner(System.in);
    	NodeClass first = null;
    	NodeClass end = null;
    	 
 	    
 	    boolean notExit = true;
    	while(notExit) {
    		
    	System.out.println("1) Insert at end");
    	System.out.println("2) Insert anywhere");
    	System.out.println("3) Print");
   		System.out.println("4) Count ");
   		System.out.println("5) Search");
  		System.out.println("6) Delete");
  		System.out.println("7) Sort");
  		System.out.println("8) Edit");
 		System.out.println("9) Navigate");
 		System.out.println("10) Exit");
 		
 		System.out.println("Please enter the number: ");
 		int choice = wow.nextInt();;
 		
 		switch (choice){
 			case 1:
 				
 				
 				first = Template.insertEnd(first);
 				
 				break;
 			case 2:
 				
 				System.out.println("Would you like to insert at the beginning (b) or after a person (a), Enter (a) or (b) : ");
				String resp = wow.nextLine();
				resp = wow.nextLine();
				if(resp.equalsIgnoreCase("b")) {
					first = Template.insertAtBeg(first);
				} 
				else {
					first = Template.insertAfter(first);
				}
				
 				break;
 			case 3:
 		
 				Template.print(first);
 				
 				break;
 			case 4:
 				
 				Template.count(first);
 				
 				break;
 			case 5:
 				
 				
 				System.out.println("Enter the student name to search for: ");
 				String nm3 = wow.nextLine();
 				nm3 = wow.nextLine();
 				Template.search(first, nm3);
 				
 				break;
 			case 6:
 				
 				first = Template.delete(first);
 				
 				break;
 			case 7:
 				
 				Template.sort(first);
 				
 				break;
 			case 8:
 				
 				Scanner in = new Scanner(System.in);
 				System.out.print("Enter name of node to edit: ");
				String rep = in.nextLine();
				
				Template.edit(rep, first);

 				
 				break;
 			case 9:
 				
 				Template.navigate(first);
 				
 				break;
 			case 10:
 				notExit = false;
 				
 				break;		
 		}
    	}
 		
    }
    
    
}