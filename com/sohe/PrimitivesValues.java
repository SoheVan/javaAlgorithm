package com.sohe;

public class PrimitivesValues {

	static boolean b;
	static byte by;
	static char ch;
	static short sh;
	static int i;
	static long l;
	
	static float f;
	static double d;
	String mystr;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mystr == null) ? 0 : mystr.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrimitivesValues other = (PrimitivesValues) obj;
		if (mystr == null) {
			if (other.mystr != null)
				return false;
		} else if (!mystr.equals(other.mystr))
			return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println("b "+b);
		System.out.println("by "+by);
		System.out.println("ch ["+ch + "]");
		System.out.println("sh "+sh);
		System.out.println("i "+i);
		System.out.println("l "+l);
		System.out.println("f "+f);
		System.out.println("d "+d);
		by = 127;
		by =-128;
		ch = 65535;//16 bit from 0 to 2^16
		l = 4294967295l;

	}

}
