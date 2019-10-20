import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Template {
	    
		//create map
	 	Map<String, Integer> phoneBook = new HashMap<String, Integer>();
	 		
	 	//view the map's keys and values
	 	Set<String> s = phoneBook.keySet();
		Collection<Integer> c = phoneBook.values();
		
		
		public void Add(String name, int number){
			
				phoneBook.put(name, number);
		}
		
		public void Remove(String name){
			
			phoneBook.remove(name);
			String random = "";
			int n = 0;
			Iterator<String> keys = s.iterator();
			while(keys.hasNext()){
				random = keys.next();
				n = phoneBook.get(random);
				System.out.println("name: "+keys.next()+" number: "+n);
			}
			
		}
		
		public void Search(String name){
			
			if(phoneBook.containsKey(name) == true){
				System.out.println(name+" has been found");
				int number = phoneBook.get(name);
				System.out.println(name+"'s number is "+number);
				
			}
			else System.out.println(name+" was not found found");
		}
}
