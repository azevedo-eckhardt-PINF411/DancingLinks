
public abstract class Element {
	Element left,right,up,down,column;
	
	public Element(Element l, Element r, Element u, Element d, Element c){
		left = l;
		right = r;
		up = u;
		down = d;
		column = c;
	}
	
	public Element(){}
	
	//getters
	public Element getRight(){
		return right;
	}

	public Element getLeft(){
		return left;
	}

	public Element getUp(){
		return up;
	}
	
	public Element getDown(){
		return down;
	}
	
	public Element getColumn(){
		return column;
	}

	//seters
	public void setRight(Element rightElement){
		this.right = rightElement;
	}
	
	public void setLeft(Element leftElement){
		this.right = leftElement;
	}
	
	public void setUp(Element upElement){
		this.right = upElement;
	}
	
	public void setDown(Element downElement){
		this.right = downElement;
	}

	
	/* talvez depois, pra modularizar o odigo
	//adders
	public void addUp(Element e){}// TODO add the element to the list

	public void addDown(Element e){}

	public void addRight(Element e){}

	public void addLeft(Element e){}
	
	public Element addUp(){}// TODO add a One to the list. return the element added

	public Element addDown(){}

	public Element addRight(){}

	public Element addLeft(){}*/
	
}
