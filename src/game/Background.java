package game;

import game.renderer.SingleImageRenderer;
import tklibs.SpriteUtils;


public class Background extends GameObject {

    public Background() {
        this.renderer = new SingleImageRenderer(SpriteUtils.loadImage("assets/images/Game-Background.png"));
        this.position.set(0, 0);
        this.anchor.set(0,0);
    }

    @Override
    public void run() {
        super.run(); // == this.position.add(this.velocity.x, this.velocity.y);
        if(position.y > 0) { // limit background
            position.y = 0;
        }
    }
}
