package Agent.Model;

import Agent.Model.Model;

import java.util.Observable;

public class myModel extends Observable implements Model {

    private float aileron, elevator, rudder, throttle, breaks;

    @Override
    public void setAileron(float aileron) {
        this.aileron=aileron;
        setChanged();
        notifyObservers("aileron");
    }

    @Override
    public void setElevator(float elevator) {
        this.elevator=elevator;
        setChanged();
        notifyObservers("elevator");
    }

    @Override
    public void setRudder(float rudder) {
        this.rudder=rudder;
        setChanged();
        notifyObservers("rudder");
    }

    @Override
    public void setThrottle(float throttle) {
        this.throttle=throttle;
        setChanged();
        notifyObservers("throttle");
    }

    @Override
    public void setBreaks(float breaks) {
        this.breaks=breaks;
        setChanged();
        notifyObservers("breaks");
    }

    @Override
    public float getAileron() {
        return this.aileron;
    }

    @Override
    public float getElevator() {
        return this.elevator;
    }

    @Override
    public float getRudder() {
        return this.rudder;
    }

    @Override
    public float getThrottle() {
        return this.throttle;
    }

    @Override
    public float getBreaks() {
        return this.breaks;
    }



}
