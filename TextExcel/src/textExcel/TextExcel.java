/* Brandon Lum
 * Febuary 26 2024
 */
package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel {

	public static void main(String[] args) {
	    // Add your command loop here
		RealCell rc = new ValueCell("1");
		
		RealCell vc = new PercentCell("1");
		Scanner input = new Scanner(System.in);
		Spreadsheet sheet = new Spreadsheet();
		System.out.println("What is your command?");
		String command = input.nextLine();		
		while (!command.equals("quit")) {
			System.out.println(sheet.processCommand(command));
			System.out.println("What is your next command?");
			command = input.nextLine();
			
		}
		input.close();
	}
}


