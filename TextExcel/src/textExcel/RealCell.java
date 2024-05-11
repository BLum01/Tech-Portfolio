/* Brandon Lum
 * March 19 2024
 */
package textExcel;

public class RealCell implements Cell {
	private String stringRealCell;
	
	public RealCell(String s) {
		stringRealCell = s;
	}
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		return (getDoubleValue() + "          ").substring(0,10);
	}
	
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return stringRealCell;
	}
	
	//returns cell value as a double
	//can be used for calculations
	public Double getDoubleValue() {
		return Double.parseDouble(stringRealCell);
	}
}
