import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Character here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Character extends Actor
{
    /**
     * Act - do whatever the Character wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String left_file = "";
    public String right_file = "";
    public String jump_file = "";
    public int velocity;
    public double gravity = 2.0;
    public double gravity_velocity = 0;
    public double initial_jump_velocity = -30.0;
    public int ground = 520;
    public int jump_random = 50;
    public int[] enemy_stats_location = {100, 100};
    public int hp;
    public double recoil_acceleration = 3.0;
    public double initial_recoil_velocity = 30.0;
    public double recoil_velocity = 0.0;
    public boolean recoil = false;
    public int delaycounter;
    public int fps = 60;
    public void act()
    {
        
    }
    public void fall(boolean isFighter) {
        // vertical acceleration
        if (getY() < ground) {
            gravity_velocity += gravity;
            setLocation(getX(), (int)(getY() + gravity_velocity));
        }
        if (getY() > ground) {
            setLocation(getX(), ground);
        }
        // recoil acceleration
        if (recoil_velocity < 0) {
            recoil_velocity = 0;
            recoil = false;
        }
        if (recoil && isFighter) {
            Enemy enemy = getWorld().getObjects(Enemy.class).get(0);
            recoil_velocity -= recoil_acceleration;
            if (enemy.getX() > getX()) {
                setLocation((int)(getX() - recoil_velocity), getY());
            }
            else {
                setLocation((int)(getX() + recoil_velocity), getY());
            }
        }
    }
    public void jump() {
        if (getY() == ground) {
            gravity_velocity = initial_jump_velocity;
            setLocation(getX(), (int)(getY() + gravity_velocity));
        }
    }
    public void debugHP() {
        System.out.println(hp);
    }
    public boolean counter(int frames) {
        if (delaycounter == frames) {
            delaycounter = 0;
            return true;
        }
        else {
            delaycounter++;
            return false;
        }
    }
}
