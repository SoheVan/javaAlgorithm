package com.sohe;

public class Fibo {

	public static void main(String[] args) {
		int result = Fibo.fibo(10);
		System.out.println("result " + result);

	}
	
	public static int fibo(int n){
		if(n==1 || n==2)
			return 1;
		return fibo(n-1) + fibo(n-2);
	}

}
