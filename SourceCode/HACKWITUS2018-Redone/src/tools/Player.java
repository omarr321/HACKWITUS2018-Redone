package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Player {
	private int[] PlayerData = {100, 0, 0, 0, 0, 0 , 0, 0, 0, 0};
	private boolean[] IsDone = new boolean[11];
	private String[] Name = {"", "Nothing", "Nothing", "", "", ""};
	private int[] SafeCombo = new int[9];
	
	public Player() {
		for(int i = 0; i < IsDone.length; i++) {
			IsDone[i] = false;
		}
		
		for(int i = 0; i < SafeCombo.length; i++) {
			SafeCombo[i] = Tools.random(0, 9);
		}
	}
	
	public void setName(String name) {
		Name[0] = name;
		name = name.replace(' ', '_');
		Name[3] = name;
	}
	
	public void setArmor(String name, int min, int max) {
		Name[1] = name;
		PlayerData[6] = min;
		PlayerData[8] = max;
	}
	
	public void setSword(String name, int min, int max) {
		Name[2] = name;
		PlayerData[4] = min;
		PlayerData[5] = max;
	}
	
	public void setHealth(int health) {
		PlayerData[0] = health;
	}
	
	public void setIsDone(Boolean set, int index) {
		IsDone[index] = set;
	}
	
	public void subHealth(int amount) {
		PlayerData[0] = PlayerData[0] - amount;
	}
	
	public void addHealth(int amount) {
		PlayerData[0] = PlayerData[0] + amount;
	}
	
	public void addHealthPotion(int amount) {
		PlayerData[1] = PlayerData[1] + amount;
	}
	
	public void addDefendPotion(int amount) {
		PlayerData[3] = PlayerData[3] + amount;
	}
	
	public void addAttackPotion(int amount) {
		PlayerData[2] = PlayerData[2] + amount;
	}
	
	public void subHealthPotion(int amount) {
		PlayerData[1] = PlayerData[1] - amount;
	}
	
	public void subDefendPotion(int amount) {
		PlayerData[3] = PlayerData[3] - amount;
	}
	
	public void subAttackPotion(int amount) {
		PlayerData[2] = PlayerData[2] - amount;
	}
	
	public void addKey(int amount) {
		PlayerData[7] = PlayerData[7] + amount;
	}
	
	public void subKey(int amount) {
		PlayerData[7] = PlayerData[7] - amount;
	}
	
	public void addCoin(int amount) {
		PlayerData[9] = PlayerData[9] + amount;
	}
	
	public void subCoin(int amount) {
		PlayerData[9] = PlayerData[9] - amount;
	}
	
	public String getName() {
		return Name[0];
	}
	
	public boolean getIsDone(int index) {
		return IsDone[index];
	}
	
	public int getKey() {
		return PlayerData[7];
	}
	
	public int getHealth() {
		return PlayerData[0];
	}

	public int getHealthPotion() {
		return PlayerData[1];
	}
	
	public int getDefendPotion() {
		return PlayerData[3];
	}
	
	public int getAttackPotion() {
		return PlayerData[2];
	}
	
	public int getSwordMin() {
		return PlayerData[4];
	}
	
	public int getSwordMax() {
		return PlayerData[5];
	}
	
	public int getArmorMin() {
		return PlayerData[6];
	}
	
	public int getArmorMax() {
		return PlayerData[8];
	}
	
	public boolean checkCombo(int index, int firstDigit, int secondDigit, int thirdDigit) {
		boolean isGood = false;
		if(SafeCombo[index] == firstDigit) {
			if(SafeCombo[index + 1] == secondDigit) {
				if(SafeCombo[index + 2] == thirdDigit) {
					isGood = true;
				}
			}
		} 
		
		return isGood;
	}
	
	public void showInv() {
		Tools.fastText(Name[0] + "'s Inventory:");
		Tools.fastText("Health: " + PlayerData[0] + "/100");
		Tools.fastText("Money: " + PlayerData[9]);
		System.out.println();
		Tools.fastText("/============================================>");
		Tools.fastText("|heath potions..........................." + PlayerData[1]);
		Tools.fastText("|Attack potions.........................." + PlayerData[2]);
		Tools.fastText("|Defend potions.........................." + PlayerData[3]);
		Tools.fastText("|Keys...................................." + PlayerData[7]);
		Tools.fastText("|============================================>");
		Tools.fastText("|Armor: " + Name[1]);
		Tools.fastText("|Your armor protects you from " + PlayerData[6] + "-" + PlayerData[8] + " damage.");
		Tools.fastText("|");
		Tools.fastText("|Sword: " + Name[2]);
		Tools.fastText("|Your sword gives you an extra " + PlayerData[4] + "-" + PlayerData[5] + " damage.");
		Tools.fastText("\\============================================>");
	}
	
	public void load(Scanner input) {
		try (Scanner fin = new Scanner(new File("saves\\" + Name[3] + ".txt"))) {
			Tools.slowText("Loading save data...");
			int i = 0, place = 0;
			@SuppressWarnings("unused")
			boolean dump;
			
			while(fin.hasNextInt()) {
				PlayerData[i] = fin.nextInt();
				i++;
			}
			
			i = 0;

			dump = fin.nextBoolean();
			
			place = fin.nextInt();
			
			while(fin.hasNextBoolean()) {
				IsDone[i] = fin.nextBoolean();
				i++;
			}
			
			i = 0;
			while(fin.hasNextInt()) {
				SafeCombo[i] = fin.nextInt();
				i++;
			}
			
			i = 0;
			while(fin.hasNext()) {
				Name[i] = fin.next();
				Name[i] = Name[i].replace('_', ' ');
				i++;
			}
			
			Tools.clearScreen();
			
			switch (place) {
			case 0:
				break;
			case 1:
				break;
			default:
				Tools.slowText("Error: Save place out of bounds.");
				System.exit(0);
			}
		} catch (FileNotFoundException e) {
			String action;
			boolean isGood = false;
			while (isGood == false) {
				Tools.clearScreen();
				Tools.slowText("There is no save file with that name.");
				Tools.slowText("Would you like to create a new save file with name \"" + Name[3] + "\"?");
				Tools.slowText("(Y/N)");
				Tools.slowTextN(">");
				action = input.nextLine();
				action = action.toLowerCase();
				System.out.println();
				switch (action) {
				case "y":
					Tools.slowText("Creating save file");

					save(0);

					Tools.slowText("Done!");
					Tools.sleep(2);
					isGood = true;
					break;
				case "n":
					Tools.slowText("Contining without saving...");
					Tools.sleep(2);
					isGood = true;
					break;
				default:
					Tools.slowText("Not a value input!");
					Tools.sleep(1);
				}
			}
		}
	}
	
	public void save(int place) {
		Name[4] = Name[1];
		Name[5] = Name[2];
		Name[4] = Name[4].replace(' ', '_');
		Name[5] = Name[5].replace(' ', '_');
		boolean buffer = false;
		try (PrintWriter fout = new PrintWriter(new File("saves\\" + Name[3] + ".txt"))) {
			for (int i = 0; i < PlayerData.length; i++) {
				fout.print(PlayerData[i] + " ");
			}
			fout.println();
			
			fout.println(buffer);
			
			fout.println(place);
			              
			for (int i = 0; i < IsDone.length; i++) {
				fout.print(IsDone[i] + " ");
			}
			fout.println();
			
			for (int i = 0; i < SafeCombo.length; i++) {
				fout.print(SafeCombo[i] + " ");
			}
			fout.println();
			
			for (int i = 3; i < Name.length; i++) {
				fout.print(Name[i] + " ");
			}
		} catch (FileNotFoundException e) {
			System.out.println();
			Tools.slowText("Critcal Error");
			System.exit(0);
		}
	}
}