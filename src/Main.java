import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import polyomino.*;
//import polyomino.piece;


public class Main {
	static long startTime,elapsedTime;
	
	public static void print(int [][] m){
		for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m[0].length; j++)
				System.out.print(m[i][j]+" ");
			System.out.println();
		}
	}
	
	

	static boolean debug=true;
	public static void main(String[] args){
		if(debug){
			FileInputStream is = null;
			//read from tests/emc/sujet.txt
			try{
				is = new FileInputStream("tests/emc/sujet.txt");
				System.setIn(is);
				/*
				Scanner in = new Scanner(System.in);
				System.out.println(in.nextInt()+", "+in.nextInt());
				in.close();*/
				DLX p1=new DLX();
				startTime=System.currentTimeMillis();
				p1.solve("emc");
				elapsedTime=System.currentTimeMillis();
				System.out.println("(Reponse attendue: 2 solutions)");
				System.out.println("Elapsed time: "+ (elapsedTime-startTime));
				is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//read from tests/emc/knuth.txt
			try{
				is = new FileInputStream(new File("tests/emc/knuth.txt"));
				System.setIn(is);
				DLX p2 = new DLX();
				startTime=System.currentTimeMillis();
				p2.solve("emc");
				elapsedTime=System.currentTimeMillis();
				System.out.println("(Reponse attendue: ?)");
				System.out.println("Elapsed time: "+ (elapsedTime-startTime));
				is.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//read from tests/pavage/scott.txt
			try{
				is = new FileInputStream(new File("tests/pavage/tetris_5_8.txt"));
				System.setIn(is);
				DLX p3=new DLX();
				startTime=System.currentTimeMillis();
				p3.solve("pavage");
				elapsedTime=System.currentTimeMillis();
				System.out.println("(Reponse attendue: ??)");
				System.out.println("Elapsed time: "+ (elapsedTime-startTime));
				is.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try{
				is = new FileInputStream("tests/pavage/pentaminos_3_20.txt");
				System.setIn(is);
				
				DLX p4 = new DLX();
				startTime=System.currentTimeMillis();
				p4.solve("pavage");
				elapsedTime=System.currentTimeMillis();
				System.out.println("(Reponse attendue: ??)");
				System.out.println("Elapsed time: "+ (elapsedTime-startTime));				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			/*try{
				is = new FileInputStream("tests/pavage/tetris_5_8.txt");
				System.setIn(is);
				
				DLX p5 = new DLX();
				p5.solve("pavage");
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}*/
			
		}
		
		else{
			assert(args[1].equals("emc")||args[1].equals("pavage"));
			DLX problem= new DLX();
			problem.solve(args[1]);
		}
	}

}
