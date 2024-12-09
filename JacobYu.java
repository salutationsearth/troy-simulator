import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class timzhang here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */



public class JacobYu extends Fighter
{

    
    /**
     * Act - do whatever the timzhang wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public JacobYu() {
        setImage("f5.png");
        fileprefix = "f";
        maxhp = 100;
        hp = 100;
        damage = 5;
        name = "Jacob Yu";
        rightidle = new GreenfootImage(fileprefix + "idle.png");
        leftidle = new GreenfootImage(fileprefix + "idle.png");
        leftidle.mirrorHorizontally();
        jumpright = new GreenfootImage(fileprefix + "jump.png");
        jumpleft = new GreenfootImage(fileprefix + "jump.png");
        jumpleft.mirrorHorizontally();
    }
}
