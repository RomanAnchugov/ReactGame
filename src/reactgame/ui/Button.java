/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.ui;

import java.awt.Graphics;
import java.awt.Image;
import reactgame.services.Renderer;

/**
 *
 * @author User
 */
public class Button implements Renderer{

    private int width;
    private int height;
    private String text;
    private Image img;
    private int type;//1 - text btn, 2 - image btn, 3 - clear btn
    
    public Button(Image img){
        this.img = img;
        this.width = width;
        this.height = height;        
    }
    public Button(String text, int width, int height){
        this.text = text;
        this.width = width;
        this.height = height;
    }
    
    @Override
    public void render(Graphics g) {
        
    }

    @Override
    public void update() {
        
    }
    
}
