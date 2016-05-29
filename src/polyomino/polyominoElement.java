package polyomino;

import java.util.Scanner;

public abstract class polyominoElement {

	protected int[][] matrix;
	protected int lines;
	protected int columns;
	
	public polyominoElement(Scanner in){
		try{
			CreateMatrix(in);
		}catch(Exception e){
			System.out.print(e.toString()+"mauvais entree - only * and . allowed");
		}
	}
	
	public void CreateMatrix(Scanner in) throws Exception{//tested. working well
		//Scanner in = new Scanner(System.in);
		
		//read matrix dimensions
		columns = in.nextInt();
		lines   = in.nextInt();
		
		//create empty matrix
		matrix = new int[lines][columns];
		for(int i = 0; i < lines; i++){
			String thisLine = in.next();
			for (int j = 0; j < thisLine.length();j++)
			{
				char c = thisLine.charAt(j);
				if (c == '*')
					matrix[i][j] = 1;
				else if (c == '.')
					matrix[i][j] = 0;
				else{
					in.close();
					throw new Exception(); //TODO
				}
			}
		}
		//in.close();//TODO delete this line
	}
	
	public int getLines(){	return lines;  }
	public int getColumns(){return columns;}
	
	public int At(int i, int j){
		if (i<lines && j < columns)
			return matrix[i][j];
		else
			return -1;//TODO ou isso ou throw new excep.
	}

	public void print(){
		for(int i = 0; i < lines; i ++){
			for(int j = 0; j < columns; j++){
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
