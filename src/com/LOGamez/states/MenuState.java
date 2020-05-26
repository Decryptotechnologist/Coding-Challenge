/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.states;

import com.LOGamez.audio.Sound;
import com.LOGamez.graphics.Texture; 
import com.LOGamez.mazegenerator.*;
import com.LOGamez.util.Fonts;
import com.LOGamez.input.MouseInput;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Ghomez
 * 
 */
public class MenuState implements State {
    
    /**Attributes*/
    
    /**menuImage BufferedImage of MenuState*/
    private BufferedImage menuImage;
    
    /**menuImage BufferedImage of MenuState*/
    private BufferedImage menuImage0;
    
    /**menuImage BufferedImage of MenuState*/
    private BufferedImage menuImage1;
    
    /**menuImage BufferedImage of MenuState*/
    private BufferedImage menuImage2;
    
    /**menuImage BufferedImage of MenuState*/
    private BufferedImage menuImage3;
    
    /**menuImageX BufferedImage of MenuState*/
    private int menuImageX = 0;
    
    /**menuImageY BufferedImage of MenuState*/
    private int menuImageY = -20;
    
    /**menuImageW BufferedImage of MenuState*/
    private int menuImageW = MazeGenerator.getMainWidth()+12;
    
    /**menuImageH BufferedImage of MenuState*/
    private int menuImageH = MazeGenerator.getMainHeight();
    
    
    
    /**playOffBtn BufferedImage of MenuState*/
    private final BufferedImage playOffBtn;
    
    /**playOnBtn BufferedImage of MenuState*/
    private final BufferedImage playOnBtn;
    
    /**playBtnX BufferedImage of MenuState*/
    private int playBtnX = 226;
    
    /**playBtnY BufferedImage of MenuState*/
    private int playBtnY = 248;
    
    /**playBtnW BufferedImage of MenuState*/
    private int playBtnW = 160;
    
    /**playBtnH BufferedImage of MenuState*/
    private int playBtnH = 60;
    
    
    
    /**optionsOffBtn BufferedImage of MenuState*/
    private final BufferedImage optionsOffBtn;
    
    /**optionsOnBtn BufferedImage of MenuState*/
    private final BufferedImage optionsOnBtn;
    
    /**optionsBtnX BufferedImage of MenuState*/
    private int optionsBtnX = 176;
    
    /**optionsBtnY BufferedImage of MenuState*/
    private int optionsBtnY = 312;
    
    /**optionsBtnW BufferedImage of MenuState*/
    private int optionsBtnW = 260;
    
    /**optionsBtnH BufferedImage of MenuState*/
    private int optionsBtnH = 60;
    
    
    /**helpOffBtn BufferedImage of MenuState*/
    private final BufferedImage helpOffBtn;
    
    /**helpOnBtn BufferedImage of MenuState*/
    private final BufferedImage helpOnBtn;
    
    /**helpBtnX BufferedImage of MenuState*/
    private int helpBtnX = 226;
    
    /**helpBtnY BufferedImage of MenuState*/
    private int helpBtnY = 372;
    
    /**helpBtnW BufferedImage of MenuState*/
    private int helpBtnW = 160;
    
    /**helpBtnH BufferedImage of MenuState*/
    private int helpBtnH = 60;
    
    
    
    /**quitOffBtn BufferedImage of MenuState*/
    private final BufferedImage quitOffBtn;
    
    /**quitOnBtn BufferedImage of MenuState*/
    private final BufferedImage quitOnBtn;
    
    /**quitBtnX BufferedImage of MenuState*/
    private int quitBtnX = 226;
    
    /**quitBtnY BufferedImage of MenuState*/
    private int quitBtnY = 432;
    
    /**quitBtnW BufferedImage of MenuState*/
    private int quitBtnW = 160;
    
    /**quitBtnH BufferedImage of MenuState*/
    private int quitBtnH = 60;
    
    
    
    /**aboutOffBtn BufferedImage of MenuState*/
    private final BufferedImage aboutOffBtn;
    
    /**aboutOnBtn BufferedImage of MenuState*/
    private final BufferedImage aboutOnBtn;
    
    /**aboutBtnX BufferedImage of MenuState*/
    private int aboutBtnX = MazeGenerator.getMainWidth() - 90;
    
