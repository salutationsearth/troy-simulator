/**
 * Write a description of class DelayCounter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DelayCounter  
{
    // instance variables - replace the example below with your own
    private int target;
    private int count;
    /**
     * Constructor for objects of class DelayCounter
     */
    public DelayCounter(int target)
    {
        this.target = target;
    }

    public boolean counter()
    {
        if (count == target) {
            count = 0;
            return true;
        }
        else {
            count++;
            return false;
        }
    }
}
