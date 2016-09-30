/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.services;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import reactgame.Game;
import reactgame.tasks.FakeTask;
import reactgame.tasks.TrueTask;

/**
 *
 * @author Ольга
 */
public class Generator implements Runnable, Renderer{

    private boolean generation = false;
    private Random r;
    private Game game;
    private Thread thread;
    
    private TrueTask trueTask;
    private FakeTask fakeTask;
        
    
    public Generator(Game game){        
        this.game = game;
        start();
        
    }
    
    public void start(){
        generation = true;
        thread = new Thread(this);
        thread.start();
    }
    
    public void init(){
        r = new Random(); 
        
        trueTask = new TrueTask(1, 100, new Color(134, 124, 255));//type color size
        fakeTask = new FakeTask(trueTask);
    }
    
    public void generate(int r){
        trueTask.rmk(r);
        fakeTask.rmk();
    }
    
    @Override
    public void run() {
        init();
        while(generation){
            try {                
                if(!GameStats.LOSE){                    
                    Thread.sleep((long) (GameStats.LEVEL_TIME * 1000));
                    generate(1);//generate(r.nextInt(4) + 1);
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
        fakeTask.render(g);
    }

    @Override
    public void update() {
        
    }
    
}
