package edu.duke;


/**
 * Write a description of class DifferentSorters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class DifferentSorters {
    public static void main(String args[])
    {
        // sortByMagnitude();
        sortByTitleComparator();
    }
    public static void sortWithCompareTo() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "earthQuakeDataWeekDec6sample1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list);
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }    

    public static void sortByMagnitude() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "earthQuakeDataWeekDec6sample1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new MagnitudeComparator());
        // for(QuakeEntry qe: list) {
        //     System.out.println(qe);
        // }
        System.out.println(list.get(600).getInfo());

    }
    public static void sortByTitleComparator() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "earthQuakeDataWeekDec6sample2.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        Collections.sort(list, new TileComparator());
        // for(QuakeEntry qe: list) {
        //     System.out.println(qe);
        // }
        System.out.println(list.get(500));

    }
    
    public static void sortByDistance() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "earthQuakeDataWeekDec6sample1.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        // Location is Durham, NC
        Location where = new Location(35.9886, -78.9072);
        Collections.sort(list, new DistanceComparator(where));
        for(QuakeEntry qe: list) {
            System.out.println(qe);
        }

    }
}
