package main;

import validator.LispValidator;

public class Main {

	public static void main(String[] args) {
		
		if(args.length > 0)
		{
			String evaluateString = args[0];
			LispValidator lv = new LispValidator();
			Boolean valid = lv.validateParenthesis(evaluateString);
			System.out.println(valid);
		}
		else
		{
			System.out.println("please provide code to validate");
		}
	}

}
