import java.util.Scanner;
import java.util.Stack;
public class Graph01 {
	public static void main (String []args ) {
		Scanner kb = new Scanner (System.in);
		int node = kb.nextInt();
		int parth = kb.nextInt();
		EdgeWeightedDigraph G = new EdgeWeightedDigraph(node+1);
		for(int i = 0;i<parth;i++) {
			G.addEdge(new DirectedEdge(kb.nextInt(), kb.nextInt(),kb.nextDouble()));
		}
		int start = kb.nextInt();
		DijkstraSP dij = new DijkstraSP(G,start);
		for(int i=1;i<node+1 ;i++) {
			Stack <DirectedEdge> st = dij.pathTo(i);
			if(!Double.isInfinite(dij.distTo(i))) {
			System.out.print(start+" to "+i+" ");
			System.out.printf("( %.2f",dij.distTo(i));	
			System.out.print("): "+start);
			while(!st.empty()) {
				DirectedEdge e = st.pop();
				
				System.out.print(" -> "+e.to());	
			}
			System.out.println();
			}
		}
		
	}
}

/*5 7
1 2 5
1 4 2
4 2 1
4 3 8
2 3 3
3 5 2
3 4 1
1*/