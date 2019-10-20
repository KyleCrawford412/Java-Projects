
import java.util.Scanner;

public class Linear {
	public static void main(String [] args){
		
		Scanner reader = new Scanner(System.in);
		String query = "y";
		
		while(query.equalsIgnoreCase("y")){
			System.out.println("Enter the size of the array: ");
			int arrayLength = reader.nextInt();
			System.out.println("Enter the number of items: ");
			int numberOfItems = reader.nextInt();
			
			int[] collisions = new int[arrayLength];
			for (int i = 0; i < numberOfItems; i++){
				collisions[i] = 0;
			}
			
			System.out.println("Item hash code index");
			
			for(int i = 0; i < numberOfItems; i++){
				
				String str = "Item " +i;
				int code = str.hashCode();
				int index = Math.abs(code % arrayLength);
				int constant = 2;
				
				while(collisions[index] != 0){
					index = (index + constant * constant) % arrayLength;
					constant++;
					
				}
				
				collisions[index]++;
				System.out.println(str+ " " + code + " " +index);
				
			}
			
			reader.nextLine();
			for(int i = 0; i < arrayLength; i++){
				if(collisions[i] != 0){
					collisions[i]--;
				}
				System.out.println("Collisions at pos " + i + ": " +collisions[i]);
			}
			
			int sumOfCollisions = 0;
			for(int i = 0; i < arrayLength; i++){
				sumOfCollisions = sumOfCollisions + collisions[i];
			}
			
			System.out.println("Sum of collisions: " +sumOfCollisions);
			
			System.out.println("run again [y/n]");
			query = reader.nextLine();
		}
		
		
	}

}
