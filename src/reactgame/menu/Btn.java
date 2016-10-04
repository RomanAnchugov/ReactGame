/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import reactgame.services.Renderer;

/**
 *
 * @author Roman
 */
public class Btn extends MouseAdapter implements Renderer{

    private int width;
    private int height;
    private int posX;
    private int posY;
    private String text;
    private Font font;
    
    public Btn(int width, int height, int posX, int posY,String text){
        this.width = width;
        this.height = height;
        this.posX = posX;
        this.posY = posY;
        this.text = text;
        font = new Font("sans", 1, 30);
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(posX, posY, width, height);
        g.setColor(Color.black);
        g.setFont(font);
        g.drawString(text, posX + width / 2 - font.getSize() - 5, posY + height / 2 + font.getSize() / 2);
    }

    public void click(){
        
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX() >= posX && e.getX() <= posX + width &&
                e.getY() >= posY && e.getY() <= posY + height){
            click();
        }
    }

    
    
    @Override
    public void update() {
        
    }
    
}
