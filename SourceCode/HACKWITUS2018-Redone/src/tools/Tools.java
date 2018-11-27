package tools;

public class Tools {
	public static void clearScreen() {
		for (int i = 0; i < 40; i++)
			System.out.println();
	}

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void slowText(String text) {
		for (int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i));
			try {
				Thread.sleep(55);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}

	public static void slowTextN(String text) {
		for (int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i));
			try {
				Thread.sleep(55);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void slowTextLine(String text) {
		System.out.println(text);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void fastText(String text) {
		for (int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println();
	}
	
	public static void fastTextN(String text) {
		for (int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i));
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static int random(int min, int max) {
		int range = (max - min) + 1;
		return (int) (Math.random() * range) + min;
	}

	public static void showInv(int[] playerInfo, String[] name) {
		fastText(name[0] + "'s Inventory:");
		fastText("Health: " + playerInfo[0] + "/100");
		fastText("Money: " + playerInfo[9]);
		System.out.println();
		fastText("/============================================>");
		fastText("|heath potions..........................." + playerInfo[1]);
		fastText("|Attack potions.........................." + playerInfo[2]);
		fastText("|Defend potions.........................." + playerInfo[3]);
		fastText("|Keys...................................." + playerInfo[7]);
		fastText("|============================================>");
		fastText("|Armor: " + name[1]);
		fastText("|Your armor protects you from " + playerInfo[6] + "-" + playerInfo[8] + " damage.");
		fastText("|");
		fastText("|Sword: " + name[2]);
		fastText("|Your sword gives you an extra " + playerInfo[4] + "-" + playerInfo[5] + " damage.");
		fastText("\\============================================>");
	}
}