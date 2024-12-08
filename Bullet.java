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
    public int velocity = 20;
    public int damage;
    public boolean dodged;
    public Bullet(boolean direction, boolean character, int damage) {
        left = direction;
        fighter = character;
        this.damage = damage;
        GreenfootImage image = new GreenfootImage(50, 20);
        image.setColor(Color.RED);
        image.fillRect(0, 0, 50, 20);
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
        if (fighter && !getObjectsInRange(50, Enemy.class).isEmpty() && !dodged) {
            Enemy enemy = getObjectsInRange(50, Enemy.class).get(0);
            enemy.hp -= damage / 2; // bullet should do half damage of punching
            getWorld().removeObject(this);
        }
        else if (!fighter && !getObjectsInRange(50, Fighter.class).isEmpty() && !dodged) {
            Fighter fighter = getObjectsInRange(50, Fighter.class).get(0);
            fighter.hp -= damage / 2;
            getWorld().removeObject(this);
        }
        else if (getX() == 0 || getX() == 1279) { // for some reason doesn't work when it's 1280
            getWorld().removeObject(this);
        }
    }
}
