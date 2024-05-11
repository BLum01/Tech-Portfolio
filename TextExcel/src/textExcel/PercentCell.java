package textExcel;

public class PercentCell extends RealCell {
	private String decimal;
	
	//constructor
	public PercentCell(String s) {
		super(s);
		decimal = s;
	}
	//gets percentage as a decimal
	public Double getDoubleValue() {
		return (Double.parseDouble(decimal.substring(0,decimal.length()-1)))/100;
	}
	
	// text for spreadsheet cell display, must be exactly length 10
	public String abbreviatedCellText() {
			String[] arr = decimal.split("\\.");
			return (arr[0] + "%" + "          ").substring(0,10);
	}
	
	// text for individual cell inspection, not truncated or padded
	public String fullCellText() {
		return getDoubleValue() + "";
	}
	
}
