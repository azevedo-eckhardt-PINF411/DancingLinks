//On  prendra  un  soin  particulier  en  ce  qui  concerne  la  modularite  du  code,  avec  une
// separation claire entre l'algorithme DLX et son application au probleme du pavage.

import java.util.Scanner;

public class DLX {

	/*l'algorithme DLX
	On  commencera  par  lire  soigneusement  l'article  de  Knuth.  La
	realisation de l'algorithme DLX devra permettre de parcourir toutes les solutions
	avec un iterateur.
	On deduira de cet iterateur des fonctions pour denombrer toutes
	les solutions, trouver une solution particuliere lorsqu'elle existe et renvoyer toutes
	les solutions.*/
	
	/*pavage
	Le programme devra permettre de decrire un probleme de pavage sur une grille
	2D, de denombrer ses solutions et d'acher une solution, le cas echeant.
	 */
	
	private static Header readMatrix(){
		//TODO Gabriel
		Header h = new Header();
		Scanner in = new Scanner(System.in);

		int primColumns = in.nextInt();
		int secColumns = in.nextInt();	
		int lines = in.nextInt();
		
		
		return h;
	}
	
	private static void cover(Element c){
		//TODO Francisco
	}
	
	private static void uncover(Element c){
		// TODO Francisco
	}
	
	private static void search(int k){
		// TODO Gabriel
	}
	
	private static void EMC(){
	// TODO chamar search zero.
		//Gabriel
	}
	
	private static void pavage2d(){
		
	}
	
	public static void solve(String s){

		if(s.equals("emc"))
			EMC();
		
		if(s.equals("pavage"))
			pavage2d();
	}
	
}
