
public class Main {

	static boolean debug=true;
	public static void main(String[] args) {
		if(debug){
			//read from tests/emc/sujet.txt
			
			DLX.solve("emc");
			System.out.println("(Reponse attendue: 2)");
			
			//read from tests/emc/knuth.txt
			
			DLX.solve("emc");
			System.out.println("(Reponse attendue: ?");
			
			//read from tests/pavage/scott.txt
			
			DLX.solve("pavage");
			System.out.println("(Reponse attendue: ?");
		}
		
		else{
			assert(args[1].equals("emc")||args[1].equals("pavage"));
			DLX.solve(args[1]);
		}
	}

}
