package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Hammer extends AbstractActor {
    private int usages;
    // nemusim lebo len 1 obrazok - private Animation normalAnimation;

    public Hammer(){
        this.usages = 1;
        Animation animation = new Animation("sprites/hammer.png"); // automaticky si zisti rozmer ak je 1 obrazok nenastavujem
        setAnimation(animation);

    }
    public int getUsages(){
        return this.usages;
    }
}
