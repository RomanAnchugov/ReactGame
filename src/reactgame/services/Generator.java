/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.services;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import reactgame.Game;
import static reactgame.services.GameStats.LEVEL_TIME;
import reactgame.tasks.FakeTask;
import reactgame.tasks.TrueTask;

/**
 *
 * @author Ольга
 */
public class Generator extends MouseAdapter implements Runnable, Renderer{

    private boolean generation = false;
    private Random r;
    private Game game;
    private Thread thread;
    private double curLevelTime;
    
    private TrueTask trueTask;
    private FakeTask fakeTask;
    private ShowTime showTime;
        
    
    public Generator(Game game){ 
        this.game = game;
        init();        
        start();
        
    }
    
    public void start(){
        generation = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public void init(){
        r = new Random(); 
        
        trueTask = new TrueTask(1, 100, new Color(134, 124, 255), this);//type color size generator
        game.addMouseListener(trueTask);
        game.addMouseListener(this);
        fakeTask = new FakeTask(trueTask);
        
        showTime = new ShowTime();
    }
    
    public void generate(int r){
        trueTask.rmk(r);
        fakeTask.rmk();
        showTime.rmk();
    }
    
    public void click() {           
        trueTask.setClicked(false);
        generate(r.nextInt(2) + 1);//generate(r.nextInt(4) + 1);
        curLevelTime = LEVEL_TIME;
    }
            
    @Override
    public void run() {
        init();
        while(generation){
            try {                
                if(!GameStats.LOSE){                                        
                    curLevelTime = LEVEL_TIME;
                    while(curLevelTime > 0){//Уменьшение полоски                                                
                        curLevelTime -= 0.1;
                        showTime.update();
                        Thread.sleep(100);
                    }  
                    if(curLevelTime <= 0 && !trueTask.getClicked()){
                        GameStats.LOSE = true;                        
                    }
                }else{                                   
                    System.out.println("reactgame.services.Generator.run() - LOSE");
                    generation = false;
                    thread.interrupt();
                }
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }

    @Override
    public void render(Graphics g) { 
        if(!GameStats.LOSE){            
            fakeTask.render(g);
            showTime.render(g);
            trueTask.render(g);
        }
        
    }

    @Override
    public void update() {
        
    }
    
}
