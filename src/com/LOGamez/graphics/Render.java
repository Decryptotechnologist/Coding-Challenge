/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.LOGamez.graphics;

/**
 *
 * @author Ghomez
 */
public class Render {

    /**Attributes*/
    
    /**Attributes*/
    int width;
    
    /**Attributes*/
    int height;
    
    /**Attributes*/
    public int[] pixels;
    
    /**Attributes*/
    static String chars = "" + //
            "abcdefghijklmnopqrstuvw" + //
            "xyz0123456789#!";
    
    
    /**Links*/
    
    /**Constructor*/
    
    /**
     * Render Constructor
     * 
     * 
     * @param width
     * @param height
     */
    public Render(int width, int height) {
        //System.out.println("Render: New Render created");
        this.width = width;
        this.height = height;
        pixels = new int[width * height];
    }
    
    
    /**
    * draw(Render bitmap, int xOffs, int yOffs)
    * 
    * @param bitmap - the bitmap variable Render object
    * @param xOffs - the xOffs variable Render object
    * @param yOffs - the yOffs variable Render object
    */  
    public void draw(Render bitmap, int xOffs, int yOffs) {
        for (int y = 0; y < bitmap.height; y++) {
            int yPix = y + yOffs;
            if (yPix < 0 || yPix >= height) {
                continue;
            }

            for (int x = 0; x < bitmap.width; x++) {
                int xPix = x + xOffs;
                if (xPix < 0 || xPix >= width) {
                    continue;
                }
                int src = bitmap.pixels[x + y * bitmap.width];
                pixels[xPix + yPix * width] = src;
            }
        }
    }
    
    
    /**
    * draw(Render bitmap, Double scaleW, Double scaleH, double xOffs, double yOffs, int w, int h)
    * 
    * @param bitmap - the bitmap variable Render object
    * @param scaleW - the scaleW variable Render object
    * @param scaleH - the scaleH variable Render object
    * @param xOffs - the xOffs variable Render object
    * @param yOffs - the yOffs variable Render object
    * @param w - the w variable Render object
    * @param h - the h variable Render object
    */  
    public void draw(Render bitmap, Double scaleW, Double scaleH, double xOffs, double yOffs, int w, int h) {
        for (int y = 0; y < bitmap.height * scaleH; y++) {
            int yPix =  y + (int) yOffs;
            if (yPix < 0 || yPix >= height) {
                continue;
            }

            for (int x = 0; x < bitmap.width * scaleW; x++) {
                int xPix =  x + (int) xOffs;
                if (xPix < 0 || xPix >= width) {
                    continue;
                }
                
                int scW = (int) (x / scaleW);
                int scH = (int) (y / scaleH);

                int src = bitmap.pixels[scW + scH * bitmap.width];
                pixels[xPix + yPix * width] = src;

            }
        }
    }

    
    /**
    * draw(Render bitmap, Double scaleW, Double scaleH, double xOffs, double yOffs, int w, int h)
    * 
    * @param bitmap - the bitmap variable Render object
    * @param scaleW - the scaleW variable Render object
    * @param scaleH - the scaleH variable Render object
    * @param xOffs - the xOffs variable Render object
    * @param yOffs - the yOffs variable Render object
    * @param w - the w variable Render object
    * @param h - the h variable Render object
    * @param col
    */  
    public void draw(Render bitmap, Double scaleW, Double scaleH, double xOffs, double yOffs, int w, int h, int col) {
        for (int y = 0; y < bitmap.height * scaleH; y++) {
            int yPix =  y + (int) yOffs;
            if (yPix < 0 || yPix >= height) {
                continue;
            }

            for (int x = 0; x < bitmap.width * scaleW; x++) {
                int xPix =  x + (int) xOffs;
                if (xPix < 0 || xPix >= width) {
                    continue;
                }
                
                int scW = (int) (x / scaleW);
                int scH = (int) (y / scaleH);

                int src = bitmap.pixels[scW + scH * bitmap.width];
                if (src >= 0) {
                    pixels[xPix + yPix * width] = src * col;
                }

            }
        }
    }
    
