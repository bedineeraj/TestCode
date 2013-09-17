package com.neerajb.quotes;

public class Sarcastic implements QuoteGenerator{

	public String getQuote(){
		return "A sarsactic quote..";
	}
	
	public String getName(){
		return this.getClass().getName();
	}

}
