import greenfoot.*;
/**
 * Write a description of class TimZhang here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TimZhang extends Fighter 
{
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class TimZhang
     */
    public TimZhang()
    {
        setImage("t5.png");
        fileprefix = "t";
        maxhp = 100;
        hp = 100;
        damage = 5;
        name = "Tim Zhang";
        rightidle = new GreenfootImage(fileprefix + "idle.png");
        leftidle = new GreenfootImage(fileprefix + "idle.png");
        leftidle.mirrorHorizontally();
        jumpright = new GreenfootImage(fileprefix + "jump.png");
        jumpleft = new GreenfootImage(fileprefix + "jump.png");
        jumpleft.mirrorHorizontally();
    }
}
