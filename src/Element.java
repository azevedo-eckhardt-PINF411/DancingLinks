
public abstract class Element {
	Element left,right,up,down,column;
	
	public Element(Element l, Element r, Element u, Element d, Element c){
		left=l;
		right=r;
		u=up;
		d=down;
		c=column;
	}
	
	public Element getNextR(){
		return right;
	}
	
	public Element getNextD(){
		return down;
	}

	//TODO: outros getters

	//TODO: seters 
	
}
