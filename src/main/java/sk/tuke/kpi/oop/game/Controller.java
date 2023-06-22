package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Controller extends AbstractActor {

    private Reactor reactor;


    public Controller(Reactor reactor) {
        // reactor ktory je za == sme preradili do premennej ktora je private
        // aby sme povedali ze dany controller ovlada dany reactor...
        this.reactor = reactor;
        Animation animation = new Animation("sprites/switch.png");
        setAnimation(animation);
    }
}
