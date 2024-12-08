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
    public int difficulty;
    public int damage;
    public int punchdelay = 5;
    private DelayCounter punchcounter = new DelayCounter(punchdelay);
    public int bulletdelay = 60;
    private DelayCounter shootcounter = new DelayCounter(bulletdelay);
    public Enemy() {
        velocity = 2;
        hp = 1000; // placeholder
    }
    public void act()
    {
        moveTowardsPlayer();
        fall(false);
        attack();
        dodgeBullet();
        shoot();
        System.out.println("Enemy HP: " + Integer.toString(hp));
    }
    public void moveTowardsPlayer() {
        Actor fighter = (Actor)getWorld().getObjects(Fighter.class).get(0);
        if (!recoil) {
            if (getX() > fighter.getX()) {
                setLocation(getX() - velocity, getY());
            }
            else if (getX() < fighter.getX()) {
                setLocation(getX() + velocity, getY());
            }
        }
        else {
            recoil_velocity -= recoil_acceleration;
            if (getX() > fighter.getX() || getX() == fighter.getX()) {
                setLocation((int)(getX() + recoil_velocity), getY());
            }
            else if (getX() < fighter.getX()) {
                setLocation((int)(getX() - recoil_velocity), getY());
            }
        }
    }
    public void attack() {
        if (!getObjectsInRange(70, Fighter.class).isEmpty()) {
            if (punchcounter.counter()) {
                System.out.println("check");
                Fighter fighter = getObjectsInRange(70, Fighter.class).get(0);
                fighter.hp -= damage;
                recoil = true;
                recoil_velocity = initial_recoil_velocity + recoil_acceleration;
                fighter.recoil = true;
                fighter.recoil_velocity = initial_recoil_velocity/2 + recoil_acceleration;
            }
        }
    }
    public void dodgeBullet() {
        if (!getObjectsInRange(60, Bullet.class).isEmpty()) {
            Bullet bullet = getObjectsInRange(60, Bullet.class).get(0);
            if (bullet.fighter) {
                int chance = difficulty - 10;
                if (Greenfoot.getRandomNumber(100) <= chance) {
                    bullet.dodged = true;
                    jump();
                }
            }
        }
    }
    public void shoot() {
        if (shootcounter.counter()) {
            Fighter fighter = (Fighter)getWorld().getObjects(Fighter.class).get(0);
            boolean left = fighter.getX() < getX();
            getWorld().addObject(new Bullet(left, false, damage), getX(), getY());
        }
    }
}
