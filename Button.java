import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    /**
     * Act - do whatever the Button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x1;
    private int x2;
    private int y1;
    private int y2;
    public Button(int x1, int x2, int y1, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
    }
    public boolean hovered() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse.getX() >= x1 && mouse.getX() <= x2) {
            if (mouse.getY() >= y1 && mouse.getY() <= y2) {
                return true;
            }
        }
        return false;
    }
}
