package hw7;

import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;

//Rebekah Hatcher

public class Solver {
    public static String solve(char[][] grid) {

        int start = 0;
        int finish = 0;
        int size = grid.length;
        Graph graph = new Graph(size*size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] != size - 1) {
                    int vertex = (i * size) + j;
                    if (j + 1 < size && grid[i][j] != '*' && grid[i][j + 1] != '*')
                        graph.addEdge(vertex, (vertex + 1));
                    if (i + 1 < size && grid[i][j] != '*' && grid[i + 1][j] != '*')
                        graph.addEdge(vertex, vertex + size);
                    if (grid[i][j] == 's')
                        start = vertex;
                    if (grid[i][j] == 'f') {
                    	finish = vertex;
                    }
                        
                }

            }
        }

        StringBuilder pathString = new StringBuilder();
        BreadthFirstPaths BFP = new BreadthFirstPaths(graph, start);
        Integer previ = null;
        Integer prevj = null;
        if (BFP.pathTo(finish) != null) {
        	for (int k : BFP.pathTo(finish)) {
        		int i = k / size;
        		int j = k % size;
        		if (previ != null && prevj != null) {
        			if (j == prevj + 1) {
        				pathString.append("R");
        	}  		if (j == prevj - 1) {
        				pathString.append("L");
        	}		if (i == previ + 1 ) {
        				pathString.append("D");        			
        	}		if (i == previ - 1) {
        				pathString.append("U");
        	}
        	}
        	previ = i;
        	prevj = j;
        }
		
        	return pathString.toString();
        }
        	return null;
    }
    
}
