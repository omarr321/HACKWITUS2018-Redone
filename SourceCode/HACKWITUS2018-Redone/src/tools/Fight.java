package tools;

import java.util.Scanner;

public class Fight {
	private String Name;
	private String Description;
	private int Health;
	private int MaxHealth;
	private int MinDam;
	private int MaxDam;
	private boolean IsGood;
	private boolean didDefendPlayer;
	private boolean didDefend;
	private String deathMess = "You have killed the monster!";
	private boolean IsFake = false;
	
	public Fight(String name, String description, int health, int minDam, int maxDam) {
		Name = name;
		Description = description;
		Health = health;
		MaxHealth = health;
		MinDam = minDam;
		MaxDam = maxDam;
	}
	
	public Fight(String name, String description, int health, int minDam, int maxDam, String deathMessage) {
		Name = name;
		Description = description;
		Health = health;
		MaxHealth = health;
		MinDam = minDam;
		MaxDam = maxDam;
		deathMess = deathMessage;
	}
	
	public Fight(String name, String description, int health, int minDam, int maxDam, boolean isFake) {
		Name = name;
		Description = description;
		Health = health;
		MaxHealth = health;
		MinDam = minDam;
		MaxDam = maxDam;
		IsFake = isFake;
	}
	
	public Fight(String name, String description, int health, int minDam, int maxDam, String deathMessage, boolean isFake) {
		Name = name;
		Description = description;
		Health = health;
		MaxHealth = health;
		MinDam = minDam;
		MaxDam = maxDam;
		deathMess = deathMessage;
		IsFake = isFake;
	}
	
	public boolean run(int[] playerData, Scanner input, String[] name) {
		didDefend = false;
		
		while (true) {
			IsGood = false;
			didDefendPlayer = false;
			
			Tools.clearScreen();
			String outputEnm = String.format("Name: %s%nDescription: %s%nHealth: %d/%d%n", Name, Description, Health, MaxHealth);
			String outputPlayer = String.format("Name: %s%nHealth: %d/100%n", name[0], playerData[0]);
			String action;

			Tools.slowText(outputEnm);
			System.out.println();
			System.out.println();
			System.out.println();
			Tools.slowText(outputPlayer);
			System.out.println();
			while (IsGood == false) {
				Tools.slowText("What do you want to do?");
				Tools.slowText("1: Attack");
				Tools.slowText("2: Defend");
				Tools.slowText("3: Use potion");
				System.out.println();
				Tools.slowTextN(">");
				action = input.nextLine();
				action = action.toLowerCase();
				
				System.out.println();
				
				switch (action) {
				case "1":
					Attack(playerData, false);
					IsGood = true;
					break;
				case "2":
					Defend(false);
					IsGood = true;
					didDefendPlayer = true;
					break;
				case "3":
					usePotion(playerData, input);
					break;
				case "end":
					System.exit(0);
				default:
					Tools.slowText("Not a vaild input!");
				}
				
			}
			
			Tools.clearScreen();
			if (Health <= 0) {
				Tools.slowText(deathMess);
				return false;
			}
			
			didDefend = false;
			
			int rand = Tools.random(0, 100);
			
			if (rand > 25) {
				AttackEn(playerData);
			} else {
				DefendEn();
			}
			
			if (playerData[0] <= 0) {
				if (IsFake == true) {
					return false;
				} else {
					return true;
				}
			}
		}
	}

	private void Attack(int[] playerData, boolean potion) {
		int damD = Tools.random(5, 20);
		int damW = Tools.random(playerData[4], playerData[5]);
		int total;
		Tools.slowText("You do " + damD + " damage!");
		System.out.println();
		Tools.slowText("Your sword gives you an extra " + damW + " damage!");
		total = damD + damW;
			
			
		if (potion == true) {
			total = total + total / 2;
			
			Tools.clearScreen();
			Tools.slowText("You drink the attack potion.");
			Tools.slowText("(Damage increased by 1/2)");
			System.out.println();
		}
		
		if (didDefend == true) {
			total = total - total / 2;
			
			Tools.slowText("They was ready for your attack");
			Tools.slowText("(damage decreased by 1/2)");
			System.out.println();
		}
		
		System.out.println();
		Tools.slowText("You did " + total + " damage!");
		Health = Health - total;
	}

