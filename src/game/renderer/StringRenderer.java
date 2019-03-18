package game.renderer;

import game.GameObject;

import java.awt.*;

public class StringRenderer extends Renderer {
    public String string;
    public Font font;
    public Color color;

    public StringRenderer(String string,Font font,Color color){
        this.string = string;
        this.color = color;
        this.font = font;
    }
    @Override
    public void render(Graphics g, GameObject master){
        Renderer.drawString(string,font,color,g,master);
    };
}
