import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1); 
        prepare();
        
        
        setBackground("RodRoom.png");
    }
    private void prepare() {
        addObject(new timzhang(), 960, 720);
        addObject(new rod(), 320, 720);
        addObject(new playerhealth(),960,720); 
    }
}
