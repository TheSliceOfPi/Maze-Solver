Edith Flores
Maze Solver

Files Included:
Agenda.java
blankMaze.txt
fastqueue.txt
faststack.txt
Location.java
Maze.java
mazefile.txt
mazefile1.txt
mazefil2.txt
MazeGUI.java
MazeSolver.java
QueueAgenda.java
Square.java
StackAgenda.java
README.txt

#Compile: javac SolveMaze.java
#Run: java SolveMaze <Filename of the Maze you want to solve> <Which data structure you want to use s (stack) or q (queue)>

Maze solver is a Java program that solves a given maze using either Stack or Queue data structures.
The first line of the maze file will contain the number of rows and the number of columns separated by a space. The rest of the file will specify the maze layout, one row of the maze per line, using the following characters to mark different components of the maze:
•walls: # (hash mark)
•open spaces: . (period)
•start: o (lowercase 'O')
•goal: * (asterisk)
We are assuming there is only one start and only one goal.

