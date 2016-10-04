/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reactgame.menu;

import java.util.Random;
import reactgame.services.GameStats;
import reactgame.services.ShowTime;
import reactgame.tasks.FakeTask;
import reactgame.tasks.TrueTask;

/**
 *
 * @author Roman
 */
public class PlayBtn extends Btn{

    TrueTask trueTask;
    FakeTask fakeTask;
    ShowTime showTime;
    
    public PlayBtn(int width, int height, int posX, int posY, String text, TrueTask trueTask, FakeTask fakeTask, ShowTime showTime) {
        super(width, height, posX, posY, text);
        this.trueTask = trueTask;
        this.fakeTask = fakeTask;
        this.showTime = showTime;
    }

    @Override
    public void click() {
        GameStats.reset();
        GameStats.LOSE = false;        
        trueTask.rmk(new Random().nextInt(4) + 1);
        fakeTask.rmk();
        showTime.rmk();
        
    }
    
}
