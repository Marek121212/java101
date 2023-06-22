package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Reactor extends AbstractActor {
    private int temperature; // private vidi len reaktor vlastnosti
    private boolean state; // nevidi ich ani materska trieda
    private int damage;
    private Animation normalAnimation;
    private Animation normalAnimationHot;
    private Animation animationTurnOff;

    public Reactor() { // konstruktor nic nevracia preto ani void nepise
        this.temperature = 0;
        this.state = false;
        this.damage = 0;
        this.animationTurnOff = new Animation("sprites/reactor.png");

        this.normalAnimation = new Animation("sprites/reactor_on.png",
            80, 80, 0.1f,
            Animation.PlayMode.LOOP_PINGPONG); //prehrava obrazky 1,2,3,4,3,2,1;

        this.normalAnimationHot = new Animation("sprites/reactor_hot.png",
            80, 80, 0.1f,
            Animation.PlayMode.LOOP_PINGPONG);

        setAnimation(this.animationTurnOff);
        //nastavujem len normalAnimation / ostatne nie lebo ako sa ma zobrazit prvy obrazok
        //ak by som nastavil aj this.normalAnimationHot videl by som hned horuci obrazok...
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

    public void increaseTemperature(int increment) {
        if (increment < 0 || isRunning() == false) {
            return;
        }

        this.temperature = this.temperature + increment;
        // ak je poskodenie 100 uz ostane rozbity obrazok....
        if (this.damage == 100) {
            return;
        }
        // update animation
        // if temperature is >= 6000, then broken show reactor
        if (this.temperature >= 6000) {
            Animation animation = new Animation(
                "sprites/reactor_broken.png",
                80, 80, 0.1f,
                Animation.PlayMode.LOOP_PINGPONG
            );
            setAnimation(animation);
            // ak by som nechcel vytvarat novu triedu ako v podnmienke pred tak definujem
            // privat Animation normalAnimationHot a importujem don obrazok...
            // if (4000 <= temperature < 6000), then show hot reactor
        } else if (this.temperature >= 4000) {
            setAnimation(this.normalAnimationHot);

            // otherwise show normal reactor
        } else {
            setAnimation(this.normalAnimation);
        }
        //namiesto tych 3 podmienok hore tiez by som mohol metodu updateAnimation zavolat...

        if (this.temperature >= 2000) {
            if (this.temperature >= 6000) {
                this.damage = 100;
                this.state = false;
            } else {
                int damage = this.temperature / 40 - 50;
                if (this.damage < damage) {
                    this.damage = damage;
                }
            }
        }
    }

    public void decreaseTemperature(int decrease) {
        if (decrease < 0 || isRunning() == false) {
            return;
        }

        this.temperature = this.temperature - decrease;
        if (this.damage == 100) {
            return;
        }

        this.updateAnimation();//moze byt this aj nemusi byt this...
    }


    public void updateAnimation() { // ak by som dal nie public a private - tak uz to nemozem ovplyvnit cez inspektora
        if (this.temperature >= 6000) {
            Animation animation = new Animation(
                "sprites/reactor_broken.png",
                80, 80, 0.1f,
                Animation.PlayMode.LOOP_PINGPONG
            );
            setAnimation(animation);
            // ak by som nechcel vytvarat novu triedu ako v podnmienke pred tak definujem
            // privat Animation normalAnimationHot a importujem don obrazok...
            // if (4000 <= temperature < 6000), then show hot reactor
        } else if (this.temperature >= 4000) {
            setAnimation(this.normalAnimationHot);

            // otherwise show normal reactor
        } else {
            setAnimation(this.normalAnimation);
        }
    }

    public void repairWith(Hammer hammer) {
        //ak tam nieje kladivo koniec
        if (hammer == null) {
            return;
        }
        //nerob nic ked reaktor nieje poskodeny alebo je mrtvy

        if (this.damage == 0 || this.damage == 100) {
            return;
        }
        hammer.use();
        this.damage = this.damage - 50;

        if (this.damage < 0) {
            this.damage = 0;
        }
        this.temperature = 0;
        updateAnimation();
    }

    public void turnOn() {
        if(this.damage == 100){
            return;
        }
        this.state = true;
        if(this.temperature == 0){
            setAnimation(normalAnimation);
        }
        getAnimation().play();
    }

    public void turnOff() {
        if(this.damage == 0){
           return;
        }
        this.state = false;
        getAnimation().pause();

    }

    public boolean isRunning() {
        return this.state;
    }
}
