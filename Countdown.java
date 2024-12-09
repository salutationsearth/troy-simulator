import greenfoot.Actor;

/**
 * Write a description of class Countdown here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Countdown extends Actor
{
    // instance variables - replace the example below with your own
    public int time;
    public String type;
    /**
     * Constructor for objects of class Countdown
     */
    public Countdown(int time, String type)
    {
        this.time = time;
        this.type = type;
    }
    public void act() {
        if (time <= 0) {
            getWorld().removeObject(this);
        }
        time--;
        System.out.println("cooldown");
    }
}
