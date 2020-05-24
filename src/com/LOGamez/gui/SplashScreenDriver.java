/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.gui;

import com.LOGamez.graphics.Texture;

/**
 *
 * @author Ghomez
 */
public class SplashScreenDriver {

    /**Attributes*/
    
    /**splash variable of SplashScreenDriver*/
    private final int maxProgress = 2000;
    
    /**Links*/
    
    /**splash variable of SplashScreenDriver*/
    private final SplashScreen splash;
    
    
    /**Constructor*/

    /**
     * SplashScreenDriver Constructor
     * 
     */
    public SplashScreenDriver() {
        splash = new SplashScreen(new Texture("/menu/splash_Publisher"), new Texture("/menu/splash_Author2a"));
        splash.setLocationRelativeTo(null);
        splash.setMaxProgress(maxProgress);
        //screen.setSize(640, 480);
        splash.setVisible(true);
        
        for(int i = 0; i <= maxProgress; i++){
            for(int j = 0; j <= 50000; j++){
                String t = "ewf" + (i + j); 
            }
            splash.setProgress(i);
        }
        splash.setVisible(false);
    }
    
}
