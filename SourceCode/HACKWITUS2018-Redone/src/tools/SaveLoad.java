package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import tools.Tools;

public class SaveLoad {

	public static void load(int[] playerData, boolean[] isDone, String[] name, int[] safeCombo, Scanner input) {
		try (Scanner fin = new Scanner(new File("saves\\" + name[3] + ".txt"))) {
			Tools.slowText("Loading save data...");
			int i = 0, place = 0;
			@SuppressWarnings("unused")
			boolean dump;
			
			while(fin.hasNextInt()) {
				playerData[i] = fin.nextInt();
				i++;
			}
			
			i = 0;

			dump = fin.nextBoolean();
			
			place = fin.nextInt();
			
			while(fin.hasNextBoolean()) {
				isDone[i] = fin.nextBoolean();
				i++;
			}
			
			i = 0;
			while(fin.hasNextInt()) {
				safeCombo[i] = fin.nextInt();
				i++;
			}
			
			i = 0;
			while(fin.hasNext()) {
				name[i] = fin.next();
				name[i] = name[i].replace('_', ' ');
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
				Tools.slowText("Would you like to create a new save file with name \"" + name[3] + "\"?");
				Tools.slowText("(Y/N)");
				Tools.slowTextN(">");
				action = input.nextLine();
				action = action.toLowerCase();
				System.out.println();
				switch (action) {
				case "y":
					Tools.slowText("Creating save file");

					save(playerData, isDone, name, safeCombo, 0);

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

	public static void save(int[] playerData, boolean[] isDone, String[] name, int[] safeCombo, int place) {
		name[4] = name[1];
		name[5] = name[2];
		name[4] = name[4].replace(' ', '_');
		name[5] = name[5].replace(' ', '_');
		boolean buffer = false;
		try (PrintWriter fout = new PrintWriter(new File("saves\\" + name[3] + ".txt"))) {
			for (int i = 0; i < playerData.length; i++) {
				fout.print(playerData[i] + " ");
			}
			fout.println();
			
			fout.println(buffer);
			
			fout.println(place);
			              
			for (int i = 0; i < isDone.length; i++) {
				fout.print(isDone[i] + " ");
			}
			fout.println();
			
			for (int i = 0; i < safeCombo.length; i++) {
				fout.print(safeCombo[i] + " ");
			}
			fout.println();
			
			for (int i = 3; i < name.length; i++) {
				fout.print(name[i] + " ");
			}
		} catch (FileNotFoundException e) {
			System.out.println();
			Tools.slowText("Critcal Error");
			System.exit(0);
		}
	}
}