	private void Defend(boolean potion) {
		if (potion == false) {
			Tools.slowText("You prepare for the attack.");
			Tools.slowText("(Damage decreased by 1/2)");
		} else {
			Tools.slowText("You prepare for the attack.");
			Tools.slowText("You drink the potion of defend.");
			Tools.slowText("(Damage decreased by 3/4)");
		}
	}
	
	private void usePotion(int[] playerData, Scanner input) {
		boolean isGood = false;
		String action;
		
		while(isGood == false) {
			System.out.println();
			Tools.slowText("What potion do you want to use?");
			Tools.slowText("1: Health potion (you have " + playerData[1] + ")");
			Tools.slowText("2: Attack potion (you have " + playerData[2] + ")");
			Tools.slowText("3: Defend potion (you have " + playerData[3] + ")");
			Tools.slowText("4: Back");
			System.out.println();
			Tools.slowTextN(">");
			action = input.nextLine();
			action = action.toLowerCase();
			
			Tools.clearScreen();
			switch(action) {
			case "1":
				if (playerData[1] > 0) {
					Tools.slowText("You heal 25 HP!");
					playerData[0] = playerData[0] + 25;
					if (playerData[0] > 100) {
						playerData[0] = 100;
					}
					isGood = true;
					IsGood = true;
					playerData[1]--;
				} else {
					Tools.slowText("You have none left.");
				}
				break;
			case "2":
				if (playerData[2] > 0) {
					Attack(playerData, true);
					isGood = true;
					IsGood = true;
					playerData[2]--;
				} else {
					Tools.slowText("You have none left.");
				}
				break;
			case "3":
				if (playerData[3] > 0) {
					Defend(true);
					isGood = true;
					IsGood = true;
					didDefendPlayer = true;
					playerData[3]--;
				} else {
					Tools.slowText("You have none left.");
				}
				break;
			case "4":
				isGood = true;
				break;
			case "end":
				System.exit(0);
			default:
				Tools.slowText("That is not a vaild input!");
			}
		}
	}
	
	private void AttackEn(int[] playerData) {
		int dam = Tools.random(MinDam, MaxDam);
		int blocked = Tools.random(playerData[6], playerData[8]);
		if (didDefendPlayer == true) {
			Tools.slowText("They attack you but you were ready for the attack.");
			dam = dam - dam / 2;
		} else {
			Tools.slowText("They attack you.");
		}
		System.out.println();
		Tools.slowText("They deal " + dam + " damage!");
		System.out.println();
		Tools.slowText("Your armor protects you from " + blocked + " damage!");
		dam = dam - blocked;
		
		if (dam < 0) {
			dam = 0;
		}
		System.out.println();
		Tools.slowText("You take " + dam + " damage.");
		playerData[0] = playerData[0] - dam;
		
		Tools.sleep(2);
	}
	
	private void DefendEn() {
		Tools.slowText("They prepare for you next attack.");
		didDefend = true;
	}

	public String toString() {
		String output = String.format("private String Name: %s%nprivate String Description: %s%nprivate int Health: %d%nprivate int MaxHealth: %d%n", Name, Description, Health, MaxHealth);
		output = output + String.format("private int MinDam: %d%nprivate int MaxDam: %d%nprivate boolean IsGood: %b%nprivate boolean didDefendPlayer: %b%n", MinDam, MaxDam, IsGood, didDefendPlayer);
		output = output + String.format("private boolean didDefend: %b%nprivate String deathMess: %s%n", didDefend, deathMess);
		
		return output;
	}
}