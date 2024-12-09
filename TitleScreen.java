import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{

    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    private int animCounter = 1;
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1280, 720, 1);
        setBackground("SS1.png");
    }
    public void act() {
        animate();
        startGame();
    }
    private void animate() {
        if (animCounter > 4) {
            animCounter = 1;
        }
        setBackground("SS" + animCounter + ".png");
        animCounter++;
    }
    private void startGame() {
        if (Greenfoot.getKey() != null) {
            Greenfoot.setWorld(new SelectCharacter());
        }
    }
}
