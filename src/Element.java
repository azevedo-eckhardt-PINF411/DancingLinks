
public abstract class Element {
	Element left,right,up,down;
	Header column;
	
	public Element(Element l, Element r, Element u, Element d, Header c){
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
	
	public Header getColumn(){
		return column;
	}

	//seters
	public void setRight(Element rightElement){
		this.right = rightElement;
	}
	
	public void setLeft(Element leftElement){
		this.left = leftElement;
	}
	
	public void setUp(Element upElement){
		this.up = upElement;
	}
	
	public void setDown(Element downElement){
		this.down = downElement;
	}
	
	public void setColumn(Header columnElement){
		this.column=columnElement;
	}	
}
