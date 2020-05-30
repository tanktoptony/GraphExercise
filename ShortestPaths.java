package Graphs;

import algs4.StdOut;
import algs4.BreadthFirstPaths;
import algs4.Graph;
import algs4.Queue;
import algs4.StdIn;
import myalgs4.*;

// Author: Anthony Jarina

public class ShortestPaths {

	public static void main(String[] args) {
		
		// 1. Read in VertexNumbers file
		StdIn.fromFile("data/VertexNumbers.txt");
		int[] vertices = StdIn.readAllInts();
		
		// 2. Create Graph Object
		Graph G = new Graph(vertices.length);
		
		// 3. Reads in Edges file
		StdIn.fromFile("data/Edges.txt");
		int[] edges = StdIn.readAllInts();
		
		// 4. Add an edge between two vertices
		for(int i = 0; i < edges.length; i+=2) {
			G.addEdge(edges[i], edges[i+1]);
		}
		
		// 5. Read in PathQuery file
		StdIn.fromFile("data/PathQuery.txt");
		while(!StdIn.isEmpty()) {
			int[] paths = StdIn.readAllInts();
			for (int j = 0; j < paths.length; j+=2) {
				int u = paths[j];
				int v = paths[j+1];
				// Create new BFP object
				BreadthFirstPaths B = new BreadthFirstPaths(G, u);
				
				
				Boolean pathExists = B.hasPathTo(v);
				
				if(pathExists == true) {
					StdOut.println(u + " connected to " + v + "?" + " Yes, by the path " + B.pathTo(v));
				} else {
					StdOut.println(u + " connected to " + v + "? No!");
				}
				
			}
			
		}
	}

}
