import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileNotFoundException;

/**
 * Contains information about the Maze (i.e., the grid of squares).
 * 
 */

public class Maze
{
    protected int numRows;
    protected int numCols;
    protected Location [][] maze;
    protected Location startLoc;
    protected Location goalLoc;
    protected HashMap<Location, String> writtenMaze= new HashMap<Location,String>();
    protected String str="";

 /**
     * Reads a file containing information about
     * the grid setup.  Initializes the grid
     * and other instance variables for use by
     * MazeGUI and other pieces of code.
     *
     *@param fileName the file containing the Maze grid information
     */
    public Maze(String fileName) throws FileNotFoundException
    {
	File file= new File(fileName);
	Scanner input = new Scanner(file);
	this.numRows=input.nextInt();
	this.numCols=input.nextInt();
	this.maze=new Location[numRows][numCols];
	int i=-1;
	String skip=input.nextLine(); //Skip the newline between the col and row number and the actual maze info for Maze map purpose.
	while (input.hasNextLine())
	    {
	        String line=input.nextLine();
		Scanner lineScanner= new Scanner(line);
		lineScanner.useDelimiter("");
		
		while (lineScanner.hasNext())
		    {
			i++;
	    
				for(int j=0;j<numCols;j++)
				    {
					String q=lineScanner.next();
					Location newLoc =new Location(i,j);
					if (q.equals("o")) //Start
					    {
						
						startLoc= newLoc;
						maze[i][j]=startLoc;
					        writtenMaze.put(startLoc,q); 
						str=str+q;
					    }

					else if (q.equals("*"))//Goal
					    {
					        
						goalLoc= newLoc;
						maze[i][j]=goalLoc;
					        writtenMaze.put(goalLoc,q); 
						str=str+q;
					       
					    }
					else 
					    {
					        maze[i][j]=newLoc;
					        writtenMaze.put(newLoc,q); 
						str=str+q;
					        
					    }
				      
				        
				    } 
				str=str+"\n";
		    }     
	    }
	//Closes Scanner
	input.close();
    }
	
    /**
     * @return int, the number of columns in the Maze
     */
    public int getNumColumns()
    {
	return numCols;
    }
     /**
     * @return int, the number of rows in the Maze
     */
    public int getNumRows()
    {
	return numRows;
    }
    /**
     * @return Location, the Location of Start.
     */
    public Location getStartLocation()
    {
	return startLoc;
    }
     /**
     * @return Location, the Location of Goal.
     */
    public Location getGoalLocation()
    {
	return goalLoc;
    }
    /**
     * Returns a specific location based on the given row and column
     *
     * @param r the row
     * @param c the column
     *
     * @return Location
     */
    public Location getMazeLocation(int r, int c)
    {
	return maze[r][c];
    }
     /**
     * @parameter Location.
     * @return Character, the character on a given Location.
     */
    public Character getSquare(Location ch)
    {
	String str=writtenMaze.get(ch);
        char spot=str.charAt(0);
	
	return spot;
    }
    /**
     * Returns a map of the Maze as a String.
     *
     * @return String
     */
    public String toString()
    {
	return str;
    }
}
