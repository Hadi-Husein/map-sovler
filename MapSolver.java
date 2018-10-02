package map;

import java.util.ArrayList;

import blocks.Block;
import blocks.ClosedBlock;
import blocks.GoalBlock;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MapSolver {
	
	static Map map;
	static int steps = 0;
	static boolean solution = false;
	
	static ArrayList<Circle> path = new ArrayList<Circle>();
	
	public MapSolver(int startX, int startY, Map map2) {
	}

	public static void Solver(Map map) {
		MapSolver.map = map;
		
		int startX = map.getStartX();
		int startY = map.getStartY();
		
		solve(startX, startY, 1); 
		solve(startX, startY, 2); 
		solve(startX, startY, 3); 
		solve(startX, startY, 4); 
		
		}
	
	public static void solve(int x, int y, int d) {
		
		Block b = map.getBlock(x, y);
		
		if (b instanceof GoalBlock) {
			solution = true;
			return;
		}
		
		if (b instanceof ClosedBlock || b == null || solution) {
			return;
			
		}
		
		double cirkelStorlek = Block.SIZE / 2;
		
		path.add(
				new Circle(x * Block.SIZE + cirkelStorlek, y * Block.SIZE + cirkelStorlek, cirkelStorlek, Color.GREEN));
	
			
			if (b instanceof GoalBlock) {
				
				System.out.println("Antal Steg " +steps);
			}
			
		steps++;
		if (d == 1) {
			solve(x, y - 1, 4);
			solve(x, y - 1, 2);
			solve(x, y - 1, 1);
		}
		
		if (d == 2) {
			solve(x + 1, y, 2);
			solve(x + 1, y, 1);
			solve(x + 1, y, 3);
		}
		
		if (d == 3) {
			solve(x, y + 1, 3);
			solve(x, y + 1, 4);
			solve(x, y + 1, 2);
		}
		
		if (d == 4) {
			solve(x - 1, y, 4);
			solve(x - 1, y, 1);
		}
			
	}

}
	
	
	
	
