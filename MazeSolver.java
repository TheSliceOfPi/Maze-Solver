import java.util.ArrayList;


 /**
  * Contains steps to solve the Maze
  **/
public class MazeSolver
{
    Agenda agenda=null;
    ArrayList <Location> path= new ArrayList <Location>(); //Final path
    ArrayList<Location> trash= new ArrayList<Location>(); //Everything "Added"
    Location[][] look; //Attached Location to the Location that added it to Agenda.
    MazeGUI gui; //Graphics

    public MazeSolver(Agenda agenda) //Constructor
    {
	if (agenda instanceof StackAgenda)
	    {
		this.agenda=agenda;
	    }
	else if (agenda instanceof QueueAgenda)
	    {
		this.agenda=agenda;
	    }
    }
     /**
     * Solves the Maze, if solution exist returns the path, 
     * and return empty ArrayList if unsolvable.
     * @parameter Maze
     * @return ArrayList
     */
    public ArrayList<Location> solveMaze(Maze maze,MazeGUI gui)
    {
	look= new Location[maze.getNumRows()][maze.getNumColumns()];
	this.gui=new MazeGUI(maze);
	agenda.clear();
	agenda.addLocation(maze.getStartLocation());

	while(agenda.isEmpty()==false)
	    {
		Location item=agenda.getLocation();
		trash.add(item);
		gui.pause();
		gui.visitLoc(item);
		if(maze.getSquare(item)=='*') //Provides the path once solved.
		    {
			Location posPath =trash.get(trash.size()-1);
			path.add(0,posPath);
			gui.addLocToPath(posPath);
			trash.remove(posPath);
				while (posPath!=maze.getStartLocation())
				    {
					posPath=look[posPath.getRow()][posPath.getColumn()];
					path.add(0,posPath);
					gui.addLocToPath(posPath);
				    }
					
			return path;
		    }
		else // Continues to look for the goal.
		    {
		
			if (item.getRow()+1<maze.getNumRows()) //check bottom side of the Location
			    {
				Location bottom=maze.getMazeLocation(item.getRow()+1,item.getColumn());
				if (trash.contains(bottom)==false && maze.getSquare(bottom)!='#') //Checks if wall, or if already added
				    {
					agenda.addLocation(bottom);
					look[item.getRow()+1][item.getColumn()]=item;
					trash.add(bottom);
					gui.addLocToAgenda(bottom);
				        
				    }
			    }
			
		        if (item.getRow()-1>=0)//check top side of the Location
			    {
				Location top=maze.getMazeLocation(item.getRow()-1,item.getColumn());
				if (trash.contains(top)==false && maze.getSquare(top)!='#')//Checks if wall, or if already added
				    {
					
					agenda.addLocation(top);
					look[item.getRow()-1][item.getColumn()]=item;
					trash.add(top);
					gui.addLocToAgenda(top);
				    }
			    }

		   	if (item.getColumn()+1 < maze.getNumColumns())//check right side of the Location
			    {
				Location right=maze.getMazeLocation(item.getRow(),item.getColumn()+1);
				if (trash.contains(right)==false  && maze.getSquare(right)!='#')//Checks if wall, or if already added
				    {
					agenda.addLocation(right);
					look[item.getRow()][item.getColumn()+1]=item;
					trash.add(right);
					gui.addLocToAgenda(right);
				    }
			    }

			if (item.getColumn()-1>=0) //check left side of the Location
			    {
				Location left=maze.getMazeLocation(item.getRow(),item.getColumn()-1);
				if (trash.contains(left)==false && maze.getSquare(left)!='#')//Checks if wall, or if already added
				    {
				        
					agenda.addLocation(left);
				        
					look[item.getRow()][item.getColumn()-1]=item;
					trash.add(left);
					gui.addLocToAgenda(left);
				    }
			    }

		    }
	    }
	return path;//If solveMaze reaches this point, path will be empty.
    }
    
}
