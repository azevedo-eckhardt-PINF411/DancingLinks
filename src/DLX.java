//On  prendra  un  soin  particulier  en  ce  qui  concerne  la  modularite  du  code,  avec  une
// separation claire entre l'algorithme DLX et son application au probleme du pavage.

import java.util.Scanner;

public class DLX {

	private static final Exception Error = null;

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
		Header h = new Header(null,null,null,null,null,-1,-1);// that`s the root
		Scanner in = new Scanner(System.in);

		int primColumns = in.nextInt();
		int secColumns = in.nextInt();	
		int lines = in.nextInt();
		int totalColumns = primColumns + secColumns;//TODO print those
		
		Element temp = h;//TODO trocar pra "Header" e criar funcao no Header. ou achar solucao melhor;
<<<<<<< HEAD
		//Creating Header`s list
		for(int i = 0; i < totalColumns; i++){
			temp.setRight(new Header(temp,h,null,null,h,0,i));// the headers point their c`s to the root. invariant: the list is circular
			temp = temp.getRight();
		}
		
		for(int i = 0; i < lines; i++){
			temp = h;
			Element tempLineHeader = new Header();
			//enquanto nao acabou a linha.
			while (!temp.getRight().equals(h))//TODO ou entao comparar os nomes
			{
				temp = temp.getRight();// acho que tem coisa errada aqui...
				int element = in.nextInt();
				if (element == 1) {
					tempLineHeader.addLeft(temp.addUp());

				}
				else if(element!=0) throw new Error;//TODO import java.Exception or error
=======
		h.setRight(h);
		h.setLeft(h);
							///updated; Gabriel, please check (TODO)
		//Creating Headers list
		for(int i = 0; i < totalColumns; i++){
			temp.setRight(new Header(temp,h,null,null,h,0,i));// the headers point their c`s to the root. invariant: the list is circular
			temp = temp.getRight();
			h.setLeft(temp); //update circular list: the root's left Elmt is always the latest added header
		}
		
		for(int i = 0; i < lines; i++){ ///
			temp = h.getRight(); //initialize in column 0
			int element = in.nextInt();
			boolean first=true;
			One o0 = new One();
			One o = new One();
			//enquanto nao acabou a linha.
			while (temp!=h)
			{
				element = in.nextInt();
				if (element == 1) {
					if(first){
						//add to the column
						//and then to the line
						temp.getUp().setDown(o0);
						o0.setUp(temp.getDown());
						o0.setLeft(o0);		//just in case there's only one 1 
						o0.setRight(o0);	//we already make the list circular
						first=false;
						o=o0;
					}
					else{
						//add to the horz
						//and vert circ lists
						//keeping the first elmt of the line to update
						//the horz circ list corresponding to current row
						o.setRight(new One(o,o0,temp.getUp(),temp,temp));	//"just like" we did for the headers
						o=(One)o.getRight();
						temp.getUp().setDown(o); 	//update "ends" 
						temp.setUp(o);				//of vertical circ list
						o0.setLeft(o);	//update end of horz circ list
					}
						
						

				}
				else if(element!=0) throw Error;//TODO import java.Exception or error		--corrected by removing new
				temp = temp.getRight();
>>>>>>> origin/master
			}
		}
		
		return h;
	}
	
	private static void cover(Element c){
		// c must be a header element
		//remove c-column from header list
		c.getLeft().setRight(c.right);
		c.getRight().setLeft(c.left);
		
		for(Element i=c.getDown(); i!=c; i=i.getDown()){ //remove row i
			for(Element j=i.getRight();j!=i; j=j.getRight()){
				j.getDown().setUp(j.getUp());
				j.getUp().setDown(j.getDown());
				((Header)j.getColumn()).decSize();
			}
		}
	}
	
	private static void uncover(Element c){
		// c must be a header element

		//add c-column to header list
		//here is where links do their dance
		for(Element i=c.getUp(); i!=c; i=i.getUp()){
			for(Element j=i.getLeft(); j!=i; j=j.getLeft()){
				((Header)j.getColumn()).incSize();
				j.getDown().setUp(j);
				j.getUp().setDown(j);
			}
		}
		c.getRight().setLeft(c);
		c.getLeft().setRight(c);
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
