import java.util.Scanner;

public class Util {
	
	public static Scanner input;
	
	public static void setInput(Scanner input) {
		Util.input = input;
	}
	
	private static Info createInfo() {
		
		System.out.println("Name of Person: ");
		String name = input.nextLine();
		
		System.out.println("Age: ");
		int age = input.nextInt();
		
		System.out.println("Height (in feet, decimals allowed): ");
		double height = input.nextDouble();
		
		System.out.println("Color of Eye: ");
		input.nextLine();
		String eyeColor = input.nextLine();
		
		
		return new Info(name, age, height, eyeColor);
		
	}
	
	public static Node insertAtEnd(Node first) {
		Node newInfo = new Node(createInfo(), null, null);
		if (first == null) {
			first = newInfo;
			return first;
		}
		Node temp = first;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}
		temp.setNext(newInfo);
		newInfo.setPrev(temp);
		return first;
	}
	
	public static void print(Node first) {
		while (first != null) {
			System.out.println(first.getInfo());
			first = first.getNext();
		}
	}
	
	public static void count(Node first) {
		int count = 0;
		while (first != null) {
			count++;
			first = first.getNext();
		}
		System.out.println(count + " elements in the list");
	}
	
	public static Node insertAfter(Node first) {
		Node newInfo = new Node(createInfo(), first, null);
		System.out.println("What is the name of the person after whom you would like to insert this person?");
		String name = input.nextLine();
		Node temp = first;
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
	
	public static Node insertAtBeg(Node first) {
		Node newInfo = new Node(createInfo(), null, first);
		first.setPrev(newInfo);
		return newInfo;
	}
	
	public static Node search(Node first) {
		System.out.println("What is the name of the person?");
		String name = input.nextLine();
		Node temp = first;
		while(temp != null && !temp.getInfo().getName().equals(name)) {
			temp = temp.getNext();
		}
		if (temp == null) {
			System.out.println(name + " was not found in the list.");
		} else {
			System.out.println(temp.getInfo());
		}
		return temp;
	}
	
	public static void edit(Node first) {
		Node temp = Util.search(first);
		if (temp != null) {
			System.out.println("Edit name [n], age [a], height [h], or eye color [e]?");
			String resp = input.nextLine();
			if (resp.equals("n")) {
				System.out.print("New Name: ");
				temp.getInfo().setName(input.nextLine());
			} else if (resp.equals("a")) {
				System.out.print("New Age: ");
				temp.getInfo().setAge(Integer.valueOf(input.nextLine()));
			} else if (resp.equals("h")) {
				System.out.print("New Height: ");
				temp.getInfo().setHeight(Double.valueOf(input.nextLine()));
			} else if (resp.equals("e")) {
				System.out.print("New Eye Color: ");
				temp.getInfo().setEyeColor(input.nextLine());
			}
		}
	}
	
	public static Node delete(Node first) {
		System.out.println("What is the name of the person whom you would like deleted from the list?");
		String name = input.nextLine();
		Node temp = first;
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
	
	public static void navigate(Node first) {
		Node temp = first;
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
	
	public static Node sort(Node first) {
		Node temp = first;
		// 2 nodes to compare: temp and comp
		while (temp.getNext() != null) {
			Node comp = temp.getNext();
			while (comp != null) {
				if (temp.getInfo().getName().compareToIgnoreCase(comp.getInfo().getName()) > 0) {
					Info holder = temp.getInfo();
					temp.setInfo(comp.getInfo());
					comp.setInfo(holder);
					comp = temp.getNext();
				} else {
					comp = comp.getNext();
				}
			}
			temp = temp.getNext();
		}
		return first;
	}
	

}
