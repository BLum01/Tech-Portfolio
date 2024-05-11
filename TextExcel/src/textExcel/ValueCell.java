/* Brandon Lum
 * March 19 2024
 */
package textExcel;

public class ValueCell extends RealCell{
	
	public ValueCell(String s) {
		super(s);
	}
	 // text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		return super.abbreviatedCellText();
	}

	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return super.fullCellText();
	}
}
