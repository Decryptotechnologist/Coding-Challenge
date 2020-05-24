/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.gui;

import com.LOGamez.audio.Sound;
import com.LOGamez.mazegenerator.MazeGenerator;
import com.LOGamez.mazegenerator.Game;
//import com.LOGamez.level.Level;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author Ghomez
 */
public class MainMenu extends JMenuBar {
    
    /**Attributes*/
    
    /**Links*/
    
    /**Constructor*/
    
    /**
     * MainMenu Constructor
     * 
     * 
     * @param game
     */
    public MainMenu(Game game){
        System.out.println("MainMenu: New MainMenu created");
        
        ImageIcon newIcon = new ImageIcon("res/icon/saucer3b.png");
        ImageIcon exitIcon = new ImageIcon("res/icon/exit.png");
        
        ImageIcon optionsIcon = new ImageIcon("res/icon/settings.png");
        
        ImageIcon statusIcon = new ImageIcon("res/icon/statusbar.png");
        ImageIcon fpsIcon = new ImageIcon("res/icon/FPSa.png");
        ImageIcon upsIcon = new ImageIcon("res/icon/UPS.png");
        ImageIcon boundsIcon = new ImageIcon("res/icon/bounds.png");
//        ImageIcon soundIcon = new ImageIcon("res/icon/sound.png");
        ImageIcon sfxIcon = new ImageIcon("res/icon/sfx.png");
        ImageIcon musicIcon = new ImageIcon("res/icon/music.png");
//        ImageIcon rapidIcon = new ImageIcon("res/icon/rapid.png");
        ImageIcon KsIcon = new ImageIcon("res/icon/Killshot.png");
        ImageIcon playerIcon = new ImageIcon("res/icon/SI_Player0.png");
        ImageIcon playerHitIcon = new ImageIcon("res/icon/SI_Player1_1.png");
        ImageIcon powCannonIcon = new ImageIcon("res/icon/SI_cPOWT1_0.png");
        ImageIcon powShieldIcon = new ImageIcon("res/icon/SI_shPOWT1_0.png");
        ImageIcon powSpeedIcon = new ImageIcon("res/icon/SI_spPOWT1_0.png");
        
        
        
        //GAME
        JMenu fileMenu = new JMenu("Game");
        
            //GAME : NEW GAME
            JMenuItem newMi = new JMenuItem("New Game", newIcon);
            KeyStroke f10 = KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0);
            newMi.setAccelerator(f10);
            newMi.setMnemonic(KeyEvent.VK_F10);
            
