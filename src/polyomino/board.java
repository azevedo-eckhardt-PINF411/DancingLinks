package polyomino;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class board extends polyominoElement{
	int emcColumns;
	
	public board(Scanner in){super(in);}	
	
	private int coordToColumn(int i, int j){
		return columns*i+j;
	}
	
	private boolean possibleToInclude(int i,int j ,piece p){
		// if surpasses the table limits
		if(i + p.getLines() > lines || j + p.getColumns() > columns)
			return false;
		
		//if touches one of the holes inside the board
		int plin = p.getLines();
		int pcol   = p.getColumns();
		
		for(int k = 0 ; k < plin; k++)
			for(int l = 0; l < pcol;l++)
				if(p.At(k, l) == 1 && matrix[i+k][j+l] == 0)
					return false;
		return true;
	}
	
	private int[] pieceToLine(int i,int j ,piece p, int id){ //create a line for the (new) matrix
		if(possibleToInclude(i, j, p))// that is, if the piece does not invade a hole, or goes outside the board
		{
		int [] line = new int[emcColumns];
		
		int pcol = p.getColumns();
		int plin = p.getLines();
		
		//adding piece`s elements to the line
		for (int k = 0; k < plin; k++)
			for(int l = 0; l < pcol; l++)
				if(p.At(k,l) == 1)
					line[coordToColumn(i+k, j+l)] = 1;
		
		//adding piece`s id to the line
		line[columns*lines +id] = 1;
		
		return line;
		}
		else return null; // or throw exception TODO
	}
	
	private int[] holeLine(){
		int[] r = new int[emcColumns];
		for(int i = 0; i < lines; i++)
			for(int j = 0; j < columns; j++)
				if(matrix[i][j] == 0)
					r[coordToColumn(i, j)] = 1;
				else
					r[coordToColumn(i, j)] = 0;
		return r;
	}
	
	public int[][] polyoToEMC(List<piece> pList){
		//creates the matrix that makes the polyo problem a subproblem of the emc
		
		//matrix columns: first, all the points of b, second on column to each piece
		emcColumns = lines*columns + pList.size();
		//converter x, y em coluna
		
		List<int[]> m = new ArrayList<int[]>();
		
		int id = 0;
		for(piece p : pList){
			for(int i = 0; i < lines; i++)
				for ( int j = 0; j < columns; j++)
				{
					int [] temp = pieceToLine(i, j, p,id);
					if (temp != null)
						m.add(temp);
				}
			id++;
		}
		
		m.add(holeLine());//adding a last line with all the holes on the board
		
		int [][] M = m.toArray(new int[0][]);
		return M;
	}
	
	public int[][] emcToData(int[][] m){
		
		int [][] r = new int[m.length][3];
		for(int i = 0; i < m.length; i++)//TODO esse m.length pode dar bug!
		{
			int iPiece = lines;
			int jPiece = columns;
			for(int j = 0; j < columns*lines;j++)
				if(m[i][j] == 1){
					iPiece = i < iPiece? i : iPiece;
					jPiece = j < jPiece? j : jPiece;
				}
			r[i][0] = iPiece;
			r[i][1] = jPiece;
			
			boolean foundId = false;
			for(int j = columns*lines; j<emcColumns && !foundId;j++)
				if(m[i][j] == 1)
				{
					foundId = true;
					r[i][2] = j - columns*lines;
				}	
		}		
		return r;
	}
	
	
}
