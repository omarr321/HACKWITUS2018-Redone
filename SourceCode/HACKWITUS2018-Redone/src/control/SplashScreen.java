package control;

import tools.Tools;
import java.util.Scanner;

public class SplashScreen {
	public static void start(Scanner input) {
			
		Tools.clearScreen();
		Tools.slowTextLine(" ______  _______ _______ _______    _      ________________        ________________ _______ _______ _______");
		Tools.slowTextLine("(  __  \\(  ____ (  ____ (  ____ )  ( (    /\\__   __(  ____ \\\\     /\\__   __(       |  ___  |  ____ |  ____ \\");
		Tools.slowTextLine("| (  \\  ) (    \\/ (    \\/ (    )|  |  \\  ( |  ) (  | (    \\/ )   ( |  ) (  | () () | (   ) | (    )| (    \\/");
		Tools.slowTextLine("| |   ) | (__   | (__   | (____)|  |   \\ | |  | |  | |     | (___) |  | |  | || || | (___) | (____)| (__");
		Tools.slowTextLine("| |   | |  __)  |  __)  |  _____)  | (\\ \\) |  | |  | | ____|  ___  |  | |  | |(_)| |  ___  |     __)  __)");
		Tools.slowTextLine("| |   ) | (     | (     | (        | | \\   |  | |  | | \\_  ) (   ) |  | |  | |   | | (   ) | (\\ (  | (");
		Tools.slowTextLine("| (__/  ) (____/\\ (____/\\ )        | )  \\  |__) (__| (___) | )   ( |  | |  | )   ( | )   ( | ) \\ \\_| (____/\\");
		Tools.slowTextLine("(______/(_______(_______//         |/    )_)_______(_______)/     \\|  )_(  |/     \\|/     \\|/   \\__(_______/");
		Tools.sleep(2);
		Tools.slowTextLine("   ___                          __");
		Tools.slowTextLine("  / _ \\ ___   __ _  ___ _  ___ / /_ ___   ____");
		Tools.slowTextLine(" / , _// -_) /  ' \\/ _ `/ (_-</ __// -_) / __/");
		Tools.slowTextLine("/_/|_| \\__/ /_/_/_/\\_,_/ /___/\\__/ \\__/ /_/   ");
		Tools.sleep(1);
		Tools.slowText("By: Omar Radwan");
		System.out.println();
		Tools.slowText("Type anything to continue...");
		Tools.slowText("(You can type end any time during the program to exit out of the program.)");
		System.out.println();
		Tools.slowTextN(">");
		if (input.nextLine().toLowerCase().equals("end")) {
			System.exit(0);
		}
	}
}