    /**aboutBtnY BufferedImage of MenuState*/
    private int aboutBtnY = MazeGenerator.getMainHeight() - 80;
    
    /**aboutBtnW BufferedImage of MenuState*/
    private int aboutBtnW = 80;
    
    /**aboutBtnH BufferedImage of MenuState*/
    private int aboutBtnH = 30;
    
    
    
    /**leftArrowIcon BufferedImage of MenuState*/
    private final BufferedImage leftArrowIcon;
    
    /**rightArrowIcon BufferedImage of MenuState*/
    private final BufferedImage rightArrowIcon;
    
    /**arrowIconX variable of MenuState*/ 
    private int arrowIconW = 22;
    
    /**arrowIconY variable of MenuState*/ 
    private int arrowIconH = 20;
    
    
    /**hlpCol variable of MenuState*/
    public Color hlpCol = Color.orange;
    
    /**hlpFont variable of MenuState*/
    public Font hlpFont = new Font("Times New Roman", Font.PLAIN, 16);
    
    /**hlpMsgX variable of MenuState*/
    public int hlpMsgX = 76;
    
    /**hlpMsgX variable of MenuState*/
    public int hlpMsgY = MazeGenerator.getMainHeight() - 122;
    
    
    /**versionCol variable of MenuState*/
    public Color versionCol = Color.DARK_GRAY;
    
    /**versionFont variable of MenuState*/
    public Font versionFont = new Font("Times New Roman", Font.PLAIN, 12);
    
    /**versionBtnX BufferedImage of MenuState*/
    private int versionBtnX = MazeGenerator.getMainWidth() - 30;
    
    /**versionBtnY BufferedImage of MenuState*/
    private int versionBtnY = MazeGenerator.getMainHeight() - 40;
    
    
    /**menuImage BufferedImage of MenuState*/
    private BufferedImage offscreen;
    
    /**waveText BufferedImage of MenuState*/
    private JPanel waveText;
    
    /**textMessage variable of MenuState*/
    private String textMessage;// = "THIS IS WAVE TEXT EFFECT DEMO!!!";
    
    /**textFont variable of MenuState*/
    private Font textFont = new Font("impact", Font.PLAIN, 150);
    
    /**textPositionX variable of MenuState*/
    private double textPositionX;
    
    /**textPositionY variable of MenuState*/
    private double textPositionY;
    
    
    
    /**Constructor*/
    
    
    /**
    * MenuState(StateManager statemanager)
    * 
    * Creates a new MenuState
    * 
    */
    public MenuState() {
        System.out.println("MenuState: New Menu State Created");
        
        //Setup MenuState: Button Images
        playOffBtn = new Texture("/menu/play_off1").getImage();
        playOnBtn = new Texture("/menu/play_on1").getImage();
        optionsOffBtn = new Texture("/menu/options_off1").getImage();
        optionsOnBtn = new Texture("/menu/options_on1").getImage();
        helpOffBtn = new Texture("/menu/help_off1").getImage();
        helpOnBtn = new Texture("/menu/help_on1").getImage();
        quitOffBtn = new Texture("/menu/quit_off1").getImage();
        quitOnBtn = new Texture("/menu/quit_on1").getImage();
        aboutOffBtn = new Texture("/menu/about_off1").getImage();
        aboutOnBtn = new Texture("/menu/about_on1").getImage();
        ////////////////////////////////////////////////////////////////////////////

        //Setup MenuState: Arrow Images
        leftArrowIcon = new Texture("/Sprites/Breakout-Sprite-Ball-GRAY_32").getImage();
        rightArrowIcon = new Texture("/Sprites/Breakout-Sprite-Ball-GRAY_32").getImage();
        ////////////////////////////////////////////////////////////////////////////
        
        //Setup MenuState: Background Images
        try {
            menuImage = ImageIO.read(MenuState.class.getResource("/menu/menuState_3.png"));
            menuImage0 = ImageIO.read(MenuState.class.getResource("/menu/menuState_3.png"));
            menuImage2 = ImageIO.read(MenuState.class.getResource("/menu/menuState_2.png"));
            menuImage1 = ImageIO.read(MenuState.class.getResource("/menu/menuState_1.png"));
            menuImage3 = ImageIO.read(MenuState.class.getResource("/menu/menuState_4.png"));
        } catch (IOException ex) {
            Logger.getLogger(MenuState.class.getName()).log(Level.SEVERE, null, ex);
        }
        ////////////////////////////////////////////////////////////////////////////
        
        //Setup MenuState: Wave Text Effect
        waveText = new JPanel();
        waveText.setSize(MazeGenerator.getMainWidth()+12, MazeGenerator.getMainHeight());
        
        offscreen = new BufferedImage(MazeGenerator.getMainWidth()+12, MazeGenerator.getMainHeight(), BufferedImage.TYPE_INT_RGB);
        
        textMessage = Game.TITLE+"   "+Game.version;
        textPositionX = MazeGenerator.getMainWidth()+12;
        textPositionY = 240;
    }
    
    
    
