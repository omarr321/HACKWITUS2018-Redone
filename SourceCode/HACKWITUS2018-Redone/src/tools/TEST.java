package tools;

import java.util.Scanner;

public class TEST {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] playerData = {100, 10, 10, 10, 50000, 100000, 40000, 0, 80000, 0};
		String[] name = {"Test", "Elite Armor", "Elite Sword", "Test", "", ""};
		
		Fight test = new Fight("TEST", "DESRIPE", 100, 1000, 1500, "IT DIES", false);
		test.run(playerData, input, name);
	}
}