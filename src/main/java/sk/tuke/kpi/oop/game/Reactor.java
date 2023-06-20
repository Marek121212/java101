package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Reactor extends AbstractActor {
    private int temperature; // private vidi len reaktor vlastnosti
    private boolean state; // nevidi ich ani materska trieda
    private int damage;
    private Animation normalAnimation;

    public Reactor(){ // konstruktor nic nevracia preto ani void nepise
        temperature = 0;
        state = false;
        damage = 0;
        normalAnimation = new Animation("sprites/reactor_on.png",80,80,0.1f, Animation.PlayMode.LOOP_PINGPONG); //prehrava obrazky 1,2,3,4,3,2,1;

        setAnimation(normalAnimation);
    }
}
