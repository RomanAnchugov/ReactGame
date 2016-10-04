/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.services;

/**
 *
 * @author Ольга
 */
public class GameStats {
    public static int GAME_STATE = 2;//1 menu, 2 - play
    public static int GAME_HARDEST_LEVEL = 1;
    public static double LEVEL_TIME = 5;   
    public static boolean LOSE = true;
    
    public static void reset(){
        GAME_HARDEST_LEVEL = 1;
        LEVEL_TIME = 5;        
    }
}
