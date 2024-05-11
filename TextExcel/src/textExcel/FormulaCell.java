/* Brandon Lum
 * March 8 2024
 */
package textExcel;

public class FormulaCell extends RealCell {
	private Spreadsheet spreadsheet;
	private String equation;
	
	//constructor
	public FormulaCell(String s, Spreadsheet sheet) {
		super(s);
		equation = s;
		spreadsheet = sheet;
		
	}
	//returns full cell text
	public String fullCellText() {
		return equation;
	}
	
	//calls getDoubleValue()
	public String abbreviatedCellText() {
		return (getDoubleValue() + "         ").substring(0,10);
	}
	
	//solves equation without using PEMDAS
	public Double getDoubleValue() {
		String[] arr = equation.split(" ");
		//double to be returned
		Double d = 0.0;
		
		//checks if sum command
		if (equation.toUpperCase().contains("SUM")) {
			return cellRangeSum(arr[2].split("-")[0], arr[2].split("-")[1]);
			
		//check if average command
		} else if (equation.toUpperCase().contains("AVG")) {
			return cellRangeAvg(arr[2].split("-")[0], arr[2].split("-")[1]);

		//assumes equation is a arithmetic formula	
		} else {
		//checks if first value is a cell location
			if (Character.isLetter(arr[1].charAt(0))) {
				d = cellIdentifierToValue(arr[1]);
			} else {
				d = Double.parseDouble(arr[1]);
			}	
			for (int i = 2; i < arr.length-1; i+=2) {
				//checks String at array index is a cell location
				//changes String at that index from a cell location to double
				if (Character.isLetter(arr[i+1].charAt(0))) {
					arr[i+1] = cellIdentifierToValue(arr[i+1]) + "";
				}
				if (arr[i].equals("+")) {
					d += Double.parseDouble(arr[i+1]);
				} else if (arr[i].equals("-")) {
					d -= Double.parseDouble(arr[i+1]);
				} else if (arr[i].equals("*")){
					d *= Double.parseDouble(arr[i+1]);
				} else {
					d /= Double.parseDouble(arr[i+1]);
				}
			}
		}
		return d;
	}
	
	//returns the sum of cells within the range (top left to bottom right) as a double
	private Double cellRangeSum(String topLeftCell, String bottomRightCell) {
		SpreadsheetLocation	topLeftLoc = new SpreadsheetLocation(topLeftCell);
		SpreadsheetLocation bottomRightLoc = new SpreadsheetLocation(bottomRightCell);
		Double sum = 0.0;
		//nested for loop to add all cell values up
		for (int rowIndex = topLeftLoc.getRow(); rowIndex <= bottomRightLoc.getRow(); rowIndex ++){
			for (int colIndex = topLeftLoc.getCol(); colIndex <= bottomRightLoc.getCol(); colIndex++) {
				//cell identifier
				int  charInt = 'A' + colIndex;
				char car = (char)charInt;
				String cellIdentifier = car + "" + (rowIndex + 1);
				sum += cellIdentifierToValue(cellIdentifier);
			}
		}
		return sum;
	}
	
	private Double cellRangeAvg(String topLeftCell, String bottomRightCell) {
		SpreadsheetLocation	topLeftLoc = new SpreadsheetLocation(topLeftCell);
		SpreadsheetLocation bottomRightLoc = new SpreadsheetLocation(bottomRightCell);
		Double sum = 0.0;
		int cellCount = 0;
		//nested for loop to add all cell values up
		for (int rowIndex = topLeftLoc.getRow(); rowIndex <= bottomRightLoc.getRow(); rowIndex ++){
			for (int colIndex = topLeftLoc.getCol(); colIndex <= bottomRightLoc.getCol(); colIndex++) {
				//cell identifier
				int  charInt = 'A' + colIndex;
				char car = (char)charInt;
				String cellIdentifier = car + "" + (rowIndex + 1);
				sum += cellIdentifierToValue(cellIdentifier);
				cellCount++;
			}
		}
		return sum / cellCount;
	}
	
	//returns the double value of cell
	//cell identifier is parameter
	private Double cellIdentifierToValue(String str) {
		SpreadsheetLocation spreadsheetLocation = new SpreadsheetLocation(str);
		RealCell realCell = (RealCell)spreadsheet.getCell(spreadsheetLocation);
		return realCell.getDoubleValue();

	}
	
}	

