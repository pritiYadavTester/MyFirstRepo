package com.evs.Utility;

public class Program {
	public static void main(String[] args) {
		setenceReverse() ;
		//stringReverse();
	}
	public static  void stringReverse() {
		String name="priti";
		String reverse=" ";
		for(int i=name.length()-1; i>=0; i--) {
		reverse=	reverse+name.charAt(i);
		}
		System.out.print(reverse);

	}
	public static void setenceReverse() {
		String str="this is a girl";
		String[] strArr= 	str.split(" ");
		for(int i=str.length()-1;i>=0;i--) {
		System.out.println(strArr[i]);
		}
	}

}
