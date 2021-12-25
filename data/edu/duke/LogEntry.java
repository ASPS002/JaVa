/**
 * Write a description of class LogRecord here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
package edu.duke;

import java.util.*;
import java.util.HashMap;

public class LogEntry extends WebLogParser {

  private String ipAddress;
  private Date accessTime;
  private String request;
  private int statusCode;
  private int bytesReturned;
  private static ArrayList<LogEntry> records;

  public LogEntry(String ip, Date time, String req, int status, int bytes) {
    ipAddress = ip;
    accessTime = time;
    request = req;
    statusCode = status;
    bytesReturned = bytes;
  }

  public String getIpAddress() {
    return ipAddress;
  }

  public Date getAccessTime() {
    return accessTime;
  }

  public String getRequest() {
    return request;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public int getBytesReturned() {
    return bytesReturned;
  }

  public String toString() {
    return (
      ipAddress +
      " " +
      accessTime +
      " " +
      request +
      " " +
      statusCode +
      " " +
      bytesReturned
    );
  }

  public void testLogEntry() {
    LogEntry le = new LogEntry(
      "1.2.3.4",
      new Date(),
      "example request",
      200,
      500
    );
    System.out.println(le);
    LogEntry le2 = new LogEntry(
      "1.2.100.4",
      new Date(),
      "example request 2",
      300,
      400
    );
    System.out.println(le2);
  }

  public void testLogAnalyzer() {
    // complete method
  }

  public static void main(String args[]) {
    records = new ArrayList<LogEntry>();
    FileResource f = new FileResource("weblog2_log.txt");
    for (String s : f.lines()) {
      LogEntry entry = WebLogParser.parseEntry(s);
      records.add(entry);
    }
    // for (LogEntry le : records) {
    //   System.out.println(le);
    // }
    countUniqueids();
    printAllHigherThanNum(400, 499);
    uniqueIPVisitsOnDay("Sep 30");
    mostNumberVisitsByIP();
  }

  public static void countUniqueids() {
    ArrayList<String> uniqueIps = new ArrayList<String>();
    for (LogEntry le : records) {
      String Ipadd = le.getIpAddress();
      if (!uniqueIps.contains(Ipadd)) {
        uniqueIps.add(Ipadd);
      }
    }
    // System.out.println("Unique =" + uniqueIps.size());
  }

  public static void printAllHigherThanNum(int lw, int hi) {
    ArrayList<Integer> stagrtnum = new ArrayList<Integer>();
    ArrayList<String> uniqueIps = new ArrayList<String>();
    for (LogEntry le : records) {
      int value = le.getStatusCode();
      // System.out.println(value);
      String Ipadd = le.getIpAddress();
      if (!uniqueIps.contains(Ipadd) && value >= lw && value <= hi) {
        stagrtnum.add(value);
        uniqueIps.add(Ipadd);
      }
    }
    // for (Integer status : stagrtnum) {
    //   System.out.println(status);
    // }
    // System.out.println(uniqueIps.size());
  }

  public static void uniqueIPVisitsOnDay(String s) {
    ArrayList<String> uniqueIps = new ArrayList<String>();
    HashMap<String, Integer> myMap = new HashMap<String, Integer>();
    for (LogEntry le : records) {
      Date d = le.getAccessTime();
      String date = d.toString();
      // System.out.println(date.substring(4, 10));
      if (date.substring(4, 10).equals(s)) {
        String Ipadd = le.getIpAddress();
        if (!myMap.containsKey(Ipadd)) {
          // System.out.println(Ipadd);
          myMap.put(Ipadd, 1);
          // System.out.println(myMap.size());
        } else {
          myMap.put(Ipadd, myMap.get(Ipadd) + 1);
        }
        // if (!uniqueIps.contains(Ipadd)) {
        //   uniqueIps.add(Ipadd);
        // }
      }
    }
    for (String sd : myMap.keySet()) {
      System.out.println(sd + " " + myMap.get(sd));
    }
    // System.out.println("Unique =" + uniqueIps.size());
  }

  public static void mostNumberVisitsByIP() {
    HashMap<String, Integer> myMap = new HashMap<String, Integer>();

    for (LogEntry le : records) {
      String Ipadd = le.getIpAddress();
      // System.out.println(Ipadd);
      if (!myMap.containsKey(Ipadd)) {
        // System.out.println(Ipadd);
        myMap.put(Ipadd, 1);
        // System.out.println(myMap.size());
      } else {
        myMap.put(Ipadd, myMap.get(Ipadd) + 1);
      }
    }
    // for (String s : myMap.keySet()) {
    //   System.out.println(s + " " + myMap.get(s));
    // }
  }
}
