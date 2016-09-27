/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import reactgame.Game;
import reactgame.services.Renderer;

/**
 *
 * @author User
 */
public class Button extends MouseAdapter implements Renderer{

    private int width;
    private int height;
    private int posX;
    private int posY;
    private String text;
    private Image img;
    private int shape;//1 - square, 2 - circle, 3 - triangle
    private Color color;
    public boolean visible = true;
    private int type;//1 - text btn, 2 - image btn, 3 - clear btn
    
    public Button(int shape, Color color, int width, int height){
        this.shape = shape;
        this.color = color;
        this.width = width;
        this.height = height;
        posX = new Random().nextInt(Game.WIDTH);
        posY = new Random().nextInt(Game.HEIGHT);        
    }
    public Button(Image img){
        this.img = img;
        this.width = width;
        this.height = height;        
        posX = new Random().nextInt(Game.WIDTH);
        posY = new Random().nextInt(Game.HEIGHT);
    }
    public Button(String text, int width, int height){
        this.text = text;
        this.width = width;
        this.height = height;
        posX = new Random().nextInt(Game.WIDTH);
        posY = new Random().nextInt(Game.HEIGHT);
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
    public void render(Graphics g) {
        if(!visible)return;
    }

    @Override
    public void update() {
        if(!visible)return;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Color getColor() {
        return color;
    }
    
}
