package edu.duke;
import java.util.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }
    public static void main(String args[])
    {
        // quakesWithFilter();
        testMatchAllFilter();
    }
    public static ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public static void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");

        Filter f1 = new MagnitudeFilter("Magnitude", 3.5, 4.5);
        Filter f2 = new DepthFilter("Depth", -55000.0, -20000.0);
        Filter f3=new PhaseFilter("Phase", "end", "a");
        Filter f4=new DistanceFilter("Distance",new Location(55.7308, 9.1153),3000000.0);
        ArrayList<QuakeEntry> result  = filter(filter(list, f4), f3);
        for (QuakeEntry qe: result) {
            System.out.println(qe);
        }

        // This location is Denver, Colorado
/*      Location city =  new Location(39.7392, -104.9903);
        Filter f3 = new DistanceFilter("Distance", city, 10000000);
        Filter f4 = new PhaseFilter("Phase", "end", "a");
        ArrayList<QuakeEntry> result  = filter(filter(list, f3),  f4);
        for (QuakeEntry qe: result) {
            System.out.println(qe);
        }*/

        System.out.println("Found " + result.size() + " quakes that match that criteria");
    }

    public static void testMatchAllFilter() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter("Magnitude", 0.0, 5.0));
        // maf.addFilter(new DepthFilter("Depth", -180000.0, -30000.0));
       
        maf.addFilter(new DistanceFilter("Distance",new Location(55.7308, 9.1153),3000000.0));
        maf.addFilter(new PhaseFilter("Phase", "title", "e"));
        System.out.println("Filters used are: " + maf.getName());
        ArrayList<QuakeEntry> result  = filter(list, maf);
        for (QuakeEntry qe: result) {
            System.out.println(qe);
        }

        System.out.println("Found " + result.size() + " quakes that match that criteria");
    }

    public static void testMatchAllFilter2() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "Earthquakes/data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        MatchAllFilter maf = new MatchAllFilter();
        maf.addFilter(new MagnitudeFilter("Magnitude", 0.0, 5.0));
        Location city = new Location(55.7308, 9.1153);   // Billund, Denmark
        maf.addFilter(new DistanceFilter("Distance", city, 10000000));
        maf.addFilter(new PhaseFilter("Phase", "any", "e"));

        System.out.println("Filters used are: " + maf.getName());
        ArrayList<QuakeEntry> result  = filter(list, maf);
        for (QuakeEntry qe: result) {
            System.out.println(qe);
        }

        System.out.println("Found " + result.size() + " quakes that match that criteria");
    }

    public static void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public static void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
