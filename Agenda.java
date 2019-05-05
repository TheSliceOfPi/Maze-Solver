import java.util.ArrayList;

public abstract class Agenda
{
    protected ArrayList<Location> agenda;
    public abstract void addLocation(Location loc);
    public abstract Location getLocation();
    public abstract boolean isEmpty();
    public abstract void clear();


}
