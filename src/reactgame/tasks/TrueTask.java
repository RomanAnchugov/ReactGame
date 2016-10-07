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
import java.awt.event.MouseEvent;
import java.util.Random;
import static reactgame.Game.HEIGHT;
import static reactgame.Game.WIDTH;
import reactgame.services.GameStats;
import static reactgame.services.GameStats.GAME_HARDEST_LEVEL;
import static reactgame.services.GameStats.LEVEL_TIME;
import reactgame.services.Generator;
import reactgame.services.Renderer;
import static reactgame.services.Shape.CIRCLE;
import static reactgame.services.Shape.SQUARE;
import static reactgame.services.TaskType.COLOR;
import static reactgame.services.TaskType.DIGIT;
import static reactgame.services.TaskType.SHAPE;
import static reactgame.services.TaskType.SIZE;

/**
 *
 * @author Roman
 */
public class TrueTask extends MouseAdapter implements Renderer{
    
    private Generator generator;
    
    private int type;
    private int size;
    private Color color;
    
    private int posX;
    private int posY;
    
    private boolean clicked;
    
    //type = 1 - разные размеры
    private int sizeDifference;
    
    //type = 2 - разные числа
    private int digit;
    private Font font;
    
    //type = 3 - разные цвета
    //type = 4 - разные фигуры
    private int shape;
    
    
    public TrueTask(int type, int size, Color color, Generator generator){
        this.generator = generator;
        this.type = type;
        this.size = size;
        this.color = color;
        posX = new Random().nextInt(WIDTH - size);
        posY = new Random().nextInt(HEIGHT - size);
        
        // type - 1
        sizeDifference = new Random().nextInt(15) + 15;
        //type - 2
        digit = new Random().nextInt(100) - 50;
        font = new Font("sans", 1, 30); 
        //type -4
        shape = new Random().nextInt(2) + 1;
    }
    
    public void rmk(int type){
        if(GAME_HARDEST_LEVEL < 7){
            GAME_HARDEST_LEVEL += new Random().nextInt(100) % 2;
        }
        if(LEVEL_TIME > 1.5){
            LEVEL_TIME -= 0.05;
        }
        this.type = type;
        if(size >= 90){
            this.size = size - new Random().nextInt(5);            
        }
        color = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255));
        posX = new Random().nextInt(WIDTH - size);
        posY = new Random().nextInt(HEIGHT - size);
        if(type == SIZE){
            sizeDifference = new Random().nextInt(15) + 10;
        }else{
            sizeDifference = 0;
        }
        shape = new Random().nextInt(2) + 1;
        digit = new Random().nextInt(100) - 50;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getX() >= posX && e.getX() <= posX + size + sizeDifference &&
                e.getY() >= posY && e.getY() <= posY + size + sizeDifference){
                GameStats.SCORE++;
                clicked = true;
                generator.click();
        }else{
            clicked = false;
        }        
        
    }
       
    @Override
    public void render(Graphics g) {
        if(type == SIZE){
            g.setColor(color);
            g.fillOval(posX, posY, size + sizeDifference, size + sizeDifference);
        }
        if(type == DIGIT){
            g.setColor(color);
            g.fillOval(posX, posY, size, size);
            g.setColor(Color.white);
            g.setFont(font);            
            g.drawString(digit + "", posX + size / 2 - 15, posY + size / 2 + 15);
        }
        if(type == COLOR){
            g.setColor(color);
            g.fillOval(posX, posY, size, size);
        }
        if(type == SHAPE){
            g.setColor(color);
            if(shape == CIRCLE){
                g.fillOval(posX, posY, size, size);
            }else if(shape == SQUARE){
                g.fillRect(posX, posY, size, size);
            }
        }
    }

    @Override
    public void update() {
        
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
    public int getDigit(){
        return digit;
    }
    public Font getFont(){
        return font;
    }
    public boolean getClicked(){
        return clicked;
    }
    public int getShape(){
        return shape;
    }
    public void setClicked(boolean clicked){
        this.clicked = clicked;
    }
}
