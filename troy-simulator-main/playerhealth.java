import greenfoot.*;
/**
 * Write a description of class timzhanghealth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerhealth extends Fighter{
    // instance variables - replace the example below with your own
    private int x;
    private GreenfootImage myImage;
    /**
     * Constructor for objects of class timzhanghealth
     */
    public playerhealth()
    {
        myImage = new GreenfootImage(350,100);
        Actor fighter = (Actor)getWorld().getObjects(Fighter.class).get(0);
        int health = hp; 
        
        Picture drawOnWorld = new Picture (myImage); 
        addObject(drawOnWorld, 300,200); 
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
    public void drawRect(int topLeftx, int topLefty){
        myImage.setColor(Color.RED);
    }
}
