/* Brandon Lum
 * Febuary 26 2024
 */
package textExcel;

public class EmptyCell implements Cell{
	private String cell;
	public EmptyCell() {	
		cell = "";
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		return "          ";
	}
	
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return "";
	}
}


