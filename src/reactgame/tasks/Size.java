/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.tasks;

import java.awt.Color;
import java.awt.Graphics;
import reactgame.ui.Button;

/**
 *
 * @author Roman
 */
public class Size extends Button{
    
    public Size(int shape, Color color, int width, int height) {
        super(shape, color, width, height);        
    }

    @Override
    public void click() {
        visible = false;
        System.out.println("click");
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics g) {        
        if(visible){
        g.setColor(getColor());
        g.fillOval(getPosX(), getPosY(), getWidth(), getHeight());
        }
    }
    
    
    
    

    
}
