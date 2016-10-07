/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;
import reactgame.services.Renderer;

/**
 *
 * @author Roman
 */
public class HelpTxt implements Renderer{
   
    private String helpText;
    private int posX, posY;
    private Font font;
    //colors
    private int r,g,b;
    private int speed;
    
    public HelpTxt(String helpText, int posX, int posY, int size){
        this.helpText = helpText;
        this.posX = posX;
        this.posY = posY;
        font = new Font("sans", 1, size);        
        r = 0;
        g = 0;
        b = 0;
        speed = 3;
    }
        
    @Override
    public void render(Graphics g) {
        g.setColor(new Color(r, this.g, b));
        g.setFont(font);
        g.drawString(helpText, posX, posY);
                
    }

    @Override
    public void update() {
        //color generator
        switch(new Random().nextInt(3)){
            case 0: 
                if(r < 255 - speed){
                    r += speed;
                }else{
                    r -= new Random().nextInt(150) + 70;
                }
                break;
            case 1:
                if(g < 255 - speed){
                    g += speed;
                }else{
                    g -= new Random().nextInt(150) + 70;
                }                
                break;
                case 2:                    
                if(b < 255 - speed){
                    b += speed;
                }else{
                    b -= new Random().nextInt(150) + 70;
                }                
                break;
        }
    }
    
}