            newMi.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    System.out.println("New Game Clicked!");
                }
            });
            
        
            //GAME : EXIT GAME
            JMenuItem exitMi = new JMenuItem("Exit Game", exitIcon);
            KeyStroke f4 = KeyStroke.getKeyStroke(KeyEvent.VK_F4, 0);
            exitMi.setAccelerator(f4);
            exitMi.setMnemonic(KeyEvent.VK_F4);
            
            exitMi.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    System.out.println("Exit Game Clicked!");
                    game.quitGame();
                }
            });
            
        ////////////////////////////////////////////////////////////////////////    
            
        //EDIT
        JMenu editMenu = new JMenu("Edit");
        editMenu.setMnemonic(java.awt.event.KeyEvent.VK_E);
        
            //EDIT : OPTIONS
            JMenuItem optionsMi = new JMenuItem("Options", optionsIcon);
            optionsMi.setMnemonic(java.awt.event.KeyEvent.VK_O);
            KeyStroke o = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, 0);
            optionsMi.setAccelerator(o);

            optionsMi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent event) {
                    Sound.btnPushed.play();
                    game.setOptions();
                }
            });
            
        ////////////////////////////////////////////////////////////////////////
        
        
        //VIEW
        JMenu viewMenu = new JMenu("View");
        viewMenu.setMnemonic(java.awt.event.KeyEvent.VK_V);
        
            //VIEW : SHOW STATUSBAR
            JCheckBoxMenuItem sbarMi = new JCheckBoxMenuItem("Show statubar", statusIcon);
            sbarMi.setMnemonic(java.awt.event.KeyEvent.VK_Z);
            KeyStroke z = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, 0);
            sbarMi.setAccelerator(z);
            sbarMi.setSelected(true);

            sbarMi.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {

                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Sound.btnPushed.play();
                        MazeGenerator.statusBar.setVisible(true);
                    } else {
                        Sound.btnPushed.play();
                        MazeGenerator.statusBar.setVisible(false);
                    }

                }

            });

            //VIEW : SHOW FPS
            JCheckBoxMenuItem sfpsMi = new JCheckBoxMenuItem("Show FPS", fpsIcon);
            sfpsMi.setMnemonic(java.awt.event.KeyEvent.VK_F);
            KeyStroke f = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, 0);
            sfpsMi.setAccelerator(f);
            sfpsMi.setSelected(true);

            sfpsMi.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {

                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Sound.btnPushed.play();
                        Game.showFPS = true;
                    } else {
                        Sound.btnPushed.play();
                        Game.showFPS = false;
                    }

                }

            });

            //VIEW : SHOW UPS
            JCheckBoxMenuItem sUpsMi = new JCheckBoxMenuItem("Show UPS", upsIcon);
            sUpsMi.setMnemonic(java.awt.event.KeyEvent.VK_P);
            KeyStroke p = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0);
            sUpsMi.setAccelerator(p);
            sUpsMi.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {

                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Sound.btnPushed.play();
                        Game.showUPS = true;
                    } else {
                        Sound.btnPushed.play();
                        Game.showUPS = false;
                    }

                }

            });

            //VIEW : SHOW BOUNDS
            JCheckBoxMenuItem sboundsMi = new JCheckBoxMenuItem("Show Bounds", boundsIcon, false);
            sboundsMi.setMnemonic(java.awt.event.KeyEvent.VK_B);
            KeyStroke b = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, 0);
            sboundsMi.setAccelerator(b);
            sboundsMi.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {

                    if(e.getStateChange() == ItemEvent.SELECTED) {
                        Sound.btnPushed.play();
                        Game.showBounds = true;
                    } else {
                        Sound.btnPushed.play();
                        Game.showBounds = false;
                    }

                }

            });
            
            //VIEW : SHOW KILLSHOT
            JCheckBoxMenuItem sKillshotMi = new JCheckBoxMenuItem("Show Kill Shot", KsIcon);
            sKillshotMi.setMnemonic(java.awt.event.KeyEvent.VK_K);
            KeyStroke k = KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, 0);
            sKillshotMi.setAccelerator(k);
            sKillshotMi.setSelected(true);

            sKillshotMi.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {

                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Sound.btnPushed.play();
                        Game.showKillShot = true;
                    } else {
                        Sound.btnPushed.play();
                        Game.showKillShot = false;
                    }

                }

            });
        ////////////////////////////////////////////////////////////////////////
        
            
        //DEVELOPER
        JMenu devMenu = new JMenu("Developer");
        devMenu.setMnemonic(java.awt.event.KeyEvent.VK_D);
        
        //DEVELOPER : GAME    
        JMenu gameMenu = new JMenu("Game");
        gameMenu.setMnemonic(java.awt.event.KeyEvent.VK_G);

        //DEVELOPER : GAME : PLAYER
        JMenu playerMenu = new JMenu("Player");
        playerMenu.setMnemonic(java.awt.event.KeyEvent.VK_P);
        
            //DEVELOPER : GAME : PLAYER : EXTRA LIFE
            JMenuItem extraLifeMi = new JMenuItem("Extra Life", playerIcon);
            KeyStroke plus = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, 0);
            extraLifeMi.setAccelerator(plus);
            extraLifeMi.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    Sound.btnPushed.play();
                    //Game.getGame().paddle.extraLife();
                }

            });
            
            //DEVELOPER : GAME : PLAYER : LOSE A LIFE
            JMenuItem loseALifeMi = new JMenuItem("Lose A Life", playerHitIcon);
            KeyStroke minus = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, 0);
            loseALifeMi.setAccelerator(minus);
            loseALifeMi.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    Sound.btnPushed.play();
                    //Game.getGame().paddle.loseALife();
                }

            });
            
            //DEVELOPER : GAME : PLAYER : SET LIVES 3
            JMenuItem setLives3Mi = new JMenuItem("Set Lives 3", playerIcon);
            KeyStroke f6 = KeyStroke.getKeyStroke(KeyEvent.VK_F6, 0);
            setLives3Mi.setAccelerator(f6);
            setLives3Mi.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    Sound.btnPushed.play();
                    //Game.getGame().paddle.setLives(3);
                }

            });
            
            //DEVELOPER : GAME : PLAYER : SET LIVES 5
            JMenuItem setLives5Mi = new JMenuItem("Set Lives 5", playerIcon);
            KeyStroke f7 = KeyStroke.getKeyStroke(KeyEvent.VK_F7, 0);
            setLives5Mi.setAccelerator(f7);
            setLives5Mi.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    Sound.btnPushed.play();
                    //Game.getGame().paddle.setLives(5);
                }

            });
            
            //DEVELOPER : GAME : PLAYER : SET LIVES 8
            JMenuItem setLives8Mi = new JMenuItem("Set Lives 8", playerIcon);
            KeyStroke f8 = KeyStroke.getKeyStroke(KeyEvent.VK_F8, 0);
            setLives8Mi.setAccelerator(f8);
            setLives8Mi.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    Sound.btnPushed.play();
                    //Game.getGame().paddle.setLives(8);
                }

            });
            
            //DEVELOPER : GAME : PLAYER : SET POW 1
            JMenuItem setPOW1Mi = new JMenuItem("Set POW 1", powCannonIcon);
            KeyStroke f1 = KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0);
            setPOW1Mi.setAccelerator(f1);
            setPOW1Mi.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    Sound.btnPushed.play();
                    //Game.getGame().paddle.setPOW(1);
                }

            });
            
            //DEVELOPER : GAME : PLAYER : SET POW 2
            JMenuItem setPOW2Mi = new JMenuItem("Set POW 2", powShieldIcon);
            KeyStroke f2 = KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0);
            setPOW2Mi.setAccelerator(f2);
            setPOW2Mi.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    Sound.btnPushed.play();
                    //Game.getGame().paddle.setPOW(2);
                }

            });
            
            //DEVELOPER : GAME : PLAYER : SET POW 3
            JMenuItem setPOW3Mi = new JMenuItem("Set POW 3", powSpeedIcon);
            KeyStroke f3 = KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0);
            setPOW3Mi.setAccelerator(f3);
            setPOW3Mi.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent event) {
                    Sound.btnPushed.play();
                    //Game.getGame().paddle.setPOW(3);
                }

            });
        ////////////////////////////////////////////////////////////////////////    
            
            
            
        //DEVELOPER : SOUND
        JMenu soundMenu = new JMenu("Sound");
        soundMenu.setMnemonic(KeyEvent.VK_F9);
            
            //DEVELOPER : SOUND : SOUND ON
            JCheckBoxMenuItem soundMi = new JCheckBoxMenuItem("Sound Enabled", sfxIcon);
            soundMi.setMnemonic(KeyEvent.VK_S);
            KeyStroke s = KeyStroke.getKeyStroke(KeyEvent.VK_S, 0);
            soundMi.setAccelerator(s);
            soundMi.setSelected(true);

            soundMi.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {

                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Sound.btnPushed.play();
                        Game.getGame().setGameSound(true);
                    } else {
                        Game.getGame().setGameSound(false);

                        Sound.stopAll();
                    }

                }

            });

            //DEVELOPER : SOUND : MUSIC ON
            JCheckBoxMenuItem musicMi = new JCheckBoxMenuItem("Game Music Enabled", musicIcon);
            musicMi.setMnemonic(KeyEvent.VK_M);
            KeyStroke m = KeyStroke.getKeyStroke(KeyEvent.VK_M, 0);
            musicMi.setAccelerator(m);
            musicMi.setSelected(true);

            musicMi.addItemListener(new ItemListener() {

                @Override
                public void itemStateChanged(ItemEvent e) {

                    if (e.getStateChange() == ItemEvent.SELECTED) {
                        Sound.btnPushed.play();
                        Game.getGame().setGameMusic(true);
                    } else {
                        Sound.btnPushed.play();
                        Game.getGame().setGameMusic(false);

                        Sound.Level1.stop();
                        Sound.Level2.stop();
                        Sound.Level3.stop();
                        Sound.Level4.stop();
                        Sound.Level5.stop();
                        Sound.Level6.stop();
                        Sound.Level7.stop();
                        Sound.Level8.stop();
                        Sound.Level9.stop();
                    }

                }

            });
            
            //DEVELOPER : GAME : RESET SCORE
            JMenuItem resetScoreMi = new JMenuItem("Reset Score");
            KeyStroke home = KeyStroke.getKeyStroke(KeyEvent.VK_HOME, 0);
            resetScoreMi.setAccelerator(home);
                
                resetScoreMi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        Game.resetScore();
                    }

                });
                
                //DEVELOPER : GAME : LOSE GAME || GAME OVER
                JMenuItem loseGameMi = new JMenuItem("Lose Game");
                
                loseGameMi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        Game.lose();
                    }

                });
                
                //DEVELOPER : GAME : QUIT GAME
                JMenuItem quitGameMi = new JMenuItem("Quit Game");
                KeyStroke q = KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0);
                quitGameMi.setAccelerator(q);
                
                quitGameMi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        Game.quitGame();
                    }

                });
            ////////////////////////////////////////////////////////////////////////    
                
            //DEVELOPER : LEVEL
            JMenu levelMenu = new JMenu("Level");
            levelMenu.setMnemonic(KeyEvent.VK_L);
            
            
                //DEVELOPER : LEVEL : NEXT LEVEL
                JMenuItem nextLevelMi = new JMenuItem("Next Level");
                
                nextLevelMi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        //Level.changeLevel();
                    }

                });
                
                //DEVELOPER : LEVEL : SET LEVEL 1
                JMenuItem setLevel1Mi = new JMenuItem("Set Level 1");
                
                setLevel1Mi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        Game.setStartLevel(1);
                    }

                });
                
                //DEVELOPER : LEVEL : SET LEVEL 2
                JMenuItem setLevel2Mi = new JMenuItem("Set Level 2");
                
                setLevel2Mi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        Game.setStartLevel(2);
                    }

                });
                
                //DEVELOPER : LEVEL : SET LEVEL 3
                JMenuItem setLevel3Mi = new JMenuItem("Set Level 3");
                
                setLevel3Mi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        Game.setStartLevel(3);
                    }

                });
                
                //DEVELOPER : LEVEL : SET LEVEL 4
                JMenuItem setLevel4Mi = new JMenuItem("Set Level 4");
                
                setLevel4Mi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        Game.setStartLevel(4);
                    }

                });
                
                //DEVELOPER : LEVEL : SET LEVEL 5
                JMenuItem setLevel5Mi = new JMenuItem("Set Level 5");
                
                setLevel5Mi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        Game.setStartLevel(5);
                    }

                });
                
                //DEVELOPER : LEVEL : SET LEVEL 6
                JMenuItem setLevel6Mi = new JMenuItem("Set Level 6");
                
                setLevel6Mi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        Game.setStartLevel(6);
                    }

                });
                
                //DEVELOPER : LEVEL : SET LEVEL 7
                JMenuItem setLevel7Mi = new JMenuItem("Set Level 7");
                
                setLevel7Mi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        Game.setStartLevel(7);
                    }

                });
                
                //DEVELOPER : LEVEL : SET LEVEL 8
                JMenuItem setLevel8Mi = new JMenuItem("Set Level 8");
                
                setLevel8Mi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        Game.setStartLevel(8);
                    }

                });
                
                //DEVELOPER : LEVEL : SET BACKGROUND 1
                JMenuItem setPlanet1Mi = new JMenuItem("Set Background 1");
                
                setPlanet1Mi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        //Level.setBackground(1);
                    }

                });
                
                //DEVELOPER : LEVEL : SET BACKGROUND 2
                JMenuItem setPlanet2Mi = new JMenuItem("Set Background 2");
                
                setPlanet2Mi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        //Level.setBackground(2);
                    }

                });
                
                //DEVELOPER : LEVEL : SET BACKGROUND 3
                JMenuItem setPlanet3Mi = new JMenuItem("Set Background 3");
                
                setPlanet3Mi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        //Level.setBackground(3);
                    }

                });
                
                //DEVELOPER : LEVEL : SET BACKGROUND 4
                JMenuItem setPlanet4Mi = new JMenuItem("Set Background 4");
                
                setPlanet4Mi.addActionListener(new ActionListener() {
                    
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        Sound.btnPushed.play();
                        //Level.setBackground(4);
                    }

                });
                
        ////////////////////////////////////////////////////////////////////////
        
        
        //HELP
        JMenu helpMenu = new JMenu("Help");
        
            //HELP : HELP
            JMenuItem helpMi = new JMenuItem("Help");
            KeyStroke h = KeyStroke.getKeyStroke(KeyEvent.VK_H, 0);
            helpMi.setAccelerator(h);
            helpMi.setMnemonic(KeyEvent.VK_H);
            
            helpMi.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                    System.out.println("Help Clicked!");
                    Game.getGame().setInstructions();
                }
            });
            
        ////////////////////////////////////////////////////////////////////////
        
        helpMenu.add(helpMi);
        
        playerMenu.addSeparator();
        playerMenu.add(extraLifeMi);
        playerMenu.add(loseALifeMi);
        playerMenu.addSeparator();
        playerMenu.add(setLives3Mi);
        playerMenu.add(setLives5Mi);
        playerMenu.add(setLives8Mi);
        playerMenu.addSeparator();
        playerMenu.add(setPOW1Mi);
        playerMenu.add(setPOW2Mi);
        playerMenu.add(setPOW3Mi);
        
        gameMenu.add(playerMenu);
        gameMenu.addSeparator();
        gameMenu.add(resetScoreMi);
        gameMenu.add(loseGameMi);
        gameMenu.add(quitGameMi);
        
        soundMenu.add(soundMi);
        soundMenu.add(musicMi);
        
        levelMenu.add(nextLevelMi);
        levelMenu.addSeparator();
        levelMenu.add(setLevel1Mi);
        levelMenu.add(setLevel2Mi);
        levelMenu.add(setLevel3Mi);
        levelMenu.add(setLevel4Mi);
        levelMenu.add(setLevel5Mi);
        levelMenu.add(setLevel6Mi);
        levelMenu.add(setLevel7Mi);
        levelMenu.add(setLevel8Mi);
        levelMenu.addSeparator();
        levelMenu.add(setPlanet1Mi);
        levelMenu.add(setPlanet2Mi);
        levelMenu.add(setPlanet3Mi);
        levelMenu.add(setPlanet4Mi);
        
        devMenu.add(gameMenu);
        devMenu.add(soundMenu);
        devMenu.add(levelMenu);
        
        viewMenu.add(sfpsMi);
        viewMenu.add(sUpsMi);
        viewMenu.add(sbarMi);
        viewMenu.addSeparator();
        viewMenu.add(sKillshotMi);
        viewMenu.add(sboundsMi);
        
        editMenu.add(optionsMi);
        
        fileMenu.add(newMi);
        fileMenu.addSeparator();
        fileMenu.add(exitMi);

        this.add(fileMenu);
        this.add(editMenu);
        this.add(viewMenu);
        this.add(devMenu);
        this.add(Box.createHorizontalGlue());
        this.add(helpMenu);

        this.setVisible(true);        
        this.setOpaque(true);
    }
    
    /**Public Protocol*/
    
}
