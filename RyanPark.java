import greenfoot.*;
/**
 * Write a description of class RyanPark here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RyanPark extends Fighter 
{
    /**
     * Constructor for objects of class RyanPark
     */
    public RyanPark()
    {
        setImage("r5.png");
        fileprefix = "r";
        maxhp = 100;
        hp = 100;
        damage = 5;
        name = "Ryan Park";
        rightidle = new GreenfootImage(fileprefix + "idle.png");
        leftidle = new GreenfootImage(fileprefix + "idle.png");
        leftidle.mirrorHorizontally();
        jumpright = new GreenfootImage(fileprefix + "jump.png");
        jumpleft = new GreenfootImage(fileprefix + "jump.png");
        jumpleft.mirrorHorizontally();
    }
}
