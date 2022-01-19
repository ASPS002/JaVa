package edu.duke;

/**
 * Write a description of class QuakeSortInPlace here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class QuakeSortInPlace {

  // public QuakeSortInPlace() {
  //     // TODO Auto-generated constructor stub
  // }
  public static void main(String args[]) {
    testSort();
  }

  public static void Bubblesort(ArrayList<QuakeEntry> in) {
    int cnt = 0;
    for (int i = 0; i < in.size(); i++) {
      int ti = i;
      int ff = 0;
      for (int j = 1; j < in.size(); j++) {
        if (in.get(j).getMagnitude() < in.get(j - 1).getMagnitude()) {
          ff = 1;
          break;
        }
      }
      if (ff == 0) {
        break;
      }
      for (int j = 1; j < in.size() - ti; j++) {
        if (in.get(j).getMagnitude() < in.get(j - 1).getMagnitude()) {
          QuakeEntry qi = in.get(j - 1);
          QuakeEntry qmin = in.get(j);
          in.set(j - 1, qmin);
          in.set(j, qi);
        }
      }
      cnt++;
    }
    System.out.println(cnt);
  }

  public static int getSmallestMagnitude(
    ArrayList<QuakeEntry> quakes,
    int from
  ) {
    int minIdx = from;
    for (int i = from + 1; i < quakes.size(); i++) {
      if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
        minIdx = i;
      }
    }
    return minIdx;
  }

  public static boolean issorted(ArrayList<QuakeEntry> in) {
    for (int i = 1; i < in.size(); i++) {
      if (in.get(i).getMagnitude() < in.get(i - 1).getMagnitude()) {
        return false;
      }
    }
    return true;
  }

  public static void sortByMagnitude(ArrayList<QuakeEntry> in) {
    int cnt = 0;
    for (int i = 0; i < in.size(); i++) {
      int minIdx = getSmallestMagnitude(in, i);
      QuakeEntry qi = in.get(i);
      QuakeEntry qmin = in.get(minIdx);
      in.set(i, qmin);
      in.set(minIdx, qi);
    }
    System.out.println(cnt);
  }

  public static void testSort() {
    EarthQuakeParser parser = new EarthQuakeParser();
    //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    String source = "earthQuakeDataWeekDec6sample1.atom";
    //String source = "data/nov20quakedata.atom";
    ArrayList<QuakeEntry> list = parser.read(source);

    System.out.println("read data for " + list.size() + " quakes");
    // sortByMagnitude(list);
    Bubblesort(list);
    int sz = list.size();
    // for (QuakeEntry qe: list) {
    //     System.out.println(qe);
    // }
    System.out.println(list.get(sz - 1).getDepth());
  }

  public void createCSV() {
    EarthQuakeParser parser = new EarthQuakeParser();
    //String source = "data/nov20quakedata.atom";
    String source = "data/nov20quakedatasmall.atom";
    //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
    ArrayList<QuakeEntry> list = parser.read(source);
    dumpCSV(list);
    System.out.println("# quakes read: " + list.size());
  }

  public void dumpCSV(ArrayList<QuakeEntry> list) {
    System.out.println("Latitude,Longitude,Magnitude,Info");
    for (QuakeEntry qe : list) {
      System.out.printf(
        "%4.2f,%4.2f,%4.2f,%s\n",
        qe.getLocation().getLatitude(),
        qe.getLocation().getLongitude(),
        qe.getMagnitude(),
        qe.getInfo()
      );
    }
  }
}
