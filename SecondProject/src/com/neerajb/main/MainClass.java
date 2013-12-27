package com.neerajb.main;

import com.neerajb.colors.Yellow;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("MainClass.main()");
		Yellow obj = new Yellow();
		obj.setColorName("Yellow");
		System.out.println(obj.getColor());
	}

}
