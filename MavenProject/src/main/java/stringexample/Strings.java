package stringexample;

public class Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="Hello";
		System.out.println(name);
		String a=new String("hi");
		System.out.println(a);
		char c[]= {'a','b','c'};
		String r= new String(c);
		System.out.println(r);
		//charAt()
		char f=name.charAt(0);
		System.out.println(f);
		//length()
		System.out.println((name.length()));
		//concat()
		System.out.println(name.concat(a));
		//contains()
		System.out.println(name.contains("r"));
		//equals()
		String m="JAVA";
		String m1="java";
		String m2="java";
		String m3="selenium";
		System.out.println(m.equals(m1));
		System.out.println(m1.equals(m2));
		System.out.println(m.equals(m3));
		//equalsignorecase()
		System.out.println(m.equalsIgnoreCase(m1));
		//toUpperCase()
		System.out.println(m2.toUpperCase());
		//to lower case()
		System.out.println(m.toLowerCase());
		//Isempty()
		String s="";
		System.out.println(s.isEmpty());
		System.out.println(m1==m2);
		String w=new String("java");
		System.out.println(m1==w);
		
		//valueof()
		int z1=10;
		String s8=String.valueOf(z1); //used for type conversion
		System.out.println(z1);

	}

}
