package game;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MultiPlayer extends GameObject {
    int diceCount;
    int scoreBoard;
    ArrayList<Player> players  = new ArrayList<Player>();
    int currentPlayerIndex;
    String playerName;
    int diceValue;
    boolean switchingPlayer;
    int switchPlayerCount;
    boolean gameEnd;

    public MultiPlayer(){
        this.players.add(new Player("Player 1"));
        this.players.add(new Player("Player 2"));
        this.players.add(new Player("Player 3"));
        diceCount = 0;
        currentPlayerIndex = 0;
        this.scoreBoard = 0;
        switchingPlayer = false;
        switchPlayerCount = 0;
        gameEnd = false;
    }

    @Override
    public void run(){
        super.run();
        gameRun();
        switchPlayer();
    }


    private void gameRun() {
        if (!gameEnd) {
            if (currentPlayerIndex >= players.size()) {
                currentPlayerIndex = 0;
            } else {
                this.scoreBoard = players.get(currentPlayerIndex).point;
                this.playerName = players.get(currentPlayerIndex).name;
                diceCount++;
                if (GameWindow.isDicePress && diceCount > 30 ) {
                    Random rand = new Random();
                    int n = rand.nextInt(3) + 1;
                    this.diceValue = n;
                    players.get(currentPlayerIndex).setPoint(n);
                    this.scoreBoard = players.get(currentPlayerIndex).point;
                    diceCount = 0;
                    if (players.get(currentPlayerIndex).point >= 20) {
                        gameEnd = true;
                        this.scoreBoard = players.get(currentPlayerIndex).point;
                        this.playerName = players.get(currentPlayerIndex).name;
                    } else {
                        switchingPlayer = true;
                    }
                }
            }
        }
    }


//                while (!isDice()){
//                    Random rand = new Random();
//                    int n = rand.nextInt(3) + 1;
//                    players.get(currentPlayerIndex).setPoint(n);
//                    this.scoreBoard = players.get(currentPlayerIndex).point;
//                    diceCount=0;
//                    players.get(currentPlayerIndex).deactive();
//                    currentPlayerIndex++;
//                }

//        this.scoreBoard = this.player.point;
//        diceCount++;
//        if(GameWindow.isDicePress && diceCount>30){
//            Random rand = new Random();
//            int n = rand.nextInt(3) + 1;
//            player.setPoint(n);
//            this.scoreBoard = player.point;
//            diceCount=0;
//        }

    private void switchPlayer() {
        if(switchingPlayer) {
            switchPlayerCount++;
            if(switchPlayerCount > 60) {
                diceValue = 0;
                switchPlayerCount = 0;
                switchingPlayer = false;
                currentPlayerIndex++;
            }
        }
//        switchPlayerCount++;
//        if(switchingPlayer && switchPlayerCount >60){
//            diceValue=0;
//            switchPlayerCount=0;
//            switchingPlayer = false;
//            currentPlayerIndex++;
//        }
    }


    @Override
    public void render(Graphics g) {
        super.render(g);
        g.setFont(new Font("Verdana",Font.BOLD,20));
        if(this.scoreBoard >= 20){
            g.drawString(this.playerName+" Win with "+this.scoreBoard,200,200);
        } else {
            g.setColor(Color.red);
            g.drawString("Player point " + this.scoreBoard,200,200);
            g.drawString(playerName,200,300);
            g.drawString("Dice value " + diceValue,200,500);
        }
    }

}
