
public class Header extends Element {
	int size;
	int name;
	public Header(Element l, Element r, Element u, Element d, Header c, int s, int n) {
		super(l, r, u, d, c);
		size=s;
		name=n;
	}
<<<<<<< HEAD
	
	public Header(){ super();}// ??? nao sei se precisa chamar a super
	
	public int getname(){return name;}
=======

<<<<<<< HEAD
	//diverge commits

>>>>>>> d8445425beefe49b9238bbedca28feb66704f94d
=======
	public Header(){ super();}// ??? nao sei se precisa chamar a super
								//resp: creio q sim
	
	public int getname(){return name;}
	
	public void incSize(){
		size++;
	}
	
	public void decSize(){
		size--;
	}
>>>>>>> origin/master

}