    /**
    * draw(Render bitmap, int xOffs, int yOffs, int xo, int yo, int w, int h, int col)
    * 
    * @param bitmap - the bitmap variable Render object
    * @param xOffs - the xOffs variable Render object
    * @param yOffs - the yOffs variable Render object
    * @param xo - the xo variable Render object
    * @param yo - the yo variable Render object
    * @param w - the w variable Render object
    * @param h - the h variable Render object
    * @param col - the col variable Render object
    */ 
    public void draw(Render bitmap, int xOffs, int yOffs, int xo, int yo, int w, int h, int col) {      
        int bWidth = bitmap.width;
        for (int y = 0; y < h; y++) {
            int yPix = y + yOffs;
            if (yPix < 0 || yPix >= height) {
                continue;
            }

            for (int x = 0; x < w; x++) {
                int xPix = x + xOffs;
                if (xPix < 0 || xPix >= width) {
                    continue;
                }
                
                int src = bitmap.pixels[(x + xo) + (y + yo) * bWidth];
                if (src >= 0) {
                    pixels[xPix + yPix * width] = src * col;
                }
            }
        }
    }

    
    /**
    * draw(Render bitmap, int xo, int yo, int w, int h)
    * 
    * @param bitmap - the bitmap variable Render object
    * @param xo - the xo variable Render object
    * @param yo - the yo variable Render object
    * @param w - the w variable Render object
    * @param h - the h variable Render object
    */ 
    public void draw(Render bitmap, int xo, int yo, int w, int h) {
        int bWidth = bitmap.width;
        for (int y = 0; y < h; y++) {
            int yPix = y;
            if (yPix < 0 || yPix >= height) {
                continue;
            }

            for (int x = 0; x < w; x++) {
                int xPix = x;
                if (xPix < 0 || xPix >= width) {
                    continue;
                }

                int src = bitmap.pixels[(x + xo) + (y + yo) * bWidth];
                if (src >= 0) {
                    pixels[xPix + yPix * width] = src;
                }
            }
        }
    }

    
    /**
    * scaleDraw(Render bitmap, int scale, int xOffs, int yOffs, int xo, int yo, int w, int h, int col)
    * 
    * @param bitmap - the bitmap variable Render object
    * @param scale - the scale variable Render object
    * @param xOffs - the xOffs variable Render object
    * @param yOffs - the yOffs variable Render object
    * @param xo - the xo variable Render object
    * @param yo - the yo variable Render object
    * @param w - the w variable Render object
    * @param h - the h variable Render object
    * @param col - the col variable Render object
    */     
    public void scaleDraw(Render bitmap, int scale, int xOffs, int yOffs, int xo, int yo, int w, int h, int col) {
        for (int y = 0; y < h * scale; y++) {
            int yPix = y + yOffs;
            if (yPix < 0 || yPix >= height) {
                continue;
            }

            for (int x = 0; x < w * scale; x++) {
                int xPix = x + xOffs;
                if (xPix < 0 || xPix >= width) {
                    continue;
                }

                int src = bitmap.pixels[(x / scale + xo) + (y / scale + yo) * bitmap.width];
                if (src >= 0) {
                    pixels[xPix + yPix * width] = src * col;
                }
            }
        }
    }

    
    /**
    * scaleDraw(Render bitmap, double scale, int xOffs, int yOffs, int xo, int yo, int w, int h, int col)
    * 
    * @param bitmap - the bitmap variable Render object
    * @param scale - the scale variable Render object
    * @param xOffs - the xOffs variable Render object
    * @param yOffs - the yOffs variable Render object
    * @param xo - the xo variable Render object
    * @param yo - the yo variable Render object
    * @param w - the w variable Render object
    * @param h - the h variable Render object
    * @param col - the col variable Render object
    */     
    public void scaleDraw(Render bitmap, double scale, int xOffs, int yOffs, int xo, int yo, int w, int h, int col) {
        for (int y = 0; y < h * scale; y++) {
            int yPix = y + yOffs;
            if (yPix < 0 || yPix >= height) {
                continue;
            }

            for (int x = 0; x < w * scale; x++) {
                int xPix = x + xOffs;
                if (xPix < 0 || xPix >= width) {
                    continue;
                }

                int src = bitmap.pixels[(int) (x / scale + xo) + (int) (y / scale + yo) * bitmap.width];
                if (src > -1) {
                    pixels[xPix + yPix * width] = src * col;
                }
            }
        }
    }

    
    /**
    * scaleDraw(Render bitmap, double scale, int xOffs, int yOffs, int xo, int yo, int w, int h)
    * 
    * @param bitmap - the bitmap variable Render object
    * @param scale - the scale variable Render object
    * @param xOffs - the xOffs variable Render object
    * @param yOffs - the yOffs variable Render object
    * @param xo - the xo variable Render object
    * @param yo - the yo variable Render object
    * @param w - the w variable Render object
    * @param h - the h variable Render object
    */     
    public void scaleDraw(Render bitmap, double scale, int xOffs, int yOffs, int xo, int yo, int w, int h) {
        for (int y = 0; y < h * scale; y++) {
            int yPix = y + yOffs;
            if (yPix < 0 || yPix >= height) {
                continue;
            }

            for (int x = 0; x < w * scale; x++) {
                int xPix = x + xOffs;
                if (xPix < 0 || xPix >= width) {
                    continue;
                }

                int src = bitmap.pixels[(int) (x / scale + xo) + (int) (y / scale + yo) * bitmap.width];
                if (src > -1) {
                    pixels[xPix + yPix * width] = src;
                }
            }
        }
    }

    
    /**
    * draw(String string, int x, int y, int col)
    * 
    * @param string - the string variable Render object
    * @param x - the x variable Render object
    * @param y - the y variable Render object
    * @param col - the col variable Render object
    */     
    public void draw(String string, int x, int y, int col) {
        for (int i = 0; i < string.length(); i++) {
            int ch = chars.indexOf(string.charAt(i));
            if (ch < 0) {
                continue;
            }

            int xx = ch % 42;
            int yy = ch / 42;
            draw(Texture.fonts, x + i * 16, y, xx * 6, yy * 8, 5, 8, col);
        }
    }

    
    /**
    * drawText(String string, int scale, int x, int y, int col)
    * 
    * @param string - the string variable Render object
    * @param scale - the scale variable Render object
    * @param x - the x variable Render object
    * @param y - the y variable Render object
    * @param col - the col variable Render object
    */     
    public void drawText(String string, int scale, int x, int y, int col) {
        for (int i = 0; i < string.length(); i++) {
            int ch = chars.indexOf(string.charAt(i));
            if (ch < 0) {
                continue;
            }

            int xx = ch % 42;
            int yy = ch / 42;
            scaleDraw(Texture.fonts, scale, x + i * 16, y, xx * 6, yy * 8, 5, 8, col);
        }
    }
    
}
