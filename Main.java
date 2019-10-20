import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		
		Scanner wow = new Scanner(System.in);
		
		Template temp = new Template();
    	
 	    boolean notExit = true;
    	while(notExit) {
    		
    	System.out.println("1) Check In");
    	System.out.println("2) Check Out");
    	System.out.println("3) Exam Room Status");
   		System.out.println("4) Wait Room Status");
   		System.out.println("5) Individual Status");
  		System.out.println("6) Exit");
 		
 		System.out.println("Please enter the number: ");
 		int choice = wow.nextInt();
 		
 		
 		switch (choice){
 			case 1:
 				
 				System.out.println("Please enter the name of the patient: ");
 		 		String name = wow.nextLine();
 		 		name = wow.nextLine();
 		 		temp.checkIn(name);
 	
 				break;
 			case 2:
 				
 				System.out.println("Please enter the name of the patient leaving: ");
 		 		String name2 = wow.nextLine();
 		 		name2 = wow.nextLine();
 				temp.checkOut(name2);
				
 				break;
 			case 3:
 		
 				temp.examStatus();
 				
 				break;
 			case 4:
 				
 				temp.waitStatus();
 				
 				break;
 			case 5:
 				
 				temp.indStatus();
 				
 				break;
 			case 6:
 				
 				notExit = false;
 				
 				break;
 			
 		}
    	}
	}

}