    /**Public Protocol*/
    
    
    /**
    * tick(StateManager statemanager, Game game)
    * 
    * Updates MenuState Object
    * 
    * @param statemanager
    * @param game
    */
    @Override
    public void tick(StateManager statemanager, Game game){ 
        textPositionX -= 2;
        
        if(textPositionX == -(MazeGenerator.getMainWidth()+60)*3) textPositionX = MazeGenerator.getMainWidth()+12;
    }
    
    
    /**
     * render(Graphics2D g2d)
     * 
     * Renders/Repaints MenuState
     * 
     * @param g2d
     */
    @Override
    public void render(Graphics2D g2d){
        Graphics2D g2d_MenuState = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        MouseInput.MouseButton = 0;
        
        //Draw Background
        //g2d_MenuState.drawImage(menuImage, menuImageX, menuImageY, menuImageW, menuImageH, null);
        renderWaveText((Graphics2D) offscreen.getGraphics());
        g2d_MenuState.drawImage(offscreen, 0, 0, null);
        ////////////////////////////////////////////////////////////////////////////
        
        //Render help text
        Fonts.drawString(g2d_MenuState, hlpFont, hlpCol, "Use Key(s) W / UP Arrow & S / Down Arrow, or the mouse.", hlpMsgX, hlpMsgY);
        Fonts.drawString(g2d_MenuState, hlpFont, hlpCol, "Enter key / Left Mouse button to select.", hlpMsgX, hlpMsgY + 20);
        ////////////////////////////////////////////////////////////////////////////
        
        //Draw Play Button
        if (MouseInput.MouseX > playBtnX && MouseInput.MouseX < playBtnX + playBtnW && MouseInput.MouseY > playBtnY && MouseInput.MouseY < playBtnY + playBtnH) {
            g2d_MenuState.drawImage(playOffBtn, playBtnX, playBtnY, playBtnW, playBtnH, null);
            menuImage = menuImage0;
            hlpCol = Color.orange;
            versionCol = Color.DARK_GRAY;

            //Draw Play Button Arrows
            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g2d_MenuState.drawImage(leftArrowIcon, playBtnX + 164, playBtnY + playBtnH/2 - arrowIconH/2, arrowIconW, arrowIconH, null);
                g2d_MenuState.drawImage(rightArrowIcon, playBtnX - 25, playBtnY + playBtnH/2 - arrowIconH/2, arrowIconW, arrowIconH, null);
            }
            MazeGenerator.setStatusBar("Play");

            //Set Play Button Click Logic
            if (MouseInput.MouseButton == 1) {
                Sound.stopAll();
                Sound.btnPushed.play();

                System.out.println("MenuState: Play Selected");
                Game.getGame().setStart();
                //config.loadConfiguration("res/sys/config.xml");
            }
        } else {
            g2d_MenuState.drawImage(playOnBtn, playBtnX, playBtnY, playBtnW, playBtnH, null);
        }
        ////////////////////////////////////////////////////////////////////////////

