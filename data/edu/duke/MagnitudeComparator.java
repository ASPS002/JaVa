package edu.duke;


/**
 * Write a description of class MagnitudeComparator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class MagnitudeComparator implements Comparator<QuakeEntry> {
    public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        if(qe1.getMagnitude()==qe2.getMagnitude())
        {
            return Double.compare(qe1.getDepth(), qe2.getDepth());
        }
        return Double.compare(qe1.getMagnitude(), qe2.getMagnitude());
    }
    
}
