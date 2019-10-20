import java.util.*;

public class Template {

	String[] examRoom;
	Queue<String> waitRoom;
	Queue<String> temporary;
	
	public Template(){
		examRoom = new String[4];
		for(int i = 0; i < 4; i++){
			examRoom[i] = "empty";
		}
		waitRoom = new LinkedList<String>();
		temporary = new LinkedList<String>();
	}
	
	
	public void checkIn(String name){
		
		boolean found = false;
		int i = 0;
		while(!found && i<4){
			if(examRoom[i].equals("empty")){
				examRoom[i] = name;
				found = true;
			}
			else{
				i++;
			}
		}
		if(i == 4){
			waitRoom.add(name);
		}
	}
	
	public void checkOut(String name){
		
		Scanner wow = new Scanner(System.in);
		for(int i = 0; i < 4; i++){
			int n = i + 1;
			System.out.println(n + ") " +examRoom[i]);
		}
		System.out.println("Enter the choice of the person you would like to check out: ");
		int choice = wow.nextInt();
		
		if(!waitRoom.isEmpty()){
			examRoom[choice - 1] = waitRoom.remove();
		}
		else{
			examRoom[choice - 1] = "empty";
		}
	}
		
	public void examStatus(){
		for(int i = 0; i < 4; i++){
			int n = i + 1;
			System.out.println(n + ") " +examRoom[i]);
		}
	}
	
public void waitStatus(){
		
		int size = waitRoom.size();
		String patientName = "";
		
		if(size == 0){
			System.out.println("The waiting room is empty");
		}
		
		
		for(int x = 0; x < size; x++){
			patientName = waitRoom.poll();
			temporary.add(patientName);
			System.out.println(patientName + " has an estimated wait time of "+ (x + 1)*5 + " minutes");
		}
		
	}

public void indStatus(){
	
	Scanner wow = new Scanner(System.in);
	String temp = null;
	int t = waitRoom.size();
	boolean found = false;
	System.out.println("Enter the name of the patient: ");
	String name = wow.nextLine();
	
	if(!found){
		for(int i = 0; i < 4; i++){
			if(examRoom[i].equals(name)){
				System.out.println(name+ " is in exam room " +(i+1));
				found = true;
			}
		}
	}
	if(!found){
		for(int i = 0; i < 4; i++){
			temp = waitRoom.remove();
			if(temp.equals(name)){
				System.out.println(name+ " is in the waiting room and has " +((i+1)*5) + " minutes left" );
				found = true;
			}
			waitRoom.add(temp);
		}
	}
	if(!found){
		System.out.println("patient not found");
	}
}
	
}
