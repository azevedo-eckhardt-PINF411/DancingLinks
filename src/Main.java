import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class Main {

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
				p1.solve("emc");
				System.out.println("(Reponse attendue: 2 solutions)");
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
				p2.solve("emc");
				System.out.println("(Reponse attendue: ?)");
				is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//read from tests/pavage/scott.txt
			try{
				is = new FileInputStream(new File("tests/pavage/scott.txt"));
				System.setIn(is);
				DLX p3=new DLX();
				p3.solve("pavage");
				System.out.println("(Reponse attendue: ??)");
				is.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		else{
			assert(args[1].equals("emc")||args[1].equals("pavage"));
			DLX problem= new DLX();
			problem.solve(args[1]);
		}
	}

}
