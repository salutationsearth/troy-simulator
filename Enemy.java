import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Character
{
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Enemy() {
        velocity = 2;
        hp = 1000; // placeholder
    }
    public void act()
    {
        moveTowardsPlayer();
        fall();
    }
    public void fall() {
        if (getY() < ground) {
            gravity_velocity += gravity;
            setLocation(getX(), (int)(getY() + gravity_velocity));
        }
        if (getY() > ground) {
            setLocation(getX(), ground);
        }
    }
    public void moveTowardsPlayer() {
        Actor fighter = (Actor)getWorld().getObjects(Fighter.class).get(0);
        if (getX() > fighter.getX()) {
            setLocation(getX() - velocity, getY());
        }
        else if (getX() < fighter.getX()) {
            setLocation(getX() + velocity, getY());
        }
    }
    public void jump() {
        if (getY() == ground) {
            gravity_velocity = initial_jump_velocity;
            setLocation(getX(), (int)(getY() + gravity_velocity));
        }
    }
    public void jumpRandomly() {
        if (Greenfoot.getRandomNumber(jump_random) == 133) {
            jump();
        }
    }
}
