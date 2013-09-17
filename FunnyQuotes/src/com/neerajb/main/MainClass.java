package com.neerajb.main;

import com.neerajb.quotes.Funny;
import com.neerajb.quotes.QuoteGenerator;
import com.neerajb.quotes.Sad;

public class MainClass {

	public static void main(String[] args) {
		QuoteGenerator obj = new Sad();
		System.out.println(obj.getQuote());
	}

}
