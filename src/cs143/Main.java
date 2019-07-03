package cs143;
public class Main {

	public static void main(String[] args) {
		
	
		MazeSolver solver = new MazeSolver();

		
		
		solver.loadMaze("Maze2.txt");
		
		
		//print out maze as you go
		solver.solve(true);
		
		//do not print out maze as you go
		

		solver.printFinalMaze();
		

	}

}
