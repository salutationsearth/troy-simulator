import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class EnemyHealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EnemyHealthBar extends Actor
{
    public void act() {
       GreenfootImage bar = new GreenfootImage(1280/2, 76);
       Enemy enemy = getWorld().getObjects(Enemy.class).get(0);
       double percentleft = (enemy.hp * 1.0) / enemy.maxhp;
       bar.setColor(Color.RED);
       bar.fillRect(0, 0, (int)((1280/2)*percentleft), 76);
       bar.mirrorHorizontally();
       setImage(bar);
    }
}
