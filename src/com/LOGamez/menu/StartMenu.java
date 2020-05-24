package com.LOGamez.menu;

import com.LOGamez.audio.Sound;
import com.LOGamez.mazegenerator.*;
import com.LOGamez.graphics.Render;
import java.util.Random;
import java.awt.*;
import java.awt.geom.AffineTransform;

/**
 * StartMenu objects represent one Enemy4 object 
 * (above the first top-most row of enemies), 
 * there are 1 of them at any one time randomly 
 * through-out the game each with their own 
 * collision Rectangle
 * 
 * @author(s) Ghomez
 */
public class StartMenu extends Menu {
    
    /**Attributes*/
    
    /**SMfirstTick boolean of StartMenu*/
    private boolean SMfirstTick = true;
    
    /**SMTimer variable of StartMenu*/
    private int SMTimer = 400;
    
    /**random variable of StartMenu*/
    Random random = new Random();
    
    
    /**menuImageX variable of StartMenu*/
    private final int menuImageX = 0;
    
    /**menuImageY variable of StartMenu*/
    private final int menuImageY = -20;
    
    /**menuImageW variable of StartMenu*/
    private final int menuImageW = MazeGenerator.getMainWidth()+12;
    
    /**menuImageH variable of StartMenu*/
    private final int menuImageH = MazeGenerator.getMainHeight();
    
    
    /**startTxt variable of StartMenu*/
    private final String startTxt = "STARTING . . .";
    
    /**startTxtFont variable of StartMenu*/
    private final Font startTxtFont = new Font("Cambria", Font.BOLD, 46);
    
    /**startTxtCol2 variable of StartMenu*/
    private final Color startTxtCol2 = Color.decode("#3FFF00");
    
    /**blackToOrange1 variable of StartMenu*/
    GradientPaint blackToOrange1 = new GradientPaint(150, 50, startTxtCol2, 100, 300, Color.BLACK);
    
    /**startTxtX variable of StartMenu*/
    private final int startTxtX = 124;
    
    /**startTxtY variable of StartMenu*/
    private final int startTxtY = 230;
    
    
    
    /**Constructor*/
    
    /**
    * StartMenu(Game game)
    * 
    * Initialises a new StartMenu
    * 
    * @param game - the game of StartMenu
    */ 
    public StartMenu(Game game) {
        System.out.println("StartMenu: New Start Menu Created");
        this.game = game;
        Menu.setUp();
    }
    
    
    /**Public protocol*/

    
    /**
    * render(Render target, Graphics2D g)
    * 
    * Renders/Repaints StartMenu
    * 
    * @param target
    * @param g2d
    */     
    @Override
    public void render(Render target, Graphics2D g2d) {
        Graphics2D g2d_StartMenu = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        //Draw Background
        g2d_StartMenu.drawImage(startMenuImage, menuImageX, menuImageY, menuImageW, menuImageH, null);
        /////////////////////////////////////////////////////////////
        
        if (SMTimer > 15) {
            //Render Starting Background and text
            if (System.currentTimeMillis() / 450 % 2 == 0) {
                startMenuImage = startMenuImage1;                

                //Draw 3D Paused text: Green, Blue Shadow
                g2d_StartMenu.setFont(startTxtFont);
                g2d_StartMenu.setPaint(blackToOrange1);
                g2d_StartMenu.drawString(startTxt, startTxtX+2, startTxtY+2);
                g2d_StartMenu.setColor(startTxtCol2);
                g2d_StartMenu.drawString(startTxt, startTxtX, startTxtY);
                /////////////////////////////////////////////////////////////
                
                //Set StatusBar: "Starting . . ."
                MazeGenerator.setStatusBar("Starting . . .");
                /////////////////////////////////////////////////////////////
            } else {
                startMenuImage = startMenuImage0;
                
                //Set StatusBar: " "
                MazeGenerator.setStatusBar(" ");
                /////////////////////////////////////////////////////////////
            }
        }
        
        g2d.setTransform(oldXForm);
        g2d_StartMenu.setTransform(oldXForm);
    }

    
    /**
    * tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire)
    * 
    * Updates StartMenu
    * 
    * @param game - the Game of StartMenu
    * @param up - the up variable of StartMenu
    * @param down - the down variable of StartMenu
    * @param left - the left variable of StartMenu
    * @param right - the right variable of StartMenu
    * @param fire - the fire variable of StartMenu
    */     
    @Override
    public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire) {
        //Manage Start Menu: Timer
        if(SMTimer > 0) {
            SMTimer--;
        }
        /////////////////////////////////////////////////////////////
        
        //Manage Start Menu: First Tick
        if(SMfirstTick) {
            SMfirstTick = false;
            System.out.println("StartMenu: Cue Start Screen . . .");
            System.out.println("StartMenu: Cue Dodgy soundtrack . . .");
            
            //Set StatusBar: "Cue Start Screen . . ."
            MazeGenerator.setStatusBar("Cue Start Screen . . .");
            
            Sound.stopAll();
            if(Game.getGameSound()){
                Sound.Menu3.play();
            }
        }
        /////////////////////////////////////////////////////////////
        
        //Manage Start Menu: Last Tick
        if (SMTimer == 0) {
            Sound.stopAll();
            System.out.println("StartMenu: End Dodgy soundtrack . . .");
            
            //Set Game Menu: null
            game.setMenu(null);
            System.out.println("StartMenu: Game On!!!");
            
            //Set StatusBar: "Game On!!!"
            MazeGenerator.setStatusBar("Game On!!!");
            
            //Reset Game Time
            Game.resetGameTime();
        }
        /////////////////////////////////////////////////////////////
    }
    
}
