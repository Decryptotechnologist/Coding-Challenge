/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.menu;

import com.LOGamez.graphics.*;
import com.LOGamez.audio.*;
import com.LOGamez.input.MouseInput;
//import com.LOGamez.level.Level;
import com.LOGamez.mazegenerator.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;


/**
 * PauseMenu objects represent one Enemy4 object 
 * (above the first top-most row of enemies), 
 * there are 1 of them at any one time randomly 
 * through-out the game each with their own 
 * collision Rectangle
 * 
 * @author(s) Ghomez
 */
public class PauseMenu extends Menu {

    /**Attributes*/
    
    /**PMfirstTick variable of PauseMenu*/ 
    private boolean PMfirstTick = true;
    
    /**PMTimer variable of PauseMenu*/ 
    private int PMTimer = 550;
    
    /**pauseMenuImage BufferedImage of PauseMenu*/
    private BufferedImage pauseMenuImage = new Texture("/menu/menuState_2").getImage();
    
    /**pauseMenuImage1 BufferedImage of PauseMenu*/
    private final BufferedImage pauseMenuImage1 = new Texture("/menu/menuState_4").getImage();
    
    /**pauseMenuImage2 BufferedImage of PauseMenu*/
    private final BufferedImage pauseMenuImage2 = new Texture("/menu/menuState_3").getImage();
    
    /**menuImageX variable of PauseMenu*/
    private final int menuImageX = 0;
    
    /**menuImageY variable of PauseMenu*/
    private final int menuImageY = -20;
    
    /**menuImageW variable of PauseMenu*/
    private final int menuImageW = MazeGenerator.getMainWidth()+12;
    
    /**menuImageH variable of PauseMenu*/
    private final int menuImageH = MazeGenerator.getMainHeight();
    
    
    
    /**resumeBtnX variable of PauseMenu*/
    private final int resumeBtnX = 106;
    
    /**resumeBtnY variable of PauseMenu*/
    private final int resumeBtnY = 368;
    
    /**resumeBtnW variable of PauseMenu*/
    private final int resumeBtnW = 160;
    
    /**resumeBtnH variable of PauseMenu*/
    private final int resumeBtnH = 60;
    
    
    /**restartBtnX variable of PauseMenu*/
    private final int restartBtnX = 106;
    
    /**restartBtnY variable of PauseMenu*/
    private final int restartBtnY = 432;
    
    /**restartBtnW variable of PauseMenu*/
    private final int restartBtnW = 180;
    
    /**restartBtnH variable of PauseMenu*/
    private final int restartBtnH = 60;
    
    
    /**quitBtnX variable of PauseMenu*/
    private final int quitBtnX = 106;
    
    /**quitBtnY variable of PauseMenu*/
    private final int quitBtnY = 492;
    
    /**quitBtnW variable of PauseMenu*/
    private final int quitBtnW = 160;
    
    /**quitBtnH variable of PauseMenu*/
    private final int quitBtnH = 60;
    
    
    /**pauseTxt variable of PauseMenu*/
    private final String pauseTxt = "PAUSED . . .";
    
    /**pauseTxtFont variable of PauseMenu*/
    private final Font pauseTxtFont = new Font("Cambria", Font.BOLD, 46);
    
    /**pauseTxtCol1 variable of PauseMenu*/
    private final Color pauseTxtCol1 = Color.decode("#013f0c");//0x013f0c
    
    /**pauseTxtCol2 variable of PauseMenu*/
    private final Color pauseTxtCol2 = Color.decode("#0afa00");//0x0afa00
    
    /**pauseTxtX variable of PauseMenu*/
    private final int pauseTxtX = 134;
    
    /**pauseTxtY variable of PauseMenu*/
    private final int pauseTxtY = 310;
    
    
    

    /**Public protocol*/ 
    
    
    /**
    * render(Graphics2D g)
    * 
    * Renders/Repaints PauseMenu Objects
    * 
    * @param target
    * @param g2d - the g of PauseMenu
    */
    @Override
    public void render(Render target, Graphics2D g2d) {
        Graphics2D g2d_PauseMenu = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        MouseInput.MouseButton = 0;
        
        //Draw Background
        g2d_PauseMenu.drawImage(pauseMenuImage, menuImageX, menuImageY, menuImageW, menuImageH, null);
        ////////////////////////////////////////////////////////////////////////////
        
        //Render Paused text
        if (System.currentTimeMillis() / 450 % 2 == 0) {
            pauseMenuImage = pauseMenuImage2;
            
            //Draw 3D Paused text: Green, Blue Shadow
            g2d_PauseMenu.setFont(pauseTxtFont);
            g2d_PauseMenu.setColor(pauseTxtCol1);
            g2d_PauseMenu.drawString(pauseTxt, pauseTxtX+2, pauseTxtY+2);
            g2d_PauseMenu.setColor(pauseTxtCol2);
            g2d_PauseMenu.drawString(pauseTxt, pauseTxtX, pauseTxtY);
            ////////////////////////////////////////////////////////////////////////////
            
            //Set StatusBar: "Paused . . ."
            MazeGenerator.setStatusBar("Paused . . .");
        } else {
            pauseMenuImage = pauseMenuImage1;
            
            //Draw 3D Paused text: Blue, Green Shadow
            g2d_PauseMenu.setFont(pauseTxtFont);
            g2d_PauseMenu.setColor(pauseTxtCol2);
            g2d_PauseMenu.drawString(pauseTxt, pauseTxtX+2, pauseTxtY+2);
            g2d_PauseMenu.setColor(pauseTxtCol1);
            g2d_PauseMenu.drawString(pauseTxt, pauseTxtX, pauseTxtY);
            ////////////////////////////////////////////////////////////////////////////
            
            //Set StatusBar: " "
            MazeGenerator.setStatusBar(" ");
        }
        ////////////////////////////////////////////////////////////////////////////
        
        
        //Draw Resume Button
        if (MouseInput.MouseX > resumeBtnX && MouseInput.MouseX < resumeBtnX + resumeBtnW && MouseInput.MouseY > resumeBtnY && MouseInput.MouseY < resumeBtnY + resumeBtnH) {
            g2d_PauseMenu.drawImage(resumeOffBtn, resumeBtnX, resumeBtnY, resumeBtnW, resumeBtnH, null);

            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g2d_PauseMenu.drawImage(leftArrowIcon, resumeBtnX + 164, 384, arrowIconW, arrowIconH, null);
                g2d_PauseMenu.drawImage(rightArrowIcon, resumeBtnX - 25, 384, arrowIconW, arrowIconH, null);
            }

            if (MouseInput.MouseButton == 1) {
                Sound.stopAll();
                Sound.btnPushed.play();
                System.out.println("PauseMenu: Resume Selected");
                Game.getGame().setMenu(null);
                Game.paused = false;

                Sound.reloopLevel(Game.levelNo);
                //config.loadConfiguration("res/sys/config.xml");
            }
        } else {
            g2d_PauseMenu.drawImage(resumeOnBtn, resumeBtnX, resumeBtnY, resumeBtnW, resumeBtnH, null);
        }
        ////////////////////////////////////////////////////////////////////////////
        

