package edu.duke;
import java.util.ArrayList;

public class LargestQuakes {
	public static void main(String args[])
	{
		findLargestQuakes();
	}
	public static int indexOfLargest(ArrayList<QuakeEntry> quakeData) {
		int largestIndex = 0;
		for (int i = 1; i < quakeData.size(); i++) {
			if (quakeData.get(i).getMagnitude() > quakeData.get(largestIndex).getMagnitude()) {
				largestIndex = i;
			}
		}

		return largestIndex;
	}

	public static ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany) {
		ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData);
		ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();

		for (int i = 1; i <= howMany ; i++) {
			int largestIndex = indexOfLargest(copy);
			ret.add(copy.get(largestIndex));
			copy.remove(largestIndex);
		}

		return ret;
	}

	public static void findLargestQuakes() {
		EarthQuakeParser parser = new EarthQuakeParser();
		String source = "nov20quakedata.atom";
		//String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
		ArrayList<QuakeEntry> list  = parser.read(source);
		System.out.println("read data for "+list.size());

		ArrayList<QuakeEntry> largestQuakes = getLargest(list, 50);
		for (QuakeEntry entry : largestQuakes){
			System.out.println(entry);
		}

		System.out.println("number found: " + largestQuakes.size());
	}
}
