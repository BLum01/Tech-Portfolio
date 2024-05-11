/* Brandon Lum
 * Checkpoint 5 Client Code
 * January 10 2023
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class CountryClient {
	
	public static void main(String[]args) throws FileNotFoundException{
		File inputFile = new File("CountryDataSet.csv");
		Scanner input = new Scanner(inputFile);	
		String seriesName = input.nextLine();
		
		String[] yearStr = input.nextLine().split(",");
		ArrayList<Integer> yearInt = new ArrayList<>();
		for (int i = 1; i < yearStr.length; i++) {
			yearInt.add(Integer.parseInt(yearStr[i]));
		}
		
		ArrayList<Country> country = new ArrayList<>();
		for (int i = 0; input.hasNextLine(); i++) {
			String line = input.nextLine();
			if ((line.split("\"", -1).length-1) > 0) {
				String[] temp = line.split("\"");
				String name = temp[1];
				String[] temp1 = name.split(",");
				line = (temp1[1] + " " + temp1[0] + temp[2]).substring(1);
			}
			String[] line1 = line.split(",");
			String countryName = line1[0];
			ArrayList<Double> data = new ArrayList<>();
			for (int j = 1; j < line1.length; j++) {
				data.add(Double.parseDouble(line1[j]));
			}
			Country name = new Country(countryName, seriesName, yearInt, data);
			country.add(i,name);
		}
		System.out.println(country.get(0).getAcronym() + country.get(0).getYearsRange());
		for (Country temp: country) {
			System.out.println(temp.toString());	
		}
		input.close();
	}
	
	public static void removeByName(ArrayList<Country> countries, String name) {
		for (int i = 0; i < countries.size(); i++) {
			if(countries.get(i).getCountry().equals(name)) {
				countries.remove(i);
			}
		}
	}
	
	public static void removeNoTrend(ArrayList<Country> countries) {
		for (int i = 0; i<countries.size(); i++) {
			if(countries.get(i).getTrend().equals("no trend")) {
				countries.remove(i);
				i--;
			}
		}
	}
	
	public static ArrayList<String> getListBasedOnTrend(ArrayList<Country> countries, String trendType){
		if(trendType.equals("up") || trendType.equals("down") || trendType.equals("no trend")) {	
		} else 
			throw new IllegalArgumentException("Invalid trend type");
		
		ArrayList<String> trend = new ArrayList<>();
		for (Country C : countries) {
			if(C.getTrend().equals(trendType)) {
				trend.add(C.getCountry());
			}
		}
		return trend;
	}
	
}
	