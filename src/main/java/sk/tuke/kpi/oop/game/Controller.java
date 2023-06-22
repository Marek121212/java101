package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Controller extends AbstractActor {

    private Reactor reactor;


    public Controller(Reactor reactor) {
        // reactor ktory je za == sme priradili do premennej ktora je private
        // aby sme povedali ze dany controller ovlada dany reactor...
        this.reactor = reactor;
        Animation animation = new Animation("sprites/switch.png");
        setAnimation(animation);
    }
    public void toglle(){
        if(this.reactor.isRunning()){
            this.reactor.turnOff();
        }else {
            this.reactor.turnOn();
        }
    }
}
