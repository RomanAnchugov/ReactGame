/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.menu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import reactgame.services.Renderer;

/**
 *
 * @author Roman
 */
public class BestScore implements Renderer{

    private int posX, posY;
    private Font font;
    private String score;
    
    public BestScore(int posX, int posY, int size){
        Scanner sc;
        try {            
            sc = new Scanner(new File("bestResult.txt"));
            score = sc.nextLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BestScore.class.getName()).log(Level.SEVERE, null, ex);
        }
        font = new Font("sans", 1, size);   
        this.posY = posY;
        this.posX = posX;        
    }
    
    @Override
    public void render(Graphics g) {
        g.setColor(new Color(215,204,200));
        g.setFont(font);        
        g.drawString("Лучший результат - " + score, posX, posY);
        
    }

    @Override
    public void update() {
        
    }
    public void setScore(String score){        
        this.score = score;
    }
    
}
