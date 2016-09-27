/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import reactgame.services.Generator;

/**
 *
 * @author Roman
 */
public class Game extends Canvas implements Runnable{

    public static boolean running = false;
    public static String NAME = "ReactGame";
    public static int WIDTH = 700;
    public static int HEIGHT = 500;
    
    private Generator generator;
    
    public static void main(String[] args) {
        Game game = new Game();
	game.setPreferredSize(new Dimension(Game.WIDTH, Game.HEIGHT));

	JFrame frame = new JFrame(Game.NAME);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //выход из приложения по нажатию клавиши ESC
	frame.setLayout(new BorderLayout());
	frame.add(game, BorderLayout.CENTER); //добавляем холст на наш фрейм
	frame.pack();
	frame.setResizable(false);
        frame.setLocationRelativeTo(null);
	frame.setVisible(true);

	game.start();
    }

    private void start(){
        running = true;
        new Thread(this).start();        
    }
    
    private void init(){
        generator = new Generator(this);
    }
    
    private void update(){
        
    }
    
    private void render(){
        
        BufferStrategy bs = getBufferStrategy(); 
	if (bs == null) {
		createBufferStrategy(2); //создаем BufferStrategy для нашего холста
		requestFocus();
		return;
	}
		
	Graphics g = bs.getDrawGraphics(); //получаем Graphics из созданной нами BufferStrategy
	g.setColor(new Color(62,39,35)); //выбрать цвет - 900
	g.fillRect(0, 0, getWidth(), getHeight()); //заполнить прямоугольник 
        //render
        generator.render(g);       
        //render
	g.dispose();
	bs.show(); //показать        
    }
    
    @Override
    public void run() {
        init();
        while(running){
            render();
            update();            
            try {
                Thread.sleep(1000 / 60);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
    
    
    
}
