/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.tasks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Random;
import static reactgame.Game.HEIGHT;
import static reactgame.Game.WIDTH;
import static reactgame.services.GameStats.*;
import reactgame.services.Point;
import reactgame.services.Renderer;
import static reactgame.services.TaskType.*;

/**
 *
 * @author Roman
 */
public class FakeTask extends MouseAdapter implements Renderer{
 
    private int type;
    private TrueTask trueTask;
    private ArrayList<Point> coords;
    private Color color; 
    
    public FakeTask(TrueTask trueTask){        
        this.trueTask = trueTask;
        this.type = trueTask.getType();
        coords = new ArrayList<Point>();
        if(type != 4){
            this.color = trueTask.getColor();
        }else{
            this.color = new Color(new Random().nextInt(), new Random().nextInt(), new Random().nextInt());
        }
        for(int i = 0; i < GAME_HARDEST_LEVEL + 2; i++){
            coords.add(new Point(new Random().nextInt(WIDTH - trueTask.getSize()), new Random().nextInt(HEIGHT - trueTask.getSize())));
        }        
    }

    public void rmk(){
        this.type = trueTask.getType();        
        color = trueTask.getColor();
        coords.clear();
        for(int i = 0; i < GAME_HARDEST_LEVEL + 2; i++){
            coords.add(new Point(new Random().nextInt(WIDTH - trueTask.getSize()), new Random().nextInt(HEIGHT - trueTask.getSize())));
        }
    }
    
    @Override
    public void render(Graphics g) {
        if(!LOSE){
            if(type == SIZE){
                for(int i = 0; i < coords.size(); i++){  
                    g.setColor(color);
                    g.fillOval(coords.get(i).getPosX(), coords.get(i).getPosY(), trueTask.getSize(), trueTask.getSize());
                }
            }
        }
    }

    @Override
    public void update() {
        
    }
    
}
