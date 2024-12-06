import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public boolean left;
    public boolean fighter;
    public int velocity = 10;
    public Bullet(boolean direction, boolean character) {
        left = direction;
        fighter = character;
        GreenfootImage image = new GreenfootImage(50, 20);
        image.setColor(Color.BLACK);
        image.fillRect(0, 0, 100, 100);
        setImage(image);
    }
    
    public void act()
    {
        if (left) {
            setLocation(getX() - 10, getY());
        }
        else {
            setLocation(getX() + 10, getY());
        }
    }
}
