/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.path;

import java.util.List;

/**
 *
 * @author Leo Ono 
 * @Editor Ghomez
 */
public class DepthFirst {
    
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path){
        System.out.println("DepthFirst: Maze "+maze.length+" created");
        
        
        //Check if Target node reached
        if(maze[y][x] == 9){
            path.add(x);
            path.add(y);
            
            return true;
        }
        
        //Mark current POS as visited
        if(maze[y][x] == 0){
            maze[y][x] = 2;
        
        
            //If path found fill with current POS
            int dx = -1;
            int dy = 0;
            if(searchPath(maze, x + dx, y + dy, path)){
                path.add(x);
                path.add(y);

                return true;
            }

            dx = 1;
            dy = 0;
            if(searchPath(maze, x + dx, y + dy, path)){
                path.add(x);
                path.add(y);
                
                return true;
            }

            dx = 0;
            dy = -1;
            if(searchPath(maze, x + dx, y + dy, path)){
                path.add(x);
                path.add(y);

                return true;
            }

            dx = 0;
            dy = 1;
            if(searchPath(maze, x + dx, y + dy, path)){
                path.add(x);
                path.add(y);

                return true;
            }
        }
    
        return false;
    }
    
}
