import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    
    public double recoil_acceleration = 3.0;
    public double initial_recoil_velocity = 30.0;
    public double recoil_velocity = 0.0;
    public boolean recoil = false;
    GreenfootImage[] walkRight = new GreenfootImage[10];
    GreenfootImage[] walkLeft = new GreenfootImage[10]; 
    int animCounter = 1; 
    public Fighter() {
        velocity = 15;
    }
    public void act()
    {
        checkKeys();
        fall();
        initAnimationSprites();
        
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
    public void jump() {
        if (getY() == ground) {
            gravity_velocity = initial_jump_velocity;
            setLocation(getX(), (int)(getY() + gravity_velocity));
        }
    }
    public void fall() {
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
        if (recoil) {
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
    public void punch() {
        if (!getObjectsInRange(70, Enemy.class).isEmpty()) {
            Enemy enemy = getObjectsInRange(70, Enemy.class).get(0);
            enemy.hp -= 5;
            recoil = true;
            recoil_velocity = initial_recoil_velocity;
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
            setImage(jump_file);
            jump();
        }
        if (Greenfoot.mouseClicked(null)) {
            // setImage(punch_file);
            punch();
        }
        if(!(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))&&!(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d")&&!(Greenfoot.isKeyDown("space") || Greenfoot.isKeyDown("w"))&&!(Greenfoot.mouseClicked(null)))){
            setImage("idle.png");
        }
    }
    
    public void initAnimationSprites(){
        for(int i = 1; i < 10; i++){
            String filename = "f" + i + ".png";
            walkRight[i] = new GreenfootImage(filename);
        }
        for(int i = 1; i < 10; i++){
            String fileName = "f" + i + ".png";
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
        setImage("idle.png");
    }
}
