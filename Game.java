import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Game {
	public static void main(String[] args) {

		//system objects
		Scanner wow = new Scanner(System.in);
		Random random = new Random();
		boolean loadData = false;

		//game variables
		String[] enemies = {"zombie", "mini zombie", "super zombie"};
		int zombieHP = 50;
		int zombieDamage = 25;
		int miniZombieHealth = 25;
		int miniZombieDamage = 15;
		int superZombieHP = 100;
		int superZombieDamage = 50;
		int enemiesDefeated = 0;

		//player variables
		int health = 100;
		int damage = 40;
		int numMedKits = 3;
		int medKitHealthAmount = 50;
		int medKitDropChance = 40;
		int weaponDropChance = 20;
		String playerName = "";

		boolean game = true;
		while(game) {
			//Start Game
			System.out.println("1) New Game");
			System.out.println("2) Load Game");
			System.out.println("3) Exit");

			boolean notExit = true;
			int choice = wow.nextInt();
			int input = 0;


			while(notExit) {
				if(choice == 1) {

					boolean running = true;
					
					
					if(loadData == false) {
						enemiesDefeated = 0;
						System.out.println("Commander: Listen up everyone. This may be hard to believe, but there are reports that the undead or 'zombies' are roaming the city.");

						System.out.println("");

						System.out.println("Commnader: We have been tasked with defending this base until more support arrives.");

						System.out.println("");

						System.out.println("What is your name soldier?");
						playerName = wow.nextLine();
						playerName = wow.nextLine();
						Character.createInfo(playerName);

						System.out.println("");
					}
					
					System.out.println(playerName+ ", your position is at the front of the base, defend it the best you can.");

					System.out.println("");

					System.out.println("*You take your position at the front of the base*");

					System.out.println("");

					//obtain player variable values
					health = Character.getHealth();
					damage = Character.getAttack();

					GAME:
						while(running) {

							System.out.println("------------------------------------");

							//creating enemy
							int enemyType = 0;
							int randomEnemy = random.nextInt(100);
							if(randomEnemy <= 49) {
								enemyType = 0;
							}
							else if(randomEnemy > 49 && randomEnemy <= 79) {
								enemyType = 1;
							}
							else enemyType = 2;
							String enemy = enemies[enemyType];
							System.out.println("\tA " +enemy+ " has appeared");
							int enemyHealth;
							int enemyDamage;
							if(enemy == "zombie") {
								enemyHealth = zombieHP;
								enemyDamage = zombieDamage;
							}
							else if(enemy == "mini zombie") {
								enemyHealth = miniZombieHealth;
								enemyDamage = miniZombieDamage;
							}
							else {
								enemyHealth = superZombieHP;
								enemyDamage = superZombieDamage;
							}

							//fighting enemy
							while(enemyHealth > 0) {
								System.out.println("\tYour HP: "+health);
								System.out.println("\t"+enemy+"'s HP: "+enemyHealth);
								System.out.println("\n\t What would you like to do?");
								System.out.println("\t1) Attack");
								System.out.println("\t2) Heal");
								System.out.println("\t3) Save Game");
								System.out.println("\t4) Exit");

								input = wow.nextInt();
								if(input == 1) {

									enemyHealth -= damage;

									health -= enemyDamage;
									Character.setHealth(health);

									System.out.println("\t> You deal "+damage+ " damage to the "+enemy);
									System.out.println("\t> You take "+enemyDamage+ " damage from the "+enemy);

									if(health < 1) {
										System.out.println("You run back into the base to recover, unable to go on fighting. Game over.");
										notExit = false;
										running = false;
										break;
									}

									if(enemyHealth < 1) {
										enemiesDefeated++;
										Character.setXp(enemiesDefeated);
									}

									if(enemiesDefeated == 10) {

										System.out.println("Commander: The reinforcements have arrived! \nGood job soldiers get back in the base and relax.");

										System.out.println("Congratulations, you defended the base from the zombies!");

										System.out.println("Would you like to continue playing? [yes/no]");
										String placeholder = wow.next();

										if(placeholder == "yes") {
											continue GAME;
										}
										else { 
											notExit = false;
											running = false;
											break;
										}
									}
								}
								else if(input == 2) {
									if(numMedKits > 0) {
										health += medKitHealthAmount;
										if(health > 100) {
											health = 100;
											Character.setHealth(health);
										}
										numMedKits --;
										System.out.println("\t> You use a medical kit, your health is now: " +health
												+ "\n\t> You have "+numMedKits+" medical kits left.");
									}
									else System.out.println("\t> You have no medical kits left.");

								}
								else if(input == 3) {
									PrintWriter writer;
									try {
										writer = new PrintWriter("GameFile.txt", "UTF-8");
										writer.println(playerName);
										writer.println(health);
										writer.println(damage);
										writer.println(enemiesDefeated);
										writer.println(numMedKits);
										writer.close();
									} catch (FileNotFoundException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									} catch (UnsupportedEncodingException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
								}
								else if(input == 4) {
									notExit = false;
									running = false;
									break;
								}
								else {
									System.out.println("Please enter either 1, 2, 3 or 4");
								}
							}

							//defeated enemy and drop chances
							System.out.println("------------------------------------");
							if(input != 4) {
								System.out.println("The "+ enemy + " was defeated!");
								System.out.println("You have "+ health +" health left.");
								if(random.nextInt() < medKitDropChance) {
									numMedKits++;
									System.out.println("The "+ enemy +" dropped a medical kit!");
									System.out.println("You now have "+numMedKits+" medical kits");
								}

								//weapon drop chance
								if(random.nextInt() < weaponDropChance) {
									damage += 15;
									System.out.println("The "+ enemy +" dropped a better weapon!");
									System.out.println("Your damage increased by 15 points and is now: "+damage);
									Character.setAttack(damage);
								}
							}
						}
					if(health < 1) {
						running = false;
						notExit = false;
						break;
					}
				}

				else if(choice == 2) {
					String fileName = "GameFile.txt";

					// This will reference one line at a time
					String line = null;

					try {
						// FileReader reads text files in the default encoding.
						FileReader fileReader = 
								new FileReader(fileName);

						// Always wrap FileReader in BufferedReader.
						BufferedReader bufferedReader = 
								new BufferedReader(fileReader);

					
								playerName = bufferedReader.readLine();
								Character.createInfo(playerName);
								System.out.println(playerName);
							
							
								line = bufferedReader.readLine();
								health = Integer.parseInt(line);
								Character.setHealth(health);
								System.out.println(health);
								
							
						
								line = bufferedReader.readLine();
								damage = Integer.parseInt(line);
								Character.setAttack(damage);
								System.out.println(damage);
							
							
								line = bufferedReader.readLine();
								enemiesDefeated = Integer.parseInt(line);
								Character.setXp(enemiesDefeated);
								System.out.println(enemiesDefeated);
								
						
								line = bufferedReader.readLine();
								numMedKits = Integer.parseInt(line);
								System.out.println(numMedKits);
								System.out.println("");
								System.out.println("Data Ready. Hit new game to continue with save data.");
							
						

						// Always close files.
						bufferedReader.close();         
					}
					catch(FileNotFoundException ex) {
						System.out.println(
								"Unable to open file '" + 
										fileName + "'");                
					}
					catch(IOException ex) {
						System.out.println(
								"Error reading file '" 
										+ fileName + "'");                  
						// Or we could just do this: 
						// ex.printStackTrace();
					}
					input = 0;
					loadData = true;
					break;
				}

				else if(choice == 3) {
					notExit = false;
					game = false;
				}

				else System.out.println("Please enter one of the options (1, 2 or 3)");
			}
		}
	}

}
