package game;



import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Background background;
//    Player player;
    MultiPlayer multiPlayer;


    public GamePanel() {
        Background background = new Background();
//        Player player = new Player("Player 1");
        MultiPlayer multiPlayer = new MultiPlayer();


    }

    public void gameLoop() {
        long lastTime = 0;
        long delay = 1000 / 60;
        while(true) {
            long currentTime = System.currentTimeMillis();
            if(currentTime - lastTime >= delay) {
                runAll();
                renderAll();
                lastTime = currentTime;
            }
        }
    }

    private void renderAll() {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        // ve anh
        for(int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.render(g);
            }
        }
    }

    private void runAll() {
        for(int i = 0; i < GameObject.objects.size(); i++) {
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.run();
            }
        }
    }
}
