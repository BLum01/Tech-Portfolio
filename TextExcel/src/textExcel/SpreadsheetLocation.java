/* Brandon Lum
 * Febuary 26 2024
 */
package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location {
	private int columnIndex;
	private int rowIndex;
    
	
	//returns row index
    public int getRow() {
        // TODO Auto-generated method stub
        return rowIndex;
    }

    //returns column index
    public int getCol() {
        // TODO Auto-generated method stub
        return columnIndex;
    } 
    
    public SpreadsheetLocation(String cellName) {
        // TODO: Fill this out with your own code
    	columnIndex = cellName.toUpperCase().charAt(0)-'A';
    	rowIndex = Integer.parseInt(cellName.substring(1))-1;
    	
    	
    }

}
