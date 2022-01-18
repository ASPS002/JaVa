package edu.duke;
public interface Filter
{
    public boolean satisfies(QuakeEntry qe);
    public String getName();
}
