import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class rod here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class rod extends Enemy
{
    /**
     * Act - do whatever the rod wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public rod() {
        hp = 200; // PLACEHOLDER
        maxhp = 200;
        difficulty = 100;
        damage = 5;
        name = "Mr. Rod";
        velocity = 2;
    }
}
