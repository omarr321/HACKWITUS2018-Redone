package tools;

import java.util.Scanner;

import control.Controller;

public class Death {
	public static void death(int[] playerData, boolean[] isDone, String[] name, int[] safeCombo, Scanner input) {
		String[] args = {""};
		boolean isGood = false;
		String action;
		Tools.clearScreen();
		Tools.slowTextLine("____    ____  ______    __    __      __    __       ___   ____    ____  _______     _______   __   _______  _______   __");
		Tools.slowTextLine("\\   \\  /   / /  __  \\  |  |  |  |    |  |  |  |     /   \\  \\   \\  /   / |   ____|   |       \\ |  | |   ____||       \\ |  |");
		Tools.slowTextLine(" \\   \\/   / |  |  |  | |  |  |  |    |  |__|  |    /  ^  \\  \\   \\/   /  |  |__      |  .--.  ||  | |  |__   |  .--.  ||  |");
		Tools.slowTextLine("  \\_    _/  |  |  |  | |  |  |  |    |   __   |   /  /_\\  \\  \\      /   |   __|     |  |  |  ||  | |   __|  |  |  |  ||  |");
		Tools.slowTextLine("    |  |    |  `--'  | |  `--'  |    |  |  |  |  /  _____  \\  \\    /    |  |____    |  '--'  ||  | |  |____ |  '--'  ||__|");
		Tools.slowTextLine("    |__|     \\______/   \\______/     |__|  |__| /__/     \\__\\  \\__/     |_______|   |_______/ |__| |_______||_______/ (__)");
		Tools.sleep(2);
		while (isGood == false) {
			Tools.slowText("What would you like to do?");
			Tools.slowText("1: Load save");
			Tools.slowText("2: Restart");
			Tools.slowText("3: Quit");
			System.out.println();
			Tools.slowTextN(">");
			action = input.nextLine();
			action = action.toLowerCase();
			switch (action) {
			case "1":
				SaveLoad.load(playerData, isDone, name, safeCombo, input);
			case "2":
				Controller.main(args);;
			case "3":
				System.exit(0);
			default:
				Tools.slowText("Not a vaild input!");
			}
		}
	}
}
