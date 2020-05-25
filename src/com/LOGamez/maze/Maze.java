/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.maze;

import com.LOGamez.graphics.Texture;
import com.LOGamez.mazegenerator.MazeGenerator;
import com.LOGamez.path.DepthFirst;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Ghomez
 */
public class Maze {

    /**Attributes*/
    
    /**challengeNo variable of Maze*/
    int challengeNo;
    
    /**challengeWidth variable of Maze*/
    int challengeWidth;
    
    /**challengeHeight variable of Maze*/
    int challengeHeight;
    
    /**firstTick variable of Maze*/
    private boolean firstTick;
    
    /**lastTick variable of Maze*/
    private boolean lastTick;
    
    /**challengeTime variable of Maze*/
    private int challengeTime;
    
    /**size variable of Maze*/
    private int[] size;
    
    /**
     * maze variable of Maze   
     * 
     * maze[row][col]/maze[x][y] 0:Not visited, 1:wall, 2:visited, 7:GhostHouse, 8:Red, 9:target
     */
    private final int[][] mazeBlank = {
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
        {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
    };
    
    /**
     * maze variable of Maze   
     * 
     * maze[row][col]/maze[x][y] 0:Not visited, 1:wall, 2:visited, 7:GhostHouse, 8:Red, 9:target
     */
    private final int[][] mazeDefault = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,0,1,0,0,0,0,1,0,1,1,1,1,1,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,1,1,1,0,1,0,0,0,1,0,1},
        {1,0,1,0,0,0,1,0,0,0,8,0,0,0,0,1,0,0,0,1,0,1},
        {1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
        {1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1},
        {1,0,0,0,1,0,1,0,1,1,6,6,1,1,0,1,0,1,0,0,0,1},
        {1,1,1,1,1,0,1,0,1,0,0,0,0,1,0,1,0,1,1,1,1,1},
        {0,0,0,0,0,0,0,0,1,0,0,7,0,1,0,0,0,0,0,0,0,0},
        {1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,1,0,0,0,0,9,0,0,0,1,0,0,0,0,0,1},
        {1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,0,1,0,1,1,0,1,0,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
        {1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,1,1,1,0,1,0,0,0,1,0,1},
        {1,0,1,1,1,1,1,0,1,0,0,0,0,1,0,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    /**
     * maze variable of Maze   
     * 
     * maze[row][col]/maze[x][y] 0:Not visited, 1:wall, 2:visited, 7:GhostHouse, 8:Red, 9:target
     */
    private final int[][] mazeWalls = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    /**
     * maze variable of Maze   
     * 
     * maze[row][col]/maze[x][y] 0:Not visited, 1:wall, 2:visited, 7:GhostHouse, 8:Red, 9:target
     */
    private int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,0,1,0,0,0,0,1,0,1,1,1,1,1,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,1,1,1,0,1,0,0,0,1,0,1},
        {1,0,1,0,0,0,1,0,0,0,8,0,0,0,0,1,0,0,0,1,0,1},
        {1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
        {1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1},
        {1,0,0,0,1,0,1,0,1,1,6,6,1,1,0,1,0,1,0,0,0,1},
        {1,1,1,1,1,0,1,0,1,0,0,0,0,1,0,1,0,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,1,0,0,7,0,1,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,1,0,0,0,0,9,0,0,0,1,0,0,0,0,0,1},
        {1,1,1,1,1,0,0,0,1,1,1,1,1,1,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,0,1,0,1,1,0,1,0,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,1},
        {1,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,1,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,1,1,1,0,1,0,0,0,1,0,1},
        {1,0,1,1,1,1,1,0,1,0,0,0,0,1,0,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    /**
     * maze1 variable of Maze   
     * 
     * maze[row][col]/maze[x][y] 0:Not visited, 1:wall, 2:visited, 7:GhostHouse, 8:Red, 9:target
     */
    private final int[][] maze1 = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,0,1,1,1,0,1,1,0,1,1,1,0,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,8,0,0,0,0,0,0,0,0,0,0,1},
        {1,0,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,1,1,0,1},
        {1,0,0,0,0,0,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0,1},
        {1,1,1,1,1,0,1,1,1,0,1,1,0,1,1,1,0,1,1,1,1,1},
        {0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0},
        {0,0,0,0,1,0,1,0,1,1,6,6,1,1,0,1,0,1,0,0,0,0},
        {1,1,1,1,1,0,1,0,1,0,0,0,0,1,0,1,0,1,1,1,1,1},
        {0,0,0,0,0,0,0,0,1,0,0,7,0,1,0,0,0,0,0,0,0,0},
        {1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1},
        {0,0,0,0,1,0,1,0,0,0,0,9,0,0,0,1,0,1,0,0,0,0},
        {0,0,0,0,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,0,0},
        {1,1,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,1,1,1,1,1},
        {1,0,0,0,0,0,1,1,1,0,1,1,0,1,1,1,0,0,0,0,0,1},
        {1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,0,1},
        {1,0,0,0,1,0,1,0,1,1,1,1,1,1,0,1,0,1,0,0,0,1},
        {1,1,1,0,0,0,1,0,0,0,1,1,0,0,0,1,0,0,0,1,1,1},
        {1,1,1,0,1,0,1,1,1,0,1,1,0,1,1,1,0,1,0,1,1,1},
        {1,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0,1,0,0,0,1},
        {1,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    /**path variable of Maze*/
    private final List<Integer> path = new ArrayList<>();
    
    
    /**Links*/
    
    
    /**Constructor*/
    
    
    /**
     * Challenge Constructor
     * 
     * @param ChallengeNo
     * @param w
     * @param h
     */
    public Maze(int ChallengeNo, int w, int h){
        System.out.println("Maze: new Maze "+ChallengeNo+" created");
        this.challengeNo = ChallengeNo;
        this.challengeWidth = w;
        this.challengeHeight = h;
        size = new int[23];
        
        setUp();
        
        //init();
    }
    
    
    /**Public Protocol*/
    
    
    /**
     * setUp()
     *
     */
    private void setUp(){
        switch(challengeNo){
            case 1:
                setUpChallenge1();
                break;
        }
    }

    private void setUpChallenge1() {
        //Setup variables here for Maze 1
        //maze = mazeWalls;
        
        init();

//        //Test Depth First
//        DepthFirst.searchPath(maze, 10, 4, path);
//        System.out.println(path);
    }
    
    private void init(){
        System.out.println("Maze: Initiating Maze");
        Texture.clearMaps();
        

        
//        for(int row = 0; row < maze1.length; row++){
//            for(int col = 0; col < maze1[0].length; col++){
//                put(maze1[row][col], row, col);
//            }
//        }
        
        //Test Depth First
        DepthFirst.searchPath(maze, 1, 1, path);
        System.out.println("Path size: "+path.size());
        System.out.println(path);
        System.out.println("Maze Dimensions: (W x H) "+maze[0].length+" x "+maze.length);
        System.out.println("Maze No. of Blocks: "+maze[0].length * maze.length);
        System.out.println("Maze start: "+get(1, 1));
        
        for(int row = 0; row < mazeDefault.length; row++){
            for(int col = 0; col < mazeDefault[0].length; col++){
                put(mazeDefault[row][col], row, col);
            }
        }
        
        firstTick = true;
        lastTick = false;
    }
    
    
    /**
     * render(Graphics2D g2d)
     *
     * @param g2d
     */
    public void render(Graphics2D g2d){
        Graphics2D g2d_Maze = g2d;
        AffineTransform oldXForm = g2d.getTransform();
        
        g2d_Maze.setColor(Color.ORANGE);
        g2d_Maze.drawString("Maze 1", MazeGenerator.getMainWidth()/2, 20);
        
        g2d_Maze.translate(30, 30);
        
        for(int row = 0; row < maze.length; row++){
            for(int col = 0; col < maze[0].length; col++){
                Color color;
                switch(maze[row][col]){
                    case 1: color = Color.BLUE; break;
                    case 6: color = Color.LIGHT_GRAY; break;
                    case 7: color = Color.WHITE; break;
                    case 8: color = Color.RED; break;
                    case 9: color = Color.YELLOW; break;
                    default: color = Color.BLACK; break;
                }
                g2d_Maze.setColor(color);
//                g2d_Maze.fillRect(25 * col, 27 * row, 25, 27);
//                g2d_Maze.setColor(Color.BLACK);
//                g2d_Maze.drawRect(25 * col, 27 * row, 25, 27);

                if(color == Color.YELLOW){
                    g2d_Maze.fillOval(25 * col, 27 * row+1, 24, 24);
                } else if(color == Color.BLACK){
                    g2d_Maze.fillRect(25 * col, 27 * row, 25, 27);
                } else if(color == Color.LIGHT_GRAY){
                    g2d_Maze.fillRect(25 * col, 27 * row+3, 25, 10);
                    g2d_Maze.setColor(Color.GRAY);
                    g2d_Maze.drawRect(25 * col, 27 * row+3, 25, 10);
                } else if(color == Color.RED){
                    g2d_Maze.fillOval(25 * col, 27 * row+1, 25, 27);
                    g2d_Maze.fillRect(25 * col, 27 * row + 27/2, 25, 27/2);
                } else if(color == Color.WHITE){
                    g2d_Maze.drawRect(25 * col, 27 * row, 25, 27);
                } else {
                    g2d_Maze.fillRoundRect(25 * col, 27 * row, 25, 27, -5, 5);
                    g2d_Maze.setColor(Color.BLACK);
                    g2d_Maze.drawRect(25 * col+1, 27 * row+1, 23, 25);
                }
            }
            
            
            
        }
        
        for(int p = 0; p < path.size(); p += 2){
            int pathX = path.get(p);
            int pathY = path.get(p+1);

            g2d_Maze.setColor(Color.GREEN);
            g2d_Maze.fillRect(pathX*25, pathY*27, 25, 27);
        }
    
        g2d.setTransform(oldXForm);
        g2d_Maze.setTransform(oldXForm);
    }
    
    /**
     * tick()
     *
     */
    public void tick(){
        //Handle First Tick
        if(firstTick){
            firstTick = false;
            //Game.resetGameTime();//Reset Game Timer(Optional)
            
        }
        //Handle Last Tick
        if(lastTick){
            lastTick = false;
//            Sound.stopAll();
//            if(!Sound.endOfLevel.isPlaying()){
//                Sound.endOfLevel.play();
//            }
            
        }
        
        //Enemy.tick();//Tick (update) other classes
        
        challengeTime++;//Update local timer
        
        if(challengeTime == 600){ 
            //init();
        
//            //Test Depth First
//            DepthFirst.searchPath(maze, 2, 2, path);
//            System.out.println(path);
        }
    }
    
    
    /**
     * get(int rowNum, int colNum)
     *
     * @param rowNum
     * @param colNum
     * 
     * @return maze[rowNum][colNum]
     */
    public int get(int rowNum, int colNum) {
        return maze[rowNum][colNum];
    }
    
    
    /**
     * put(int N, int rowNum)
     *
     * @param N
     * @param rowNum
     */
    public void put(int N, int rowNum, int colNum) {
        if (colNum < maze[0].length)
            maze[rowNum][colNum] = N;
//        else { // need to create a bigger array
//
//            int[] temp = new int[2 * size[rowNum]];
//            for (int i = 0; i < size[rowNum]; i++) {
//                temp[i] = maze[rowNum][i];
//            }
//            maze[0] = temp;
//            maze[0][size[rowNum]] = N;
//        }
//        size[rowNum] = size[rowNum] + 1;
    }

    
    /**
     * getSize(int rowNum)
     *
     * @param rowNum
     * 
     * @return size[rowNum]
     */
    public int getSize(int rowNum) {
        return size[rowNum];
    }
    
}
