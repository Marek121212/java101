package sk.tuke.kpi.oop.game;

import sk.tuke.kpi.gamelib.framework.AbstractActor;
import sk.tuke.kpi.gamelib.graphics.Animation;

public class Light extends AbstractActor {
    private Animation lightOff;
    private Animation lightOn;

    private boolean isOn;

    private boolean isPowered;

    public Light() {
        this.isOn = false;
        this.lightOff = new Animation("sprites/light_off.png");
        this.lightOn = new Animation("sprites/light_on.png");

        setAnimation(lightOff);
    }

    public void toogle() {
        if (this.isOn) {
            this.isOn = false;
            setAnimation(lightOff);
        } else {
            this.isOn = true;
            setAnimation(lightOn);
        }

    }
    //alebo
    //this.isOn = !this.isOn;
    //} if(this.isOn){
      //  setAnimation(lightOn);
    //}else{
    //setAnimation(lightoff);
   // }
    //alebo ternarna operacia
//    this.isOn = !this.isOn;
//    setAnimation(this.isOn ? lighOff lightOn)

    public void setElectricityFlow(boolean isPowered){
        this.isPowered = isPowered;
    }
}

