package polyomino;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class piece extends polyominoElement{
	
	public piece(Scanner in){super(in);}
	
	public piece(int lin, int col){
		lines=lin;
		columns=col;
		matrix=new int[lin][col];
	}
	
	public boolean equals(piece p){//1 iff same piece same orientation
		if(lines!=p.lines || columns!=p.columns)
			return false;
		else{
			for(int l=0;l<lines;l++)
				for(int c=0;c<columns;c++)
					if(matrix[l][c]!=p.matrix[l][c])
						return false;
			
			return true;
		}	
	}
	
	private piece mirror(){
		piece mirrored= new piece(lines,columns);
		for(int i=0;i<lines;i++)
			for(int j=0;j<columns;j++)
				mirrored.matrix[i][j]=matrix[i][columns-(j+1)];
		return mirrored;
	}
	
	private piece rot90(){///conferir
		piece rot=new piece(columns,lines);
		for(int i=0;i<lines;i++)
			for(int j=0; j<columns; j++)
				rot.matrix[columns-1-j][i]=matrix[i][j];
		return rot;
	}
	
	public List<piece> rotations(){//create possible orientations for piece p
		List<piece> rotations= new ArrayList<piece>();
		Collection<piece> rots = new HashSet<piece>(8);
		rots.add(this);
		
		piece other=rot90();		
		for(int i=0;i<3;i++,other=other.rot90()){
			rots.add(other);
		}
		
		other=mirror();
		for(int i=0;i<4;i++,other=other.rot90()){
			rots.add(other);
		}
		
		for(piece P : rots)
			rotations.add(P);
		
		return rotations;
	}
}
