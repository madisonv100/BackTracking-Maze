package cs143;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MazeSolver {

	// public Position marked = X;

	private char[][] printMaze;
	private char[][] solveMaze;

	private Position start;
	private Position finish;

	private class Position {

		int x;
		int y;

		Position(int x, int y) {
			this.x = x;
			this.y = y;

		}

	}

	public MazeSolver() {
		super();

	}

	private boolean solveMaze(boolean printUpdates) {
		boolean solve = false;

		Stack<Position> stack = new Stack<Position>();
		Position current = new Position(start.x, start.y);
		while (!solve) {
			boolean moved = false;

			for (Direction d : Direction.values()) {

				if (solveMaze[current.x + d.getDeltaX()][current.y + d.getDeltaY()] == ' ') {
					solveMaze[current.x][current.y] = d.getMapChar();
					current.x += d.getDeltaX();
					current.y += d.getDeltaY();

					stack.push(new Position(current.x, current.y));

					if (printUpdates) {
						printMaze(solveMaze);
					}
					moved = true;

				} else if (solveMaze[current.x + d.getDeltaX()][current.y + d.getDeltaY()] == 'F') {
					current = new Position(current.x + d.getDeltaX(), current.y + d.getDeltaY());
					stack.push(current);
					return true;

				}

			}
			if (!moved) {
				
				solveMaze[current.x][current.y] = 'X';
				 stack.pop();

				current.x = stack.top().x;
				current.y = stack.top().y;
				System.out.println("Back Track");
			}

		}

		return true;

	}

	public boolean solve(boolean printUpdates) {

		return solveMaze(printUpdates);
	}

	public boolean solve() {
		return solveMaze(false);
	}

	public void printFinalMaze() {
		printMaze(solveMaze);

	}

	private void printMaze(char[][] maze) {
		for (int i = 0; i < maze.length; i++) {
			for (int u = 0; u < maze[i].length; u++) {
				System.out.print(maze[i][u]);

			}
			System.out.println();

		}
	}

	public boolean loadMaze(String filename) {
		// if you want to load different mazes you may need to reset some things
		BufferedReader br = null;
		FileReader fr = null;
		ArrayList<String> lines = new ArrayList<String>();
		try {

			fr = new FileReader(filename);
			br = new BufferedReader(fr);
			String line;
			br = new BufferedReader(new FileReader(filename));

			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			printMaze = new char[lines.size()][];
			solveMaze = new char[lines.size()][];
			for (int i = 0; i < lines.size(); i++) {
				printMaze[i] = new char[lines.get(i).length()];
				solveMaze[i] = new char[lines.get(i).length()];

				for (int j = 0; j < lines.get(i).length(); j++) {
					solveMaze[i][j] = lines.get(i).charAt(j);
					printMaze[i][j] = lines.get(i).charAt(j);
					if (printMaze[i][j] == 'S') {
						start = new Position(i, j);

					}
					if (printMaze[i][j] == 'F') {
						finish = new Position(i, j);

					}
					// hint you may want to check for something here
					// what two things do you need to have...

				}

			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (br != null)
					br.close();

				if (fr != null)
					fr.close();

			} catch (IOException ex) {

				return false;

			}

		}
		// printFinalMaze();

		return true;
	}

	public Position getStart() {
		return start;

	}

	public Position getFinish() {
		return finish;

	}

}
