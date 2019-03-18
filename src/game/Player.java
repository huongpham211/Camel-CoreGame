package game;

import game.renderer.StringRenderer;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {
    public int point;
    public String name;
    public int diceCount;

    public Player(String name){
        this.position.set(200,300);
        this.name = name;
        this.point = 0;
        this.diceCount = 0;
//        this.renderer = new StringRenderer(this.name,font,Color.red);
    }

    public void setPoint(int point){
        this.point += point;
    }


//    private void dice() {
////        while (true){
////
////            if(this.point >= 20){
////                break;
////            }
////        }
//        diceCount++;
//        if(GameWindow.isDicePress && diceCount > 30) {
//            Random rand = new Random();
//            int n = rand.nextInt(4) + 1;
//            this.point += n;
//            diceCount = 0;
//        }
//    }
}
