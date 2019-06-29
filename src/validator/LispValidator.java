package validator;

import java.util.EmptyStackException;
import java.util.Stack;

public class LispValidator {
		
	public Boolean validateParenthesis(String codeToValidate)
	{
		Stack<Character> bracketStack = new Stack<>();
		Boolean isValid = false;
		Boolean failed = false;
		
		// Can't validate null strings
		if(codeToValidate != null)
		{
			// Where code ends
			Integer codeLength = codeToValidate.length();
			
			//Iterate through
			for(int i = 0; codeToValidate.length() > i; i++)
			{
				Character c = codeToValidate.charAt(i);
				
				// Failed early no reason to keep going
				if(failed)
				{
					break;
				}
				else// No failure, keep evaluating
				{
					switch(c)
					{
						// Push open brackets to stack
						case '(':
							bracketStack.push(c);
							break;
						// Closing bracket, Pop its corresponding open. If can't pop fail validation and stop evaluating
						case ')':
							try
							{
								bracketStack.pop();
								
								if(i == codeLength - 1 && bracketStack.empty())
								{
									isValid = true;
								}
							}
							catch(EmptyStackException ese)
							{
								failed = true;
							}
							break;
						default:
							break;
					}	
				}// end No failure		
			}// end for loop
		}// end null string
		
		
		return isValid;
	}

}
