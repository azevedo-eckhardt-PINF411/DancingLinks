import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//import java.util.ArrayList;
import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;

//import polyomino.*;
import DataStructureElements.*;


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
				System.out.println("Test number 1 ......");
				is = new FileInputStream("../tests/emc/sujet.txt");
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
				System.out.println("(Reponse obtenue:  " + p1.nSolutions() + ")");	
				p1.printSolutions();
				System.out.println("(Verification des sorties donne : " + p1.checkSolutions() + ")");
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
				System.out.println("Test number 2 ......");
				is = new FileInputStream(new File("../tests/emc/knuth.txt"));
				System.setIn(is);
				DLX p2 = new DLX();
				startTime=System.currentTimeMillis();
				p2.solve("emc");
				elapsedTime=System.currentTimeMillis();
				System.out.println("(Reponse attendue: 1)");
				System.out.println("(Reponse obtenue:  " + p2.nSolutions() + ")");
				p2.printSolutions();
				System.out.println("(Verification des sorties donne : " + p2.checkSolutions() + ")");
				System.out.println("Elapsed time: "+ (elapsedTime-startTime));
				is.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//read from tests/pavage/scott.txt
			try{
				System.out.println("Test number 3 ......");
				is = new FileInputStream(new File("../tests/pavage/tetris_5_8.txt"));
				System.setIn(is);
				Pavage p3=new Pavage();
				startTime=System.currentTimeMillis();
				p3.solve();
				elapsedTime=System.currentTimeMillis();
				System.out.println("(Reponse attendue: 99392)");
				System.out.println("(Reponse obtenue:  " + p3.nSolutions() + ")");
				System.out.println("(Verification des sorties donne : " + p3.checkSolutions() + ")");
				System.out.println("Elapsed time: "+ (elapsedTime-startTime));
				is.close();
				
				p3.showSolution(p3.getSolutions().get(0));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			try{
				System.out.println("Test number 4 ......");
				is = new FileInputStream("../tests/pavage/pentaminos_3_20.txt");
				System.setIn(is);

				Pavage p4=new Pavage();
				startTime=System.currentTimeMillis();
				p4.solve();
				elapsedTime=System.currentTimeMillis();
				System.out.println("(Reponse attendue: 8)");
				System.out.println("(Reponse obtenue:  " + p4.nSolutions() + ")");
				System.out.println("(Verification des sorties donne : " + p4.checkSolutions() + ")");
				System.out.println("Elapsed time: "+ (elapsedTime-startTime));
				
				int i = 0;
				for(LinkedList<Element> sol : p4.getSolutions()){
					p4.showSolution(sol);
					System.out.println("now viewing solution number " + ++i + "........");
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			/*try{
				is = new FileInputStream("../tests/pavage/tetris_5_8.txt");
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
