/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.tasks;

import java.awt.Color;
import java.util.Random;
import static reactgame.services.GameStats.GAME_HARDEST_LEVEL;
import static reactgame.services.GameStats.LEVEL_TIME;

/**
 *
 * @author Roman
 */
public class TrueTask {
    
    private int type;
    private int size;
    private Color color;
    
    public TrueTask(int type, int size, Color color){
        this.type = type;
        this.size = size;
        this.color = color;
    }
    
    public void rmk(int type){
        if(GAME_HARDEST_LEVEL < 10){
            GAME_HARDEST_LEVEL += new Random().nextInt(2);
        }
        if(LEVEL_TIME > 1.7){
            LEVEL_TIME -= 0.05;
        }
        this.type = type;
        if(size >= 70){
            this.size = size - new Random().nextInt(10);            
        }
        color = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
    }
    
    public int getType(){
        return type;
    }
    
    public int getSize(){
        return size;
    }
    
    public Color getColor(){
        return color;
    }
}
