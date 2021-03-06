/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.tasks;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Random;
import static reactgame.Game.HEIGHT;
import static reactgame.Game.WIDTH;
import static reactgame.services.GameStats.*;
import reactgame.services.Point;
import reactgame.services.Renderer;
import static reactgame.services.Shape.CIRCLE;
import static reactgame.services.Shape.SQUARE;
import static reactgame.services.TaskType.*;

/**
 *
 * @author Roman
 */
public class FakeTask implements Renderer{
 
    private int type;
    private TrueTask trueTask;
    private ArrayList<Point> coords;
    private Color color;     
    
    //type 2;
    private Font font;
    private int digitDifference;
    //type 4    
    
    public FakeTask(TrueTask trueTask){        
        this.trueTask = trueTask;
        this.type = trueTask.getType();
        this.font = trueTask.getFont();
        digitDifference = new Random().nextInt(10) + 10;
        coords = new ArrayList<Point>();
        if(type != COLOR){
            this.color = trueTask.getColor();
        }else{
            do{
                this.color = new Color(new Random().nextInt(), new Random().nextInt(), new Random().nextInt());
            }while(this.color == trueTask.getColor());
        }
        for(int i = 0; i < GAME_HARDEST_LEVEL + 2; i++){
            coords.add(new Point(new Random().nextInt(WIDTH - trueTask.getSize()), new Random().nextInt(HEIGHT - trueTask.getSize())));
        }        
    }

    public void rmk(){
        this.type = trueTask.getType();  
        digitDifference = new Random().nextInt(10) + 3;        
        if(type != COLOR){
            this.color = trueTask.getColor();
        }else{
            this.color = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
        }        
        
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
            if(type == DIGIT){
                for(int i = 0; i < coords.size(); i++){  
                    g.setColor(color);
                    g.fillOval(coords.get(i).getPosX(), coords.get(i).getPosY(), trueTask.getSize(), trueTask.getSize());
                    g.setColor(Color.white);
                    g.setFont(font);            
                    g.drawString((trueTask.getDigit() + digitDifference) + "", coords.get(i).getPosX() + trueTask.getSize() / 2 - 15, coords.get(i).getPosY() + trueTask.getSize() / 2 + 15);
                }
            }
            if(type == COLOR){
                for(int i = 0; i < coords.size(); i++){  
                    g.setColor(color);
                    g.fillOval(coords.get(i).getPosX(), coords.get(i).getPosY(), trueTask.getSize(), trueTask.getSize());                    
                }
            }
            if(type == SHAPE){
                if(trueTask.getShape() == CIRCLE){
                    for(int i = 0; i < coords.size(); i++){  
                        g.setColor(color);
                        g.fillRect(coords.get(i).getPosX(), coords.get(i).getPosY(), trueTask.getSize(), trueTask.getSize());                    
                    }
                }else if(trueTask.getShape() == SQUARE){
                    for(int i = 0; i < coords.size(); i++){  
                        g.setColor(color);
                        g.fillOval(coords.get(i).getPosX(), coords.get(i).getPosY(), trueTask.getSize(), trueTask.getSize());                    
                    }
                }
            }
        }
    }

    @Override
    public void update() {
        
    }
    
    
}
