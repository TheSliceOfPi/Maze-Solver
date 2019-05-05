import java.util.ArrayList;

/**
 * Contains methods for the StackAgenda.
 */
public class StackAgenda extends Agenda
{
    public StackAgenda()
    {
	agenda =new ArrayList<Location>();
    }
    /**
     * Adds a Location to the stack (end of the ArrayList) (Similar to push() in Stack)
     * @return void
     */
    public  void addLocation(Location loc)
    {
	agenda.add(loc);
    }
    /**
     * Removes a Location from the stack (end of the ArrayList) 
     * and returns the Location (Similar to pop() in Stack)
     *
     * @return Location
     */
    public Location getLocation()
    {
	return agenda.remove(agenda.size()-1);
    }
    /**
     * Returns True if stack is empty (Similar to Empty() in Stack)
     * @return boolean
     */
    public boolean isEmpty()
    {
	return agenda.size()==0;
    }
    /**
     * Removes everythin from the Stack (Similar to clear in ArrayList)
     * @return void
     */
    public void clear()
    {
	agenda.clear();
    }
}
