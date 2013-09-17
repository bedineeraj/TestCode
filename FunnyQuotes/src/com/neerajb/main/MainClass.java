package com.neerajb.main;

import com.neerajb.quotes.Funny;
import com.neerajb.quotes.QuoteGenerator;

public class MainClass {

	public static void main(String[] args) {
		QuoteGenerator obj = new Funny();
		System.out.println(obj.getQuote());
	}

}
