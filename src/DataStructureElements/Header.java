package DataStructureElements;

public class Header extends Element {
	int size;
	int name;
	public Header(Element l, Element r, Element u, Element d, Header c, int s, int n) {
		super(l, r, u, d, c);
		size=s;
		name=n;
	}
	public Header(){ super();}
	
	public int getname(){return name;}
	
	public int getSize(){
		return size;
	}
	
	public void incSize(){
		size++;
	}
	
	public void decSize(){
		size--;
	}
	public Header getRight(){
		return (Header)super.getRight();
	}

	public Header getLeft(){
		return (Header)super.getLeft();
	}

}
