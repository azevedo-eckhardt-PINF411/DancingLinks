//On  prendra  un  soin  particulier  en  ce  qui  concerne  la  modularite  du  code,  avec  une
// separation claire entre l'algorithme DLX et son application au probleme du pavage.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;

import polyomino.board;
import polyomino.piece;
import DataStructureElements.*;

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
	2D, de denombrer ses solutions et d'afficher une solution, le cas echeant.
	 */
	
	private List<LinkedList<Element>> solutions;
	private  Header h;
	private  LinkedList<Element> Olist;
	private int totalColumns;
	
	public DLX(){
		solutions= new ArrayList<LinkedList<Element>>();
		h=null;
		Olist= new LinkedList<Element>();
		totalColumns = 0;
	}
	
	public int nSolutions(){
		return solutions.size();
	}
	/*
	//never used
	private Header readMatrix(){
		//this function reads the matrix from the standard input (from the buffer, using System.in)
		//and then builds the data structure suggested in Knuth`s article
		Header h = new Header(null,null,null,null,null,-1,-1);// that`s the root
		Scanner in = new Scanner(System.in);
		
		int primColumns = in.nextInt();
		int secColumns = in.nextInt();	
		int lines = in.nextInt();
		totalColumns = primColumns + secColumns;
		
		Header temp = h;

		h.setRight(h);
		h.setLeft(h);
		h.setUp(h);
		h.setDown(h);
		h.setColumn(h);

		//Creating Headers list
		for(int i = 0; i < totalColumns; i++){
			temp.setRight(new Header(temp,h,null,null,null,0,i));
			temp = (Header)temp.getRight();
			temp.setDown(temp);
			temp.setUp(temp);
			temp.setColumn(temp);
			h.setLeft(temp); //update circular list: the root's left Elmt is always the latest added header
		}
		
		for(int i = 0; i < lines; i++){ ///
			temp = (Header)h.getRight(); //initialize in column 0
			String line = in.next();
			int element;
			boolean first=true;
			Element o0 = new One(i);
			Element o = new One(i);
			int c=0;

			while (temp!=h){//filling primary columns
				if(line.charAt(c++)=='0')
					element=0;
				else element=1;
				if (element == 1) {
					if(first){
						//add to the column
						//and then to the line
						temp.getUp().setDown(o0);
						o0.setUp(temp.getUp());
						o0.setLeft(o0);		//just in case there's only one 1 
						o0.setRight(o0);	//we already make the list circular
						o0.setDown(temp);
						o0.setColumn(temp);
						temp.setUp(o0);
						temp.incSize();
						first=false;
						o=o0;
					}
					else{
						//add to the horz
						//and vert circ lists
						//keeping the first elmt of the line to update
						//the horz circ list corresponding to current row
						o.setRight(new One(o,o0,temp.getUp(),temp,temp,i));	//"just like" we did for the headers
						o=(One)o.getRight();
						temp.getUp().setDown(o); 	//update "ends" 
						temp.setUp(o);				//of vertical circ list
						temp.incSize();
						o0.setLeft(o);	//update end of horz circ list
					}
				}
				temp = (Header)temp.getRight();
			}
		}
		
		//correct secondary columns' headers
		temp=(Header)h.getLeft();
		for(int i=0; i<secColumns;i++){
			temp.setRight(temp);
			temp=(Header)temp.getLeft();
			temp.getRight().setLeft(temp.getRight());
		}
		temp.setRight(h);
		h.setLeft(temp);
		
		in.close();
		return h;
	}
	*/
	private Header readMatrix(int[][] m){
		//this function takes a matrix as input
		//and then builds the data structure suggested in knuth`s article
		Header h = new Header(null,null,null,null,null,-1,-1);// that`s the root
		
		int primColumns = (m.length > 0)? m[0].length:0;
		int secColumns = 0;
		int lines =  m.length;
		totalColumns = primColumns + secColumns;
		
		Header temp = h;

		h.setRight(h);
		h.setLeft(h);
		h.setUp(h);
		h.setDown(h);
		h.setColumn(h);

		//Creating Headers list
		for(int i = 0; i < totalColumns; i++){
			temp.setRight(new Header(temp,h,null,null,null,0,i));
			temp = temp.getRight();
			temp.setDown(temp);
			temp.setUp(temp);
			temp.setColumn(temp);
			h.setLeft(temp); //update circular list: the root's left Elmt is always the latest added header
		}
				
		for(int i = 0; i < lines; i++){ ///
			temp = h.getRight(); //initialize in column 0
			
			//String line = in.next();
			int [] line = m[i];
			int element;
			boolean first=true;
			Element o0 = new One(i);
			Element o = new One(i);
		//	int c=0;

			int j = 0;
			//enquanto nao acabou a linha.
			while (temp!=h)
			{
				if(line[j++]== 0 )
					element=0;
				else element=1;
				if (element == 1) {
					if(first){
						//add to the column
						//and then to the line
						temp.getUp().setDown(o0);
						o0.setUp(temp.getUp());
						o0.setLeft(o0);		//just in case there's only one 1 
						o0.setRight(o0);	//we already make the list circular
						o0.setDown(temp);
						o0.setColumn(temp);
						temp.setUp(o0);
						temp.incSize();
						first=false;
						o=o0;
					}
					else{
						//add to the horz
						//and vert circ lists
						//keeping the first elmt of the line to update
						//the horz circ list corresponding to current row
						o.setRight(new One(o,o0,temp.getUp(),temp,temp,i));	//"just like" we did for the headers
						o = o.getRight();
						temp.getUp().setDown(o); 	//update "ends" 
						temp.setUp(o);				//of vertical circ list
						temp.incSize();
						o0.setLeft(o);	//update end of horz circ list
					}
				}
				//else if(element!=0) throw new Error;//TODO import java.Exception or error

				temp = temp.getRight();
			}
		}
		//correct secondary columns' headers
				temp=h.getLeft();
				for(int i=0; i<secColumns;i++){
					temp.setRight(temp);
					temp = temp.getLeft();
					temp.getRight().setLeft(temp.getRight());
				}
				temp.setRight(h);
				h.setLeft(temp);
				
		
		return h;
	}
	
	private static void cover(Element c){
		// c must be a header element
		//remove c-column from header list
		c.getLeft().setRight(c.getRight());
		c.getRight().setLeft(c.getLeft());
		
		for(Element i=c.getDown(); i!=c; i=i.getDown()){ //remove row i
			for(Element j=i.getRight();j!=i; j=j.getRight()){
				j.getDown().setUp(j.getUp());
				j.getUp().setDown(j.getDown());
				j.getColumn().decSize();
			}
		}
	}
	
	private static void uncover(Element c){
		// c must be a header element
		//add c-column to header list
		//here is where links do their dance
		for(Element i=c.getUp(); i!=c; i=i.getUp()){
			for(Element j=i.getLeft(); j!=i; j=j.getLeft()){
				j.getColumn().incSize();
				j.getDown().setUp(j);
				j.getUp().setDown(j);
			}
		}
		c.getRight().setLeft(c);
		c.getLeft().setRight(c);
	}

	/*private static void printColumn(Element c){//tested
		for (Element temp = c.getDown(); c!=temp;temp = temp.getDown())
			System.out.print(((One)temp).getLine()+ " ");
		System.out.println();
	}*/
	
	private static void printRow(Element r){
		//while(((Header)r.getLeft().getColumn()).name<((Header)r.getColumn()).name)/////
		//	r=r.getLeft();//////
		System.out.print(r.getColumn().getname()+ " ");
		for (Element temp = r.getRight(); !temp.equals(r); temp = temp.getRight())
			System.out.print(temp.getColumn().getname()+ " ");
		System.out.println();
	}
	
	private void printSolution(List<Element> sol){
		System.out.println("Printing solution:");
		ListIterator<Element> listIt = sol.listIterator();
        while (listIt.hasNext()) {
        	One o = (One) listIt.next();
        	System.out.print("Line " + o.getLine() + ": ");
        	printRow(o);
        }
	}
	
	public void printSolutions(){
		ListIterator<LinkedList<Element>> listIterator = solutions.listIterator();
        while (listIterator.hasNext()) {
        	printSolution(listIterator.next());
        }
	}
	
	private Header chooseAColumn(){
		int s=Integer.MAX_VALUE;
		Header c=null;
		for(Header j=h.getRight(); j!=h;j=j.getRight()){
			if(j.getSize()<s){
				c=j;
				s=j.getSize();
			}
		}
		return c;
	}
	
	private void addSolution(){
		@SuppressWarnings("unchecked")
		LinkedList<Element> sol = (LinkedList<Element>)Olist.clone();
		
		ListIterator<Element> listIt= sol.listIterator();
		Element O = listIt.next();
		while(listIt.hasNext()){
			while(O.getLeft().getColumn().getname() < O.getColumn().getname())
				O=O.getLeft();
			listIt.set(O);
			O=listIt.next();
		}
			
		solutions.add(sol);
	}
	
	private void search(int k){
		Element Ok = null;
		if(h.getRight().equals(h)) {
			addSolution();
			return;
		}
		
		Header c = chooseAColumn();
		cover(c);
		
		//go down in the column
		for(Element r = c.getDown(); !r.equals(c); r = r.getDown()){
			Ok = r;
			Olist.add(r);
			for(Element j = r.getRight();!j.equals(r);j = j.getRight())
				cover(j.getColumn());
			search(k+1);
			Olist.pollLast();
			r = Ok;
			c = r.getColumn();
			for(Element j = r.getLeft();!j.equals(r);j = j.getLeft())
				uncover(j.getColumn());
		}
		uncover(c);
	}
	
	private void EMC(){

		Scanner in = new Scanner(System.in);
		
		int primColumns = in.nextInt();
		int secColumns = in.nextInt();	
		int lines = in.nextInt();
		totalColumns = primColumns + secColumns;
		
		int[][] m = new int[lines][totalColumns];
		
		for(int i = 0; i < lines; i++){
			String line = in.next();
			for(int j = 0; j < totalColumns; j++)
				if(line.charAt(j)=='1')
					m[i][j] = 1;
		}
		h = readMatrix(m);
		Olist = new LinkedList<Element>();
		search(0);
		in.close();
	}
	
	private void EMC(int[][] m){
		h = readMatrix(m);
		Olist = new LinkedList<Element>();
		search(0);
	}
	
	private void pavage2d(){
		Scanner in = new Scanner(System.in);
		
		board b = new board(in);	
		//b.print();

		List<piece> pList = new ArrayList<piece>();
		int listSize = in.nextInt();
		int o = 0;
		while(in.hasNext() && o < listSize){
			pList.add(new piece(in));
			//pList.get(o++).print();
			//System.out.println();
		}
		
		int [][] m = b.polyoToEMC(pList);
		//print m (converted matrix)
		/*for(int i = 0; i < m.length; i++){
			for(int j = 0; j < m[0].length; j++)
				System.out.print(m[i][j]+" ");
			System.out.println();
		}*/
		// in case one want to use the function ReadMatrix() instead
		//of ReadMatrix(int [][]m) (which would much more time!) 
		/*int lin = m.length;
		int cols = (lin > 0 ? m[0].length : 0);
		String s = cols + "\n0\n" + lin+ "\n";
		
		for(int i=0;i < lin;i++){
			for(int j = 0; j < cols; j++)
				s += m[i][j];
			s+="\n";
		}
	
		InputStream stream = new ByteArrayInputStream(s.getBytes());
		System.setIn(stream);*/
	
		solve(m);
		
		in.close();
	}
	
	public void solve(String s){
		if(s.equals("emc"))
			EMC();
		
		if(s.equals("pavage"))
			pavage2d();
		//System.out.println("Found "+ nSolutions() +" solution(s).");
		/*for(LinkedList<Element> l : solutions){
			System.out.println("Printing solution from list:");
			for(Element O : l)
				printRow(O);
		}*/	
	}
	
	public void solve(int[][] m){EMC(m);}
	
	public int getColomns(){return totalColumns;}
	
	public boolean checkSolution(List<Element> sol){
		//checkin if a set of elements is a solution
		boolean []isCovered = new boolean[totalColumns];
		
		ListIterator<Element> listIt = sol.listIterator();
        while (listIt.hasNext()) {
        	One o = (One) listIt.next();
        	One elemsInLine = o;
        	do{
        		int col = elemsInLine.getColumn().getname();
        		if (col<0 || col >= totalColumns) return false;
        		//System.out.println(col + " - " + totalColumns);// debugging
        		isCovered[col] = true;
        		elemsInLine =  elemsInLine.getRight();
        	}while(elemsInLine != o);
        }
		
        for(int i = 0; i<totalColumns; i++)
        	if(!isCovered[i]) return false;
		return true;
		}
	public boolean checkSolutions()
	{
		ListIterator<LinkedList<Element>> listIterator = solutions.listIterator();
        while (listIterator.hasNext()) {
        	if(!checkSolution(listIterator.next())) return false;
        }		
		return true;
	}
	
	public List<LinkedList<Element>> getSolutions(){return solutions;}
}
