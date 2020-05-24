/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.menu;

import com.LOGamez.audio.Sound;
import com.LOGamez.input.MouseInput;
import com.LOGamez.graphics.*;
import com.LOGamez.mazegenerator.*;
import java.awt.*;

/**
 *
 * @author Ghomez
 */
public class AboutMenu extends Menu {
    
    /**Attributes*/
    
    /**AMfirstTick variable of AboutMenu*/ 
    private boolean AMfirstTick = true;
    
    /**AMTimer variable of AboutMenu*/ 
    private int AMTimer = 550;
    
    /**tickDelay variable of AboutMenu*/ 
    private int tickDelay = 60;
    
    /**menuImageX variable of AboutMenu*/
    private final int menuImageX = 0;
    
    /**menuImageY variable of AboutMenu*/
    private final int menuImageY = -20;
    
    /**menuImageW variable of AboutMenu*/
    private final int menuImageW = MazeGenerator.getMainWidth()+12;
    
    /**menuImageH variable of AboutMenu*/
    private final int menuImageH = MazeGenerator.getMainHeight();
    
    /**backBtnX variable of AboutMenu*/
    private final int backBtnX = 500;
    
    /**backBtnY variable of AboutMenu*/
    private final int backBtnY = 630;
    
    /**backBtnW variable of AboutMenu*/
    private final int backBtnW = 80;
    
    /**backBtnH variable of AboutMenu*/
    private final int backBtnH = 30;
    
    
    
    /**Constructor*/
    
    
    /**
    * AboutMenu(Game game)
    * 
    * Creates a new AboutMenu object
    * 
    * @param game
    */
    public AboutMenu(Game game) {
        System.out.println("AboutMenu: New About Menu Created");
        this.game = game;
        Menu.setUp();
        
        game.requestFocus();
    }

    
    /**Public Protocol*/
    
    /**
     * render(Graphics2D g)
     * 
     * Renders/Repaints AboutMenu Objects
     * 
     * @param target
     * @param g2d
     */
    @Override
    public void render(Render target, Graphics2D g2d) {
        
        //Draws Background Image: aboutMenuImage
        g2d.drawImage(aboutMenuImage, menuImageX, menuImageY, menuImageW, menuImageH, null);

        //Set Button Logic: Back Button
        if(MouseInput.MouseX > backBtnX && MouseInput.MouseX < backBtnX + backBtnW && MouseInput.MouseY > backBtnY && MouseInput.MouseY < backBtnY + backBtnH) {
            //Sets Background Image: aboutMenuImage1
            aboutMenuImage = aboutMenuImage1;
            
            //Draws Back Button Image: backOffBtn
            g2d.drawImage(backOffBtn, backBtnX, backBtnY, backBtnW, backBtnH, null);
            
            //Draws Back (Flashing) Button Arrow Images: leftArrowIcon, rightArrowIcon
            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g2d.drawImage(leftArrowIcon, backBtnX + 80, 634, arrowIconW, arrowIconH, null);
                g2d.drawImage(rightArrowIcon, backBtnX - 25, 635, arrowIconW, arrowIconH, null);
            }
            
            //Set Mouse Button Logic: MouseButton 1 || RMB
            if(MouseInput.MouseButton == 1) {
                Sound.stopAll();
                Sound.btnPushed.play();
                
                game.setMenu(null);
                game.stateManager.setState("menu");
                
                //Set Status Bar: Ready
                MazeGenerator.setStatusBar("Ready");
            }
            
            //Set Status Bar: Back
            MazeGenerator.setStatusBar("Back");
        } else {
            //Sets Background Image: aboutMenuImage0
            aboutMenuImage = aboutMenuImage0;
            
            //Draws Back Button Image: backOnBtn
            g2d.drawImage(backOnBtn, backBtnX, backBtnY, backBtnW, backBtnH, null);
            
            //Set Status Bar: About Menu
            MazeGenerator.setStatusBar("About Menu");
        }
        
    }

    /**
    * tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire)
    * 
    * Updates AboutMenu Object
    * 
    * @param game - the Game of AboutMenu
    * @param up - the up variable of AboutMenu
    * @param down - the down variable of AboutMenu
    * @param left - the left variable of AboutMenu
    * @param right - the right variable of AboutMenu
    * @param fire - the fire variable of AboutMenu
    */
    @Override
    public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire) {
        if(AMTimer > 0) {
           AMTimer--;
        }
        if(AMfirstTick) {
            AMfirstTick = false;
            System.out.println("Cue About Screen . . .");
            System.out.println("Cue Dodgy soundtrack . . .");
            if(Game.getGameSound()){
                Sound.Menu4.loop();
            }
            MazeGenerator.setStatusBar("About Menu");
        }
        if(AMTimer == 0) {
        }
    }
    
}