        //Draw Restart Button
        if (MouseInput.MouseX > restartBtnX && MouseInput.MouseX < restartBtnX + restartBtnW && MouseInput.MouseY > restartBtnY && MouseInput.MouseY < restartBtnY + restartBtnH) {
            g2d_PauseMenu.drawImage(restartOffBtn, restartBtnX, restartBtnY, restartBtnW, restartBtnH, null);

            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g2d_PauseMenu.drawImage(leftArrowIcon, restartBtnX + 184, 452, arrowIconW, arrowIconH, null);
                g2d_PauseMenu.drawImage(rightArrowIcon, restartBtnX - 24, 452, arrowIconW, arrowIconH, null);
            }

            if (MouseInput.MouseButton == 1) {
                Sound.stopAll();
                Sound.btnPushed.play();
                Game.paused = false;

                System.out.println("PauseMenu: Restart Selected");
                Game.getGame().setMenu(null);
                Game.getGame().stateManager.setState("menu");

                //Game.level = new Level(Game.startLevel, MazeGenerator.getMainWidth(), MazeGenerator.getMainHeight());
            }
        } else {
            g2d_PauseMenu.drawImage(restartOnBtn, restartBtnX, restartBtnY, restartBtnW, restartBtnH, null);
        }
        ////////////////////////////////////////////////////////////////////////////
        

        //Draw Quit Button
        if (MouseInput.MouseX > quitBtnX && MouseInput.MouseX < quitBtnX + quitBtnW && MouseInput.MouseY > quitBtnY && MouseInput.MouseY < quitBtnY + quitBtnH) {
            g2d_PauseMenu.drawImage(quitOffBtn, quitBtnX, quitBtnY, quitBtnW, quitBtnH, null);

            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g2d_PauseMenu.drawImage(leftArrowIcon, quitBtnX + 164, 508, arrowIconW, arrowIconH, null);
                g2d_PauseMenu.drawImage(rightArrowIcon, quitBtnX - 28, 508, arrowIconW, arrowIconH, null);
            }

            if (MouseInput.MouseButton == 1) {
                System.out.println("PauseMenu: Quit Selected");
                Game.getGame().setMenu(null);

                Game.getGame().quitGame();
            }
        } else {
            g2d_PauseMenu.drawImage(quitOnBtn, quitBtnX, quitBtnY, quitBtnW, quitBtnH, null);
        }
        ////////////////////////////////////////////////////////////////////////////  
        
        g2d.setTransform(oldXForm);
        g2d_PauseMenu.setTransform(oldXForm);
    }

    
    /**
    * tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire)
    * 
    * Updates PauseMenu Object
    * 
    * @param game - the Game of PauseMenu
    * @param up - the up variable of PauseMenu
    * @param down - the down variable of PauseMenu
    * @param left - the left variable of PauseMenu
    * @param right - the right variable of PauseMenu
    * @param fire - the fire variable of PauseMenu
    */
    @Override
    public void tick(Game game, boolean up, boolean down, boolean left, boolean right, boolean fire) {
        //Manage Pause Menu: Timer
        if (PMTimer > 0) {
            PMTimer--;
        }
        /////////////////////////////////////////////////////////////
        
        //Manage Pause Menu: First Tick
        if (PMfirstTick) {
            PMfirstTick = false;
            System.out.println("PauseMenu: Cue Pause Screen . . .");
            System.out.println("PauseMenu: Cue Pause Wav . . .");
            Sound.stopAll();
            if(Game.getGameSound()){
                Sound.Paused.loop();
            }
            MazeGenerator.setStatusBar("Paused . . .");
        }
        /////////////////////////////////////////////////////////////
        
        //Manage Pause Menu: Last Tick
        if (PMTimer == 0) {
            MazeGenerator.setStatusBar(" ");
        }    
        /////////////////////////////////////////////////////////////
    }
    
}

