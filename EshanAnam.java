import greenfoot.*;
/**
 * Write a description of class EshanAnam here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EshanAnam extends Fighter 
{ public EshanAnam()
    {
        setImage("i5.png");
        fileprefix = "i";
        maxhp = 100;
        hp = 100;
        damage = 5;
        name = "Eshan Anam";
        rightidle = new GreenfootImage(fileprefix + "idle.png");
        leftidle = new GreenfootImage(fileprefix + "idle.png");
        leftidle.mirrorHorizontally();
        jumpright = new GreenfootImage(fileprefix + "jump.png");
        jumpleft = new GreenfootImage(fileprefix + "jump.png");
        jumpleft.mirrorHorizontally();
    }
}
