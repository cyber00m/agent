package Agent.Model;

public interface Model {
    public void setAileron(float aileron);
    public void setElevator(float elevator);
    public void setRudder(float rudder);
    public void setThrottle(float throttle);
    public void setBreaks(float breaks);

    public float getAileron();
    public float getElevator();
    public float getRudder();
    public float getThrottle();
    public float getBreaks();
    ///get time series

}
