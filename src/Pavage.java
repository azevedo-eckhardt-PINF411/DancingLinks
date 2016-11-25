import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.sound.sampled.Line;

import polyomino.board;
import polyomino.piece;
import DataStructureElements.*;


public class Pavage {
	DLX dlx;
	int[][] m;
	board b;
	
	public Pavage(){dlx = new DLX();}
	
	public void solve(){//convert pavage in a EMC and then solve the EMC
		Scanner in = new Scanner(System.in);
		
		b = new board(in);	
		//b.print();

		List<piece> pList = new ArrayList<piece>();
		int listSize = in.nextInt();
		int o = 0;
		while(in.hasNext() && o < listSize){
			pList.add(new piece(in));
			//pList.get(o++).print();
			//System.out.println();
		}
		
		m = b.polyoToEMC(pList);
		//print m (converted matrix)
		/*for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m[0].length; j++)
				System.out.print(m[i][j]+" ");
			System.out.println();
		}*/
	
		dlx.solve(m);
		
		in.close();
	}
	
	public boolean checkSolutions(){return dlx.checkSolutions();}
	public int nSolutions(){return dlx.nSolutions();}
	public List<LinkedList<Element>> getSolutions(){return dlx.getSolutions();}
	
	public void showSolution(LinkedList<Element> sol){
		int[] LinesFormingASol = new int[sol.size()];
		
		//replace the sol by a list of the lines forming a solution
		int i = 0;
		for(Element el : sol )
			LinesFormingASol[i++] = ((One)el).getLine();
		
		Frame frame = new Frame(m,LinesFormingASol, b.getLines(),b.getColumns());
		new Thread(frame).start();
	}
}
