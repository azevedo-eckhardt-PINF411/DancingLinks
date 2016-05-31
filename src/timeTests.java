import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class timeTests {

	static long startTime,elapsedTime;
	static boolean debug=true;
	public static void main(String[] args) {
			String[] emc={"emc/knuth.txt","emc/queens1.txt","emc/queens2.txt","emc/queens3.txt","emc/queens4.txt","emc/queens5.txt","emc/queens6.txt","emc/queens7.txt","emc/sujet.txt"};
			String[] pavage={"pavage/chessboard2.txt","pavage/chessboard4.txt","pavage/mutilated_chessboard4.txt","pavage/pentaminos_3_20.txt","pavage/scott.txt","pavage/tetris_4_10.txt","pavage/tetris_5_8.txt"};
			long[] emcTimes=new long[emc.length], pavTimes=new long[pavage.length];
			int[] emcSol=new int[emc.length],pavSol=new int[pavage.length];
			for(int i=0;i<emc.length;i++){
				FileInputStream is = null;
				try{
					is = new FileInputStream("tests/"+emc[i]);
					System.setIn(is);
					/*
					Scanner in = new Scanner(System.in);
					System.out.println(in.nextInt()+", "+in.nextInt());
					in.close();*/
					DLX p1=new DLX();
					startTime=System.currentTimeMillis();
					p1.solve("emc");
					elapsedTime=System.currentTimeMillis();
					emcSol[i]=p1.nSolutions();
					emcTimes[i]=elapsedTime-startTime;
					is.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int i=0;i<pavage.length;i++){
				FileInputStream is = null;
				try{
					is = new FileInputStream("tests/"+pavage[i]);
					System.setIn(is);
					/*
					Scanner in = new Scanner(System.in);
					System.out.println(in.nextInt()+", "+in.nextInt());
					in.close();*/
					DLX p1=new DLX();
					startTime=System.currentTimeMillis();
					p1.solve("pavage");
					elapsedTime=System.currentTimeMillis();
					pavSol[i]=p1.nSolutions();
					pavTimes[i]=elapsedTime-startTime;
					is.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			for(int i=0;i<emc.length;i++){
				System.out.println("File: "+emc[i]);
				System.out.println("Number of solutions: "+emcSol[i]);
				System.out.println("Elapsed time: "+emcTimes[i]+"ms");
				System.out.println();
			}
			
			for(int i=0;i<pavage.length;i++){
				System.out.println("File: "+pavage[i]);
				System.out.println("Number of solutions: "+pavSol[i]);
				System.out.println("Elapsed time: "+pavTimes[i]+"ms");
				System.out.println();
			}
	}

}
