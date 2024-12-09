import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StatsInfo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StatsInfo extends Actor
{
    /**
     * Act - do whatever the StatsInfo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public GreenfootImage image;
    public StatsInfo(String filename) {
        image = new GreenfootImage(filename);
        setImage(image);
    }
}
