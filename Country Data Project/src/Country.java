/* Brandon Lum
 * Checkpoint 5 Country Class
 * January 10 2023
 */


import java.util.ArrayList;

public class Country {
	private String countryName;
	private String series;
	private ArrayList<Integer> years;
	private ArrayList<Double> data;
		
	public Country(String countryName, String series, ArrayList<Integer> years, ArrayList<Double> data){	
		this.countryName = countryName;
		this.series = series;
		this.years = years;
		this.data = data;
	}
	
	public void addDataPoint(int year, double newDatum) {
		this.years.add(year);
		this.data.add(newDatum);
	}
	
	public void editDataPoint(int year, double newDatum) {
		for (int i = 0; i < this.years.size(); i++) {
			if(years.get(i) == year) {
				data.set(i, newDatum);
				break;
			}
		}
	}
	
	//accessors
	public String getSeries() {
		return this.series.split("\\(")[0];
	}
	
	//get Units of series
	public String getUnits() {
		if (series.split("\\)",-1).length <= 1) {
			return "";
		} else {
			String[] arr = series.split("\\(");
			return arr[1].substring(0,arr[1].length()-1);
		}
	}
	public String getYearsRange() {
		return " for " + years.get(0) + "-" + years.get(years.size()-1);
	}
	
	//get trend
	public String getTrend() {
		if (trendsUp() == true) {
			return "up";
		}else if(trendsDown() == true) {
			return "down";
		} else
			return "no trend";
	}
	
	public ArrayList<Double> getData() {
		return data;
	}
	
	public String getCountry() {
		return countryName;
	}
	
	public ArrayList<Integer> getYears() {
		return years;
	}
	
	
	//mutators
	public void setData(ArrayList<Double> values) {
		data = values;
	}
	
	public void setSeries(String s) {
		series = s;
	}

	
	//calculates minimum
	public double min() {
		double smallest = data.get(0);
		for (double d : data) {
			if(d<smallest) {
				smallest = d;
			}
		}			
		return smallest;
	}
		
	//calculates max
	public double max() {
		double largest = data.get(0);
		for (double d : data) {
			if (d>largest) {
				largest = d;
			}		
		}
		return largest;
	}
	
	private boolean trendsUp() {
		for (int i = 0; i<data.size()-1; i++) {
			if (data.get(i)>=data.get(i+1)) {
				return false;
			}
		}
		return true;
	}
	private boolean trendsDown() {
		for (int i = 0; i<data.size()-1; i++) {
			if(data.get(i)<=data.get(i+1)) {
				return false;
			}
		}
		return true;
	}
	
	//gets acronym
	public  String getAcronym() {
		String[] s = series.split("\\(")[0].split(" ");
		String abbr = "";
		for (String str : s) {
			if(str.equals("of") || str.equals("in") || 
					str.equals("the") || str.equals("at") || 
					str.equals("to") || str.equals("by") || 
					str.equals("per") || str.equals("on") || 
					str.equals("a") || str.equals("an") || str.equals("with")){
			} else {
				abbr += str.substring(0,1).toUpperCase();

			}
		}
		return abbr;
	}
	
	//calling toString prints out country data in the format
	public String toString() {
		String years = "";
		for (int i: this.years) {
			years += i + "\t";
		}
		String data = "";
		for (double i: this.data) {
			data += Math.round(i*100.0)/100.0 + "\t";
		}
		return years + "\n" + data + "\n" + "This is the \"" + getSeries() + "(" + getUnits() + ")" + "\" for " + 
				countryName + "\nMinimum: " + Math.round(min()*100.0)/100.0 + "\nMaximum: " + 
				Math.round(max()*100.0)/100.0 + "\nTrending: " + getTrend() + "\n";
	}
}
