/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Ghomez
 */
public class MouseInput extends MouseAdapter {

    /**Attributes*/                                      
       
    /**NUM_BUTTONS variable of MouseInput object*/
    private static final int NUM_BUTTONS = 256;
    
    /**lastX variable of MouseInput object*/
    private static int lastX;
    
    /**lastY variable of MouseInput object*/
    private static int lastY;
    
    /**MouseX variable of MouseInput object*/
    public static int MouseX = -1;
    
    /**MouseY variable of MouseInput object*/
    public static int MouseY = -1;
    
    /**MouseDX coordinate of MouseInput object*/
    public static int MouseDX = -1;
    
    /**MouseDY coordinate of MouseInput object*/
    public static int MouseDY = -1;
    
    /**MousePX coordinate of MouseInput object*/
    public static int MousePX;
    
    /**MousePY coordinate of MouseInput object*/
    public static int MousePY;
    
    /**buttons boolean[] of MouseInput object*/
    public static final boolean[] buttons = new boolean[NUM_BUTTONS];
    
    /**lastButtons boolean[] of MouseInput object*/
    private static final boolean[] lastButtons = new boolean[NUM_BUTTONS];
    
    /**moving boolean of MouseInput object*/
    private static boolean moving;
    
    /**MouseButton variable of MouseInput object*/
    public static int MouseButton = 0;
    
    /**dragged boolean of MouseInput object*/
    public static boolean dragged = false;
    
    
    /**Public Protocol*/
    
    
    /**
     * mouseMoved(MouseEvent m)
     * 
     * @param m
     */
    @Override
    public void mouseMoved(MouseEvent m) {
        MouseX = m.getX();
        MouseY = m.getY();
        moving = true;
    }

    
    /**
     * mouseDragged(MouseEvent m)
     * 
     * @param m
     */
    @Override
    public void mouseDragged(MouseEvent m) {
        MouseDX = m.getX();
        MouseDY = m.getY();
    }

    
    /**
     * mouseReleased(MouseEvent m)
     * 
     * @param m
     */
    @Override
    public void mouseReleased(MouseEvent m) {
        dragged = false;
        MouseButton = 0;
        buttons[m.getButton()] = false;
    }

    
    /**
     * mousePressed(MouseEvent m)
     * 
     * @param m
     */
    @Override
    public void mousePressed(MouseEvent m) {
        MousePX = m.getX();
        MousePY = m.getY();
        MouseButton = m.getButton();
        buttons[m.getButton()] = true;
    }
    
    
    /**
     * tick()
     * 
     */
    public static void tick(){
        MouseButton = 0;
        for(int i = 0; i < NUM_BUTTONS; i++){
            lastButtons[i] = buttons[i];
        }
        if(MouseX == lastX && MouseY == lastY){
            moving = false;
        }
        lastX = MouseX;
        lastY = MouseY;
    }
    
    
    /**
     * isButtonDown(int btn)
     * 
     * @param btn
     * @return buttons[btn]
     */
    public static boolean isButtonDown(int btn){
        return buttons[btn];
    }
    
    
    /**
     * wasPressed(int btn)
     * 
     * @param btn
     * @return 
     */
    public static boolean wasPressed(int btn){
        return isButtonDown(btn) && !lastButtons[btn];
    }
    
    
    /**
     * wasReleased(int btn)
     * 
     * @param btn
     * @return 
     */
    public static boolean wasReleased(int btn){
        return !isButtonDown(btn) && lastButtons[btn];
    }

    
    /**
     * getMouseX()
     * 
     * @return MouseX
     */
    public static int getMouseX() {
        return MouseX;
    }

    
    /**
     * getMouseY()
     * 
     * @return MouseY
     */
    public static int getMouseY() {
        return MouseY;
    }
    
    
    /**
     * isMoving()
     * 
     * @return moving
     */
    public static boolean isMoving(){
        return moving;
    }
    
}
