import greenfoot.*;

/**
 * Write a description of class FighterHealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FighterHealthBar extends Actor
{
    public void act() {
       GreenfootImage bar = new GreenfootImage(1280/2, 76);
       Fighter fighter = getWorld().getObjects(Fighter.class).get(0);
       double percentleft = (fighter.hp * 1.0) / fighter.maxhp;
       bar.setColor(Color.BLUE);
       bar.fillRect(0, 0, (int)((1280/2)*percentleft), 76);
       setImage(bar);
    }
}
