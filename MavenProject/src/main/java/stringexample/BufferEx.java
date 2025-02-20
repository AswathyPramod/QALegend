package stringexample;

public class BufferEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StringBuffer s=new StringBuffer("hello");
		System.out.println(s);
		StringBuilder r=new StringBuilder("hii");
		System.out.println(r);
		//append()
		System.out.println(s.append("Aswathy"));
		System.out.println(s);
		//insert()
		System.out.println(s.insert(0,"e"));
		//replace()
		System.out.println(s.replace(0, 4, "n"));
		//reverse()
		System.out.println(s.reverse());
		//delete
		System.out.println(s.delete(0,2));
		

	}

}
