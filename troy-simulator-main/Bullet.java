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
    private int animCounter = 0;
    private int ground = 520;
    private double gravity = 2.0;
    private double gravity_velocity = 0;
    GreenfootImage[] book = new GreenfootImage[15];
    GreenfootImage fire = new GreenfootImage("fire.png");
    
    public Bullet(boolean direction, boolean character, int damage) {
        left = direction;
        fighter = character;
        this.damage = damage;
        initAnimationSprites();
        
        /*
        GreenfootImage image = new GreenfootImage(50, 20);
        image.setColor(Color.RED);
        image.fillRect(0, 0, 50, 20);
        setImage(image)*/
    }
    
    public void act()
    {
        if (left) {
            setLocation(getX() - 14, getY()-25);
            if (getY() < ground) {
                gravity_velocity += gravity;
                setLocation(getX(), (int)(getY() + gravity_velocity));
            }
            if (getY() > ground) {
                setLocation(getX(), ground);
            }
        }
        else {
            setLocation(getX() + 14, getY()-25);
            if (getY() < ground) {
                gravity_velocity += gravity;
                setLocation(getX(), (int)(getY() + gravity_velocity));
            }
            if (getY() > ground) {
                setLocation(getX(), ground);
            }
        }
        if (fighter && !getObjectsInRange(50, Enemy.class).isEmpty() && !dodged) {
            Enemy enemy = getObjectsInRange(50, Enemy.class).get(0);
            enemy.hp -= damage / 2; // bullet should do half damage of punching
            setImage(fire);
            getWorld().removeObject(this);
        }
        else if (!fighter && !getObjectsInRange(50, Fighter.class).isEmpty() && !dodged) {
            Fighter fighter = getObjectsInRange(50, Fighter.class).get(0);
            fighter.hp -= damage / 2;
            setImage(fire);
            getWorld().removeObject(this);
        }
        else if (getX() == 0 || getX() == 1279) { // for some reason doesn't work when it's 1280
            getWorld().removeObject(this);
        }
        else if(getY() > ground){
            getWorld().removeObject(this);
        }
        animateBook(); 
    }
    public void animateBook(){
        setImage(book[animCounter++%15]);
    }
    public void initAnimationSprites(){
        for(int i = 1; i < 16; i++){
            String filename = "b" + i + ".png";
            book[i-1] = new GreenfootImage(filename);
        }
    }   
}
