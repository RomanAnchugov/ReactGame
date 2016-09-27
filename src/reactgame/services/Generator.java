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
import reactgame.tasks.Size;

/**
 *
 * @author Ольга
 */
public class Generator implements Runnable, Renderer{

    private boolean generation = false;
    private Random r;
    private Game game;
    
    private ArrayList<Size> list;
    
    public Generator(Game game){        
        this.game = game;
        start();
        
    }
    
    public void start(){
        generation = true;
        new Thread(this).start();
    }
    
    public void init(){
        r = new Random();
        list = new ArrayList<Size>();
    }
    
    public void generate(int r){
//        switch(r){
//            case 1:
//                System.out.println("1");
//                break;
//            case 2:
//                System.out.println("2");
//                break;
//            case 3:
//                System.out.println("3");
//                break;
//            case 4:
//                System.out.println("4");
//                break;
//            default:
//                System.out.println("def");
//                break;
//        }
        Size size = new Size(Shape.CIRCLE, new Color(188,170,164), 30, 30);
        game.addMouseListener(size);
        list.add(size);        
    }
    
    @Override
    public void run() {
        init();
        while(generation){
            try {
                Thread.sleep((long) (GameStats.LEVEL_TIME * 1000));
                generate(r.nextInt(4) + 1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       
    }

    @Override
    public void render(Graphics g) {
        for(int i = 0; i < list.size(); i++){
            list.get(i).render(g);
        }
    }

    @Override
    public void update() {
        
    }
    
}
