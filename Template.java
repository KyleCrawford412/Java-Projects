import java.util.Scanner;

public class Template {
	
	
   private static InfoClass createInfo() {
	    Scanner input = new Scanner(System.in);
		System.out.println("Name: ");
		String name = input.nextLine();
		
		System.out.println("Student number: ");
		int num = input.nextInt();
		
		System.out.println("Grade: ");
		int g = input.nextInt();
		
		System.out.println("GPA: ");
		input.nextLine();
		double sGPA = input.nextDouble();
		
		
		return new InfoClass(num, name, g, sGPA);
		
	}

   public static NodeClass insertEnd(NodeClass first){
	   NodeClass newInfo = new NodeClass(createInfo(), null, null);
		if (first == null) {
			first = newInfo;
			return first;
		}
		NodeClass temp = first;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(newInfo);
		newInfo.setPrev(temp);
		return first;
	}

 			
   
    
   
   public static void print(NodeClass temp){
   	NodeClass r = temp;
   	while(r != null){
   		System.out.println(r.getInfo());
   		r = r.getNext();
   	}
   }
   
   
   public static NodeClass insertAfter(NodeClass first) {
	    Scanner input = new Scanner(System.in);
		NodeClass newInfo = new NodeClass(createInfo(), first, null);
		System.out.println("What is the name of the person after whom you would like to insert this person?");
		String name = input.nextLine();
		NodeClass temp = first;
		while (temp != null && !temp.getInfo().getName().equals(name)) {
			temp = temp.getNext();
		}
		if (temp == null) {
			System.out.println(name + " was not found in the list.");
		} else {
			newInfo.setNext(temp.getNext());
			temp.setNext(newInfo);
			if (newInfo.getNext() != null) {
				newInfo.getNext().setPrev(newInfo);
			}
			newInfo.setPrev(temp);
		}
		
		return first;
	}
	
	public static NodeClass insertAtBeg(NodeClass first) {
		NodeClass newInfo = new NodeClass(createInfo(), null, first);
		first.setPrev(newInfo);
		return newInfo;
	}

   
   public static void count (NodeClass temp) {
	   int size = 0;
	   NodeClass r = temp;
	   while(r != null){
		   r = r.getNext();
	   	   size++;
	   	}
	   System.out.println(size);
   }
   
   
   public static void search(NodeClass temp, String nm3) {
	   NodeClass r = temp;
	   while(r.getNext() != null && !r.getInfo().getName().equals(nm3)) {
			r = r.getNext();
		}
	   if(r.getInfo().getName().equals(nm3)) {
		   System.out.println("record found");
		   System.out.println(r.getInfo());
		}
   }
   
   public static void edit(String s, NodeClass temp) {
	    Scanner input = new Scanner(System.in);
		int p = 0;
		NodeClass r = temp;
		
		while(r != null) {
			if(r.getInfo().getName().equals(s)) {
				p++;
				System.out.println(r.getInfo());
				System.out.println("Is this a correct entry to edit? (Y/n)");
				String ansString = input.nextLine();
				char ans = ansString.charAt(0);
				if(ans == 'Y' || ans == 'y') {
					System.out.println("Which component would you like to edit?\n1. Name\n2. Student Number\n3. Grade\n4. Gpa");
					int ans2 = input.nextInt();
					input.nextLine();
					if(ans2 == 1) {
						
						System.out.print("Enter new name: ");
						String newname = input.nextLine();
						r.getInfo().setName(newname);
					}
					else if(ans2 == 2) {
						System.out.print("Enter new student number: ");
						r.getInfo().setNum(input.nextInt());
						input.nextLine();
					}
					else if(ans2 == 3) {
						System.out.print("Enter new grade: ");
						r.getInfo().setGrade(input.nextInt());
					}
					else if(ans2 == 4) {
						System.out.print("Enter new GPA: ");
						r.getInfo().setGPA(input.nextDouble());
						input.nextLine();
					}
				}
				
			}
			r = r.getNext();
			
		}
		if(p == 0) {
			System.out.println("No such node exists.");
		}

	    }
   
   public static NodeClass delete(NodeClass first) {
	   Scanner input = new Scanner(System.in);
	   System.out.println("Who would you like to delete from the list: ");
		String name = input.nextLine();
		NodeClass temp = first;
		if (temp.getInfo().getName().equals(name)) {
			first = first.getNext();
			first.setPrev(null);
			return first;
		}
		while (temp.getNext() != null && !temp.getNext().getInfo().getName().equals(name)) {
			temp = temp.getNext();
		}
		if (temp.getNext() == null) {
			System.out.println(name + " was not found in the list.");
		} else {
			// temp is before the one you want to delete
			// temp.getNext() is the one you want to delete
			temp.setNext(temp.getNext().getNext());
			if (temp.getNext() != null) {
				temp.getNext().setPrev(temp);
			}						
		}
		return first;

   }
   
   public static void sort(NodeClass temp){
		
		NodeClass r = temp;
		int c = 0;
		do {
			c = 0;
			while(r.getNext() != null) {
				if(r.getInfo().getName().compareTo(r.getNext().getInfo().getName()) > 0) {
					InfoClass tempinfo = null;
					tempinfo = r.getInfo();
					r.setInfo(r.getNext().getInfo());
					r.getNext().setInfo(tempinfo);
					c++;
					
				}
				r = r.getNext();
				
			}
			r = temp;
		}while(c != 0);
		
	}

   
   public static void navigate(NodeClass first) {
	    Scanner input = new Scanner(System.in);
		NodeClass temp = first;
		String request = "";
		do {
			System.out.println(temp.getInfo());
			System.out.println("Would you like the next node [N], previous node [P], or to exit [E]?");
			request = input.nextLine();
			if (request.equalsIgnoreCase("n")) {
				if (temp.getNext() == null) {
					System.out.println("Already at end of list.");
				} else {
					temp = temp.getNext();
				}				
			} else if (request.equalsIgnoreCase("p")) {
				if (temp.getPrev() == null) {
					System.out.println("Already at beginning of list.");
				} else {
					temp = temp.getPrev();
				}		
			}			
		} while(!request.equalsIgnoreCase("e"));
	}

   
    
}