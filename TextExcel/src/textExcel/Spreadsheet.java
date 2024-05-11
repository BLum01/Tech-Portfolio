/* Brandon Lum
 * Febuary 26 2024
 */
package textExcel;

import java.lang.reflect.Array;

public class Spreadsheet implements Grid {
	private Cell[][] spreadsheet = new Cell [getRows()][getCols()];

	//constructor
	public Spreadsheet() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j< getCols(); j++) {
				spreadsheet[i][j] = new EmptyCell();
			}
		}
	}
	
	public String processCommand(String command) {
		if (command.length() <= 1) {
			return "";
		}
		String[] arr = command.split(" ",3);
		if(arr.length > 1) {
			//checks if text command
			if(command.contains("\"")) {
				SpreadsheetLocation location = new SpreadsheetLocation(arr[0]);
				spreadsheet[location.getRow()][location.getCol()] = new TextCell(arr[2]);
			//checks if percentage command
			}else if (command.contains("%")) {
				SpreadsheetLocation location = new SpreadsheetLocation(arr[0]);
				spreadsheet[location.getRow()][location.getCol()] = new PercentCell(arr[2]);
			//checks if clear cell command
			} else if (arr[0].toUpperCase().equals("CLEAR")) {
				SpreadsheetLocation locationException = new SpreadsheetLocation(arr[1]);
				spreadsheet[locationException.getRow()][locationException.getCol()] = new EmptyCell();
			} else if (command.contains("(")) {
			//checks if formula cell command
				SpreadsheetLocation location = new SpreadsheetLocation(arr[0]);
				spreadsheet[location.getRow()][location.getCol()] 
						= new FormulaCell(command.split("=")[1].substring(1), this);
			//otherwise assumes value cell command
			} else {
				SpreadsheetLocation location = new SpreadsheetLocation(arr[0]);
				spreadsheet[location.getRow()][location.getCol()] = new ValueCell(arr[2]);
			}
			return getGridText();
			//assumes either clear or cell inspection
		} else {
			//checks if clear command
			if(command.toUpperCase().equals("CLEAR")) {
					clear();
					return getGridText();
			//assumes cell inspection
			 } else {	
				SpreadsheetLocation location = new SpreadsheetLocation(arr[0]);
				Cell cell = spreadsheet[location.getRow()][location.getCol()];
				return cell.fullCellText();
			}
		}  
	}
	
	//clears spreadsheet
	private void clear() {
		for (int i = 0; i < getRows(); i++) {
			for (int j = 0; j< getCols(); j++) {
				spreadsheet[i][j] = new EmptyCell();
			}
		}
	}

	//returns number of rows
	public int getRows() {
		return 20;
	}
	
	//returns number of columns
	public int getCols() {
		return 12;
	}
	
	//returns cell of location
	public Cell getCell(Location loc) {
		return spreadsheet[loc.getRow()][loc.getCol()];
	}

	//returns a String with the spreadsheet in grid format
	public String getGridText() {
		String text = "   |";
		//column headers
		for(int i  = 0; i < getCols(); i++) {
			text += (char)(i + 'A');
			for(int j = 0; j < 9;  j++) {
				text += " ";
			}
			text += "|";
		}
		text += "\n";
		
		//spreadsheet
		for (int i = 0 ; i < getRows(); i++) {
			//row headers
			text += i + 1;
			String number = "" + i;
			for (int j = number.length(); j < 3; j++) {
				text += " ";
				if(i == 9) {
					j++;
				}
			}
			text += "|"; 
			//filling cells with text and spaces
			for (int k = 0; k < getCols(); k++) {
				String cellText = "";
				//check if cell is empty
				if (spreadsheet[i][k] == null) {
				}else {
					cellText += spreadsheet[i][k].abbreviatedCellText();
			    }
				text += cellText;
				text += "|";
			}
			text += "\n";
		}
		return text;
	}

}
