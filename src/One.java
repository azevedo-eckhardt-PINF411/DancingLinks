
public class One extends Element{

	private int nLine;
	
	public One(Element l, Element r, Element u, Element d, Header c, int nLine) {
		super(l, r, u, d, c);
		this.nLine = nLine;
	}

	//public One() {super();}
	
	public One(int nLine) {
		super();
		this.nLine = nLine;
	}

	public int getLine(){return nLine;}
}
