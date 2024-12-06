import greenfoot.*;
/**
 * Write a description of class timzhanghealth here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class playerhealth extends Character{
    // instance variables - replace the example below with your own
    private int x;
    /**
     * Constructor for objects of class timzhanghealth
     */
    public playerhealth(){
        GreenfootImage img = new GreenfootImage( 500, 50 );
        img.drawRect(500,50,hp,50); // draws the open rectangle as a border around the image.
        img.setColor( Color.RED );
        img.fillRect(0,0,hp,50); // draws the filled rectangle inside the open rectangle.
        setImage( img ); 
    }
    public void calchealth(){
        GreenfootImage img = getImage();
        img.clear();
        img.setColor(Color.BLACK);
        img.drawRect(500,50,hp,50);
        img.setColor( Color.YELLOW );
        hp -= 100; // add points to current score
        img.fillRect( 0,0,hp,50);
    }
}
