
import java.util.Scanner;

public class DoublyLinkedList {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Util.setInput(input);
		int userOption = 0;
		Node firstNode = null;
		do {
			// print menu
			System.out.println("Please choose a number from the following menu:");
			System.out.println("1. Insert at End");		
			System.out.println("2. Insert Anywhere");	
			System.out.println("3. Print");		
			System.out.println("4. Count");		
			System.out.println("5. Search");	
			System.out.println("6. Delete");	
			System.out.println("7. Sort");		
			System.out.println("8. Edit");		
			System.out.println("9. Navigate");
			System.out.println("10. Exit");
			userOption = input.nextInt();
			input.nextLine();	// get rid of the newline character
			switch(userOption) {
				case 1:
					firstNode = Util.insertAtEnd(firstNode);
					break;
				case 2:
					System.out.println("Would you like to insert at the beginning [b] or after an existing node [a]? Enter [b] or [a].");
					String resp = input.nextLine();
					if(resp.equalsIgnoreCase("b")) {
						firstNode = Util.insertAtBeg(firstNode);
					} else {
						firstNode = Util.insertAfter(firstNode);
					}
					break;
				case 3:
					Util.print(firstNode);
					break;
				case 4:
					Util.count(firstNode);
					break;
				case 5:
					Util.search(firstNode);
					break;
				case 6:
					firstNode = Util.delete(firstNode);
					break;
				case 7:
					firstNode = Util.sort(firstNode);
					break;
				case 8:
					Util.edit(firstNode);
					break;
				case 9:
					Util.navigate(firstNode);
					break;
				case 10:
					System.out.println("You have exited the program.");
					break;
				default:
					System.out.println("Please choose a valid menu option (1-9).");
					break;
			}
		} while(userOption != 10);
	}
}