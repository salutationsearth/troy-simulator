import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SelectCharacter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SelectCharacter extends World
{
    Button jacob = new Button(913, 1135, 215, 488);
    Button eshan = new Button(695, 867, 218, 496);
    Button ryan = new Button(426, 622, 232, 485);
    Button tim = new Button(164, 360, 231, 492);
    StatsInfo jacobstats = new StatsInfo("JacobYuStats.png");
    StatsInfo eshanstats = new StatsInfo("EshanAnamStats.png");
    StatsInfo ryanstats = new StatsInfo("RyanParkStats.png");
    StatsInfo timstats = new StatsInfo("TimZhangStats.png");
    /**
     * Constructor for objects of class SelectCharacter.
     * 
     */
    public SelectCharacter()
    {    
       super(1280, 720, 1);
       setBackground("CharacterSelection.png");
    }
    public void act() {
        selectJacob();
        selectEshan();
        selectRyan();
        selectTim();
    }
    private void selectJacob() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null && jacob.hovered()) {
            addObject(jacobstats, 1280/2, 720/2);
            if (mouse.getButton() == 1) {
                Greenfoot.setWorld(new RodRoom(new JacobYu()));
            }
        }
        else if (mouse != null && !jacob.hovered()) {
            removeObject(jacobstats);
        }
    }
    private void selectEshan() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null && eshan.hovered()) {
            addObject(eshanstats, 1280/2, 720/2);
            if (mouse.getButton() == 1) {
                Greenfoot.setWorld(new RodRoom(new EshanAnam()));
            }
        }
        else if (mouse != null && !eshan.hovered()) {
            removeObject(eshanstats);
        }
    }
    private void selectRyan() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null && ryan.hovered()) {
            addObject(ryanstats, 1280/2, 720/2);
            if (mouse.getButton() == 1) {
                Greenfoot.setWorld(new RodRoom(new RyanPark()));
            }
        }
        else if (mouse != null && !ryan.hovered()) {
            removeObject(ryanstats);
        }
    }
    private void selectTim() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null && tim.hovered()) {
            addObject(timstats, 1280/2, 720/2);
            if (mouse.getButton() == 1) {
                Greenfoot.setWorld(new RodRoom(new TimZhang()));
            }
        }
        else if (mouse != null && !tim.hovered()) {
            removeObject(timstats);
        }
    }
}
