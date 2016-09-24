/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.services;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ольга
 */
public class Generator implements Runnable{

    private boolean generation = false;
    private Random r;
    
    public Generator(){        
        start();
    }
    
    public void start(){
        generation = true;
        new Thread(this).start();
    }
    
    public void init(){
        r = new Random();
    }
    
    public void generate(int r){
        switch(r){
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            default:
                System.out.println("def");
                break;
        }
    }
    
    @Override
    public void run() {
        init();
        while(generation){
            try {
                Thread.sleep((long) GameStats.LEVEL_TIME * 1000);
                generate(r.nextInt(4) + 1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Generator.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
