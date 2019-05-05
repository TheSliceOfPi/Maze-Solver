import java.util.ArrayList;


/**
 * Contains methods for the QueueAgenda.
 */
public class QueueAgenda extends Agenda
{
    ArrayList<Location> agenda;

    public QueueAgenda()
    {
        agenda=new ArrayList<Location>();
    }
     /**
     * Adds a Location to the Queue 
     *(Similar to enqueue() in Stack)
     * @return void
     */
    public void addLocation(Location value)
    {
	agenda.add(value);
    }
     /**
     * Removes a Location from the Queue
     * and returns the Location (Similar to dequeue() in Stack)
     *
     * @return Location
     */
    public Location getLocation()
    {
	return agenda.remove(0);
    }
     /**
     * Returns True if Queue is empty 
     * @return boolean
     */
    public boolean isEmpty()
    {
	return agenda.isEmpty();
    }
     /**
     * Removes everythin from the Queue 
     * @return void
     */
    public void clear()
    {
	agenda.clear();
    }
}
