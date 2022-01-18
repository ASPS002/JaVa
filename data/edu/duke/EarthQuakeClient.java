package edu.duke;

import java.util.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }
    public static void main(String args[])
    {
        // quakesByPhrase();
        // bigQuakes();
        // quakesOfDepth();
        quakesByPhrase();
    }
    public static ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();

        for (QuakeEntry entry : quakeData) {
            if (entry.getMagnitude() > magMin) {
                answer.add(entry);
            }
        }

        return answer;
    }

    public static ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,
    double distMax,
    Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();

        for (QuakeEntry entry : quakeData) {
            if (entry.getLocation().distanceTo(from) < distMax) {
                answer.add(entry);
            }
        }

        return answer;
    }

    public static ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,
                                               double minDepth, double maxDepth) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();

        for (QuakeEntry entry : quakeData) {
            if (entry.getDepth() > minDepth && entry.getDepth() < maxDepth) {
                answer.add(entry);
            }
        }

        return answer;
    }

    public static ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData,
                                               String where, String phrase) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();

        for (QuakeEntry entry : quakeData) {
            String info = entry.getInfo();
            if ("start".equals(where) && info.startsWith(phrase)
                    || "end".equals(where) && info.endsWith(phrase)
                    || "any".equals(where) && info.contains(phrase)) {
                answer.add(entry);
            }
        }

        return answer;
    }

    public static void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public static void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        ArrayList<QuakeEntry> bigQuakes = filterByMagnitude(list, 5.0);

        for (QuakeEntry entry : bigQuakes) {
            System.out.println(entry);
        }

        System.out.println("Found " + bigQuakes.size() + " quakes that match that criteria");

    }

    public static  void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "Earthquakes/data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        // Location city = new Location(35.988, -78.907);

        // This location is Bridgeport, CA
        Location city =  new Location(38.17, -118.82);

        ArrayList<QuakeEntry> closeToMeQuakes = filterByDistanceFrom(list, 1000000, city);

        for (QuakeEntry entry : closeToMeQuakes) {
            System.out.println(entry.getLocation().distanceTo(city) / 1000  + " " + entry.getInfo());
        }

        System.out.println("Found " + closeToMeQuakes.size() + " quakes that match that criteria");
    }

    public static void quakesOfDepth() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        ArrayList<QuakeEntry> quakesOfDepth = filterByDepth(list,  -4000.0, -2000.0);

        // for (QuakeEntry entry : quakesOfDepth) {
        //     System.out.println(entry);
        // }

        System.out.println("Found " + quakesOfDepth.size() + " quakes that match that criteria");
    }

    public static void quakesByPhrase() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        ArrayList<QuakeEntry> quakesByPhrase = filterByPhrase(list, "any", "Can");

        for (QuakeEntry entry : quakesByPhrase) {
            System.out.println(entry);
        }

        System.out.println("Found " + quakesByPhrase.size() + " quakes that match that criteria");
    }

    public static void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    
}
