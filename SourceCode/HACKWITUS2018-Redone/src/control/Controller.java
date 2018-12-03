package control;

import java.util.Scanner;
import areaOne.ControllerA1;
import tools.Player;

public class Controller {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Player player = new Player();
		
		SplashScreen.start(input);
		
		CreateName.start(player, input);
		player.load(input);
		
		ControllerA1.start(player, input);
		
		
		input.close();
	}
}