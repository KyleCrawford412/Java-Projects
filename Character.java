
public class Character {

	private static String name;
	private static int health;
	private static int speed;
	private static int attack;
	private static int defense;
	private static int experience;

	public Character(String name, int health, int speed, int attack, int defense, int experience){
    	this.name = name;
		this.health = health;
    	this.speed = speed;
    	this.attack = attack;
    	this.defense = defense;
    	this.experience = experience;
    }
    
	
	
	//returns the name chosen by the user
   public static String getName(){
	return name;
   }
	
   //Update player health
   public static void setHealth(int newHealth){
   	health = newHealth;
   }
   
   //Used to check plater health
   public static int getHealth(){
   	return health;
   	
   }
    
   public void setSpeed(int spd){
   	speed = spd;
   }
    
   public int getSpeed(){
   	return speed;
   } 
    
   public static void setAttack(int atk){
   	attack = atk;
   }
    
   public static int getAttack(){
   	return attack;
   } 
   
   public void setDefense(int def){
   	defense = def;
   }
    
   public int getDefense(){
   	return defense;
   }
   
   public static void setXp(int xp){
	   	experience = xp;
   }

   
 
   //Creates a new character
   public static Character createInfo(String name){
	   
		health = 100;
		speed = 100;
		attack = 40;
		defense = 10;
		experience = 0;
		
		
		return new Character(name, health, speed, attack, defense, experience);
		
	}


}
