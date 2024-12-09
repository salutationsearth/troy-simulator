import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RodRoom extends World
{

    /**
     * Constructor for objects of class RodRoom.
     * 
     */
    // private FighterHealthBar fighterhealthbar = new FighterHealthBar();
    public RodRoom(Fighter fighter)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        addObject(fighter, 320, 720);
        addObject(new rod(), 960, 720);
        addObject(new FighterHealthBar(), 1280/4, 720-38);
        addObject(new EnemyHealthBar(), (1280/4)*3, 720-38);
        setBackground(new GreenfootImage("rodbackground.png"));
    }
    public void act() {
    }
}
