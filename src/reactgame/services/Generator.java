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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import reactgame.Game;
import static reactgame.Game.HEIGHT;
import static reactgame.Game.WIDTH;
import reactgame.menu.BestScore;
import reactgame.menu.Btn;
import reactgame.menu.HelpTxt;
import reactgame.menu.PlayBtn;
import static reactgame.services.GameStats.LEVEL_TIME;
import static reactgame.services.GameStats.LOSE;
import static reactgame.services.GameStats.SCORE;
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
        
    
    //ui menu
    private PlayBtn btnPlay;
    private HelpTxt helpText;
    private BestScore bestScore;
    
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
                
        
        trueTask = new TrueTask(2, 100, new Color(134, 124, 255), this);//type color size generator        
        fakeTask = new FakeTask(trueTask);
        
        showTime = new ShowTime();
        
        btnPlay = new PlayBtn(150, 60, WIDTH / 2 - 75, HEIGHT / 2 - 30, "PLAY", trueTask, fakeTask, showTime);
        helpText = new HelpTxt("Выбирай лишнее", 150, 70, 48);//str posX posY size
        bestScore = new BestScore(250, 350, 18);//posX posY size
        
        game.addMouseListener(trueTask);
        game.addMouseListener(this);
        game.addMouseListener(btnPlay);
    }
    
    public void generate(int r){
        trueTask.rmk(r);
        fakeTask.rmk();
        showTime.rmk();
    }
    
    public void click() {           
        trueTask.setClicked(false);
        generate(r.nextInt(4) + 1);//generate(r.nextInt(4) + 1);
        curLevelTime = LEVEL_TIME;
    }
            
    @Override
    public void run() {
        init();
        while(generation){ 
            System.out.println("reactgame.services.Generator.run()");
            try {    
                if(!LOSE){                    
                    curLevelTime = LEVEL_TIME;
                    while(curLevelTime > 0){//Уменьшение полоски                                                
                        curLevelTime -= 0.1;
                        showTime.update();
                        Thread.sleep(100);
                    }  
                    if(curLevelTime <= 0 && !trueTask.getClicked()){
                        bestScore.setScore(SCORE + "");
                        GameStats.LOSE = true;   
                        BufferedWriter wr = new BufferedWriter(new FileWriter("bestResult.txt"));
                        wr.write(SCORE + "");
                        wr.close();                        
                    }         
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }

    @Override
    public void render(Graphics g) { 
        if(!LOSE){            
            fakeTask.render(g);
            showTime.render(g);
            trueTask.render(g);
        }
        if(LOSE){
           btnPlay.render(g);
           helpText.render(g);
           bestScore.render(g);
        }                
    }

    @Override
    public void update() {
        helpText.update();
    }
    
}
