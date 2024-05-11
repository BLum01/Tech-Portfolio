/* Brandon Lum 
 * February 26 2024
 */
package textExcel;

public class TextCell implements Cell{
	private String text;
	
	public TextCell(String text) {	
		this.text = text.substring(1,text.length()-1);
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
		String text = this.text + "          ";
		return text.substring(0,10);
	}
	
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return "\"" + text + "\"";
	}
}


