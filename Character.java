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
    public int jump_random = 1000;
    public int[] enemy_stats_location = {100, 100};
    public int hp;
    public void act()
    {
        // Add your action code here.
    }
}
