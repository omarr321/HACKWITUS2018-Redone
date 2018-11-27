package control;

import java.util.Scanner;
import tools.Tools;

public class CreateName {
	public static void start(String[] name, Scanner input) {
		Tools.clearScreen();
		String temp = "Error: Name was not found", username = "", change = "";
		boolean goodName = false;
		boolean nameError = false;
		while (goodName == false) {
			Tools.clearScreen();
			Tools.slowText("What is your name?");
			System.out.println();
			Tools.slowTextN(">");
			temp = input.nextLine();
			System.out.println();
			for (int i = 0; i < temp.length(); i++) {
				switch(temp.charAt(i)) {
				case '1':
					nameError = true;
					break;
				case '2':
					nameError = true;
					break;
				case '3':
					nameError = true;
					break;
				case '4':
					nameError = true;
					break;
				case '5':
					nameError = true;
					break;
				case '6':
					nameError = true;
					break;
				case '7':
					nameError = true;
					break;
				case '8':
					nameError = true;
					break;
				case '`':
					nameError = true;
					break;
				case '~':
					nameError = true;
					break;
				case '!':
					nameError = true;
					break;
				case '@':
					nameError = true;
					break;
				case '#':
					nameError = true;
					break;
				case '$':
					nameError = true;
					break;
				case '%':
					nameError = true;
					break;
				case '^':
					nameError = true;
					break;
				case '&':
					nameError = true;
					break;
				case '*':
					nameError = true;
					break;
				case '(':
					nameError = true;
					break;
				case ')':
					nameError = true;
					break;
				case '-':
					nameError = true;
					break;
				case '_':
					nameError = true;
					break;
				case '=':
					nameError = true;
					break;
				case '+':
					nameError = true;
					break;
				case '9':
					nameError = true;
					break;
				case '\\':
					nameError = true;
					break;
				case '|':
					nameError = true;
					break;
				case '{':
					nameError = true;
					break;
				case '}':
					nameError = true;
					break;
				case '[':
					nameError = true;
					break;
				case ']':
					nameError = true;
					break;
				case ';':
					nameError = true;
					break;
				case ':':
					nameError = true;
					break;
				case '\'':
					nameError = true;
					break;
				case '"':
					nameError = true;
					break;
				case ',':
					nameError = true;
					break;
				case '<':
					nameError = true;
					break;
				case '.':
					nameError = true;
					break;
				case '/':
					nameError = true;
					break;
				case '?':
					nameError = true;
					break;
				case '0':
					nameError = true;
					break;
				default:
				}
			}
			if (nameError == true) {
				Tools.slowText("Your name can only contain letters and spaces.");
				nameError = false;
			} else if (temp.equals("")) {
				Tools.slowText("Your name can not be blank!");
				Tools.sleep(2);
			} else {
				break;
			}
		}
		
		for(int i = 0; i < temp.length(); i++) {
			if (i + 1 == temp.length()) {
				change = change + temp.charAt(i);
				username = username + change.substring(0, 1).toUpperCase() + change.substring(1).toLowerCase();
				change = "";
			} else if(temp.charAt(i) == ' '){
				username = username + change.substring(0, 1).toUpperCase() + change.substring(1).toLowerCase() + ' ';
				change = "";
			}else {
				change = change + temp.charAt(i);
			}
		}
		
		name[0] = username;
		username = username.replace(' ', '_');
		name[3] = username;
	}
}
