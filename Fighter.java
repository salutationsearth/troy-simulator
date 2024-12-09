import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Fighter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fighter extends Character
{
    /**
     * Act - do whatever the Fighter wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public String fileprefix;
    GreenfootImage[] walkRight = new GreenfootImage[10];
    GreenfootImage[] walkLeft = new GreenfootImage[10];
    GreenfootImage rightidle;
    GreenfootImage leftidle;
    GreenfootImage jumpright;
    GreenfootImage jumpleft;
    public int animCounter = 1;
    public int shootCooldown = 2;
    private DelayCounter shootcounter = new DelayCounter(shootCooldown);
    private Countdown punchcountdown = new Countdown(6, "punch");
    public Fighter() {
        velocity = 15;
    }
    public void act()
    {
        checkKeys();
        fall(true);
        initAnimationSprites();
        animateCountdowns();
        System.out.println("Fighter HP: " + Integer.toString(hp));
    }
    
    public void moveRight() {
        if (!recoil) {
            setLocation(getX() + velocity, getY());
        }
    }
    public void moveLeft() {
        if (!recoil) {
            setLocation(getX() - velocity, getY());
        }
    }
    public void punch() {
        getWorld().addObject(punchcountdown, 0, 0);
        if (!getObjectsInRange(70, Enemy.class).isEmpty()) {
            Enemy enemy = getObjectsInRange(70, Enemy.class).get(0);
            enemy.hp -= damage;
            recoil = true;
            recoil_velocity = initial_recoil_velocity + recoil_acceleration;
            enemy.recoil = true;
            enemy.recoil_velocity = initial_recoil_velocity/2 + recoil_acceleration;
        }
    }
    public void shoot() {
        if (shootcounter.counter()) {
            Enemy enemy = (Enemy)getWorld().getObjects(Enemy.class).get(0);
            boolean left = enemy.getX() < getX();
            getWorld().addObject(new Bullet(left, true, damage), getX(), getY());
        }
    }
    
    private void checkKeys() {
        if (Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a")) {
            //setImage(left_file);
            animateRunLeft(); 
            moveLeft();
            //
        }
        if (Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")) {
            //setImage(right_file);
            animateRunRight(); 
            moveRight();
            
        }
        if (Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("w")) {
            // setImage(jump_file);
            jump();
        }
        if (Greenfoot.mouseClicked(null)) {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse.getButton() == 1) {
                punch();
            }
            else if (mouse.getButton() == 3) {
                shoot();
            }
        }
        if(!(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))&&!(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")&&!(Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("w"))&&!(Greenfoot.mouseClicked(null)))){
            idle();
        }
    }
    
    public void initAnimationSprites(){
        for(int i = 1; i < 10; i++){
            String filename = fileprefix + i + ".png";
            walkRight[i] = new GreenfootImage(filename);
        }
        for(int i = 1; i < 10; i++){
            String fileName = fileprefix + i + ".png";
            walkLeft[i] = new GreenfootImage(fileName);
            walkLeft[i].mirrorHorizontally();
        }
    }    
    public void animateRunRight(){
        setImage(walkRight[animCounter++%10]);
    }
    public void animateRunLeft(){
        setImage(walkLeft[animCounter++%10]);
    }
    public void idle(){
        Enemy enemy = getWorld().getObjects(Enemy.class).get(0);
        if (enemy.getX() > getX()) {
            if (getY() < ground) {
                setImage(jumpright);
            }
            else {
                setImage(rightidle);
            }
        }
        else {
            if (getY() < ground) {
                setImage(jumpleft);
            }
            else {
                setImage(leftidle);
            }
        }
    }
    public void animateCountdowns() {
        List<Countdown> countdowns = getWorld().getObjects(Countdown.class);
        Enemy enemy = getWorld().getObjects(Enemy.class).get(0);
        if (!countdowns.isEmpty()) {
            for (Countdown c: countdowns) {
                GreenfootImage image = new GreenfootImage(fileprefix + c.type + ".png");
                if (enemy.getX() < getX()) {
                    image.mirrorHorizontally();
                }
                setImage(image);
            }
        }
        else if (attacked) {
            GreenfootImage image = new GreenfootImage(fileprefix + "kb.png");
            if (enemy.getX() < getX()) {
                image.mirrorHorizontally();
            }
            setImage(image);
        }
    }
}
