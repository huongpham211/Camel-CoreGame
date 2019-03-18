package game.renderer;

import game.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Renderer {

    public static void drawImage(BufferedImage image, Graphics g, GameObject master){
        g.drawImage(image,
                (int) (master.position.x - master.anchor.x*image.getWidth()),
                (int)(master.position.y - master.anchor.y*image.getHeight()),
                null
        );
    }
    public static void drawString(String string,Font font, Color color, Graphics g, GameObject master){
        g.setFont(font);
        g.setColor(color);
        g.drawString(string, (int) master.position.x, (int) master.position.y);
    }

    public abstract void render(Graphics g, GameObject master);
}
