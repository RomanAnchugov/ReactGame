/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.services;

import java.awt.Color;
import java.awt.Graphics;
import reactgame.Game;
import static reactgame.services.GameStats.LEVEL_TIME;

/**
 *
 * @author User
 */
public class ShowTime implements Renderer{
    
    public static double curTime;
    
    public ShowTime(){
        curTime = LEVEL_TIME;
    }
        

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, (int) (curTime * Game.WIDTH / LEVEL_TIME), 10);        
    }

    @Override
    public void update() {
        curTime -= 0.1;        
    }
    
    public void rmk(){
        curTime = LEVEL_TIME;
    }
    
    
    
}
