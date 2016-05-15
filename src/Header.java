
public class Header extends Element {
	int size;
	int name;
	public Header(Element l, Element r, Element u, Element d, Element c, int s, int n) {
		super(l, r, u, d, c);
		size=s;
		name=n;
	}
	public Header(){ super();}
	
	public int getname(){return name;}
	
	public void incSize(){
		size++;
	}
	
	public void decSize(){
		size--;
	}

}
