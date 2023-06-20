package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Reactor extends AbstractActor {
    private int temperature; // private vidi len reaktor vlastnosti
    private boolean state; // nevidi ich ani materska trieda
    private int damage;
    private Animation normalAnimation;

    public Reactor() { // konstruktor nic nevracia preto ani void nepise
        this.temperature = 0;
        this.state = false;
        this.damage = 0;
        this.normalAnimation = new Animation("sprites/reactor_on.png", 80, 80, 0.1f, Animation.PlayMode.LOOP_PINGPONG); //prehrava obrazky 1,2,3,4,3,2,1;

        setAnimation(this.normalAnimation);
    }

    public int getTemperatur() {
        return this.temperature;
    }

    public int getDamage() {
        return this.damage;
    }

    public boolean getSate() {
        return this.state;
    }

    public void increaseTemperatur(int increment) {
        this.temperature = this.temperature + increment;
        if (this.temperature >= 2000 && this.temperature <= 6000) {
            int damage = this.temperature / 40 - 50;

            if (this.damage < damage) {
                this.damage = damage;
            }
        }
    }
}
