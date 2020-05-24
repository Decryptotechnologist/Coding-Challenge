package com.LOGamez.graphics;

//import com.LOGamez.bullets.*;
//import com.LOGamez.enemies.Enemy;
//import com.LOGamez.explodes.*;
import com.LOGamez.mazegenerator.Game;
//import com.LOGamez.powerup.POW;
import java.awt.Graphics2D;

/**
 * Screen objects represent 
 * 
 * @author(s) The Cherno, Ghomez
 */
public class Screen extends Render {

    /**Attributes*/
    
    /**Links*/
    
    
    /**Constructor*/
    
    
    /**
    * Screen(int width, int height)
    * 
    * @param height the height of Render
    * @param width the width of Render
    */
    public Screen(int width, int height) {
        super(width, height);        
        System.out.println("Screen: New Screen Created");
    }


    /**
    * render(Game game, boolean hasFocus, Graphics2D g)
    * 
    * Renders/Repaints Screen
    * 
    * @param game - the height of Screen
    * @param hasFocus - the width of Screen
    * @param g2d
    */
    public void render(Game game, boolean hasFocus, Graphics2D g2d) {
        
        if((game.menu == null && !game.stateManager.currentState.getName().equals("menu")) || game.stateManager.currentState.getName().equals("Credits")){    
            
            draw(this, 0, 0);
            
//            Game.level.render(g2d);
//            Game.paddle.render(g2d);//Render another class using args Game, g2d
//            Game.hud.render(g2d);
            Game.maze.render(g2d);
            
//            EnExplode.render(this, g);
//            P1BExplode.render(this, g);
            
//            POW.render(this, g);
//            Enemy.render(this, g);
        }


        if (game.menu != null) {
            for (int i = 0; i < pixels.length; i++) {
                pixels[i] = (pixels[i] & 0xfcfcfc) >> 2;
            }
            game.menu.render(this, g2d);
        }
        
        if (!hasFocus) {
            for (int i = 0; i < pixels.length; i++) {
                pixels[i] = (pixels[i] & 0xfc0024) >> 2;
            }
//            if (System.currentTimeMillis() / 450 % 2 != 0) {
//                scaleDraw(Texture.buttonsA, Labels.click2FocusScale, Labels.click2FocusX, Labels.click2FocusY, 235, 225, 220, 35, 0xff0000);
//            }
        }
                
    }

}