        //Draw Options Button
        if (MouseInput.MouseX > optionsBtnX && MouseInput.MouseX < optionsBtnX + optionsBtnW && MouseInput.MouseY > optionsBtnY && MouseInput.MouseY < optionsBtnY + optionsBtnH) {
            g2d_MenuState.drawImage(optionsOffBtn, optionsBtnX, optionsBtnY, optionsBtnW, optionsBtnH, null);
            menuImage = menuImage1;
            hlpCol = Color.red;
            versionCol = Color.white;

            //Draw Options Button Arrows
            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g2d_MenuState.drawImage(leftArrowIcon, optionsBtnX + 264, optionsBtnY + optionsBtnH/2 - arrowIconH/2, arrowIconW, arrowIconH, null);
                g2d_MenuState.drawImage(rightArrowIcon, optionsBtnX - 24, optionsBtnY + optionsBtnH/2 - arrowIconH/2, arrowIconW, arrowIconH, null);
            }
            MazeGenerator.setStatusBar("Options");

            //Set Options Button Click Logic
            if (MouseInput.MouseButton == 1) {
                Sound.stopAll();
                Sound.btnPushed.play();

                System.out.println("MenuState: Options Selected");
                Game.getGame().setOptions();
            }

        } else {
            g2d_MenuState.drawImage(optionsOnBtn, optionsBtnX, optionsBtnY, optionsBtnW, optionsBtnH, null);
        }
        ////////////////////////////////////////////////////////////////////////////

        //Draw Help Button
        if (MouseInput.MouseX > helpBtnX && MouseInput.MouseX < helpBtnX + helpBtnW && MouseInput.MouseY > helpBtnY && MouseInput.MouseY < helpBtnY + helpBtnH) {
            g2d_MenuState.drawImage(helpOffBtn, helpBtnX, helpBtnY, helpBtnW, helpBtnH, null);
            menuImage = menuImage2;
            hlpCol = Color.green;
            versionCol = Color.red;

            //Draw Help Button Arrows
            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g2d_MenuState.drawImage(leftArrowIcon, helpBtnX + 164, helpBtnY + helpBtnH/2 - arrowIconH/2, arrowIconW, arrowIconH, null);
                g2d_MenuState.drawImage(rightArrowIcon, helpBtnX - 25, helpBtnY + helpBtnH/2 - arrowIconH/2, arrowIconW, arrowIconH, null);
            }
            MazeGenerator.setStatusBar("Help");

            //Set Help Button Click Logic
            if (MouseInput.MouseButton == 1) {
                Sound.stopAll();
                Sound.btnPushed.play();

                System.out.println("MenuState: Help Selected");
                Game.getGame().setInstructions();
            }

        } else {
            g2d_MenuState.drawImage(helpOnBtn, helpBtnX, helpBtnY, helpBtnW, helpBtnH, null);
        }
        ////////////////////////////////////////////////////////////////////////////

        //Draw Quit Button
        if (MouseInput.MouseX > quitBtnX && MouseInput.MouseX < quitBtnX + quitBtnW && MouseInput.MouseY > quitBtnY && MouseInput.MouseY < quitBtnY + quitBtnH) {
            g2d_MenuState.drawImage(quitOffBtn, quitBtnX, quitBtnY, quitBtnW, quitBtnH, null);
            menuImage = menuImage3;
            hlpCol = Color.blue;
            versionCol = Color.CYAN;

            //Draw Quit Button Arrows
            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g2d_MenuState.drawImage(leftArrowIcon, quitBtnX + 164, quitBtnY + quitBtnH/2 - arrowIconH/2, arrowIconW, arrowIconH, null);
                g2d_MenuState.drawImage(rightArrowIcon, quitBtnX - 28, quitBtnY + quitBtnH/2 - arrowIconH/2, arrowIconW, arrowIconH, null);
            }
            MazeGenerator.setStatusBar("Quit?");

            //Set Quit Button Click Logic
            if (MouseInput.MouseButton == 1) {
                Sound.stopAll();
                Sound.btnPushed.play();
                MazeGenerator.setStatusBar("Quit Game?");

                System.out.println("MenuState: Quit Selected");
                Game.getGame().quitGame();
            }

        } else {
            g2d_MenuState.drawImage(quitOnBtn, quitBtnX, quitBtnY, quitBtnW, quitBtnH, null);
        }
        ////////////////////////////////////////////////////////////////////////////
            
        //Draw About Button
        if (MouseInput.MouseX > aboutBtnX && MouseInput.MouseX < aboutBtnX + aboutBtnW && MouseInput.MouseY > aboutBtnY && MouseInput.MouseY < aboutBtnY + aboutBtnH) {
            g2d_MenuState.drawImage(aboutOffBtn, aboutBtnX, aboutBtnY, aboutBtnW, aboutBtnH, null);

            //Draw About Button Arrows
            if((System.currentTimeMillis() / 150) * 0.5 % 2 == 0){
                g2d_MenuState.drawImage(leftArrowIcon, aboutBtnX + 68, aboutBtnY + aboutBtnH/2 - arrowIconH/2, arrowIconW, arrowIconH, null);
                g2d_MenuState.drawImage(rightArrowIcon, aboutBtnX - 12, aboutBtnY + aboutBtnH/2 - arrowIconH/2, arrowIconW, arrowIconH, null);
            }
            MazeGenerator.setStatusBar("About");

            //Set About Button Click Logic
            if (MouseInput.MouseButton == 1) {
                Sound.stopAll();
                Sound.btnPushed.play();

                System.out.println("MenuState: About Selected");

                Game.getGame().setAbout();
            }

        } else {
            g2d_MenuState.drawImage(aboutOnBtn, aboutBtnX, aboutBtnY, aboutBtnW, aboutBtnH, null);
        }
        ////////////////////////////////////////////////////////////////////////////
            
        //Draw Version
        Fonts.drawString(g2d_MenuState, versionFont, versionCol, Game.version, versionBtnX, versionBtnY);
        ////////////////////////////////////////////////////////////////////////////

        if(!(MouseInput.MouseX > playBtnX && MouseInput.MouseX < playBtnX + playBtnW && MouseInput.MouseY > playBtnY && MouseInput.MouseY < playBtnY + playBtnH) && 
                !(MouseInput.MouseX > optionsBtnX && MouseInput.MouseX < optionsBtnX + optionsBtnW && MouseInput.MouseY > optionsBtnY && MouseInput.MouseY < optionsBtnY + optionsBtnH) && 
                !(MouseInput.MouseX > helpBtnX && MouseInput.MouseX < helpBtnX + helpBtnW && MouseInput.MouseY > helpBtnY && MouseInput.MouseY < helpBtnY + helpBtnH) && 
                !(MouseInput.MouseX > quitBtnX && MouseInput.MouseX < quitBtnX + quitBtnW && MouseInput.MouseY > quitBtnY && MouseInput.MouseY < quitBtnY + quitBtnH) && 
                !(MouseInput.MouseX > aboutBtnX && MouseInput.MouseX < aboutBtnX + aboutBtnW &&  MouseInput.MouseY > aboutBtnY && MouseInput.MouseY < aboutBtnY + aboutBtnH)){
            MazeGenerator.setStatusBar("Ready");
        }
        
        g2d.setTransform(oldXForm);
        g2d_MenuState.setTransform(oldXForm);    
    }
    
    private void renderWaveText(Graphics2D g2d) {
        g2d.clearRect(0, 0, MazeGenerator.getMainWidth()+12, MazeGenerator.getMainHeight());
        g2d.setFont(textFont);
        g2d.drawString(textMessage, (int) textPositionX, (int) textPositionY);
        
        for(int x = 0; x < MazeGenerator.getMainWidth()+12; x++){
            int y = (int) (-50 + 50 * Math.sin(x * 0.015));
            g2d.drawImage(offscreen, x, y, x+1, y + offscreen.getHeight(), x, 0, x+1, offscreen.getHeight(), null);
        }
    }

    
    /**
    * init()
    * 
    */
    @Override
    public void init() {
        System.out.println("MenuState: Initiating Menu State . . .");
        //textPositionY = 150;
    }

    
    /**
    * enter()
    * 
    */
    @Override
    public void enter() {
        System.out.println("MenuState: Entering Menu State . . .");
        Sound.stopAll();
        Sound.Menu4.loop();
    }

    
    /**
    * exit()
    * 
    */
    @Override
    public void exit() {
        System.out.println("MenuState: Exiting Menu State . . .");
        Sound.stopAll();
    }

    
    /**
    * getName()
    * 
    * @return "menu" - name of State
    */
    @Override
    public String getName() {
        return "menu";
    }

    
}
