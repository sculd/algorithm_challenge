import java.util.*;

class Solution {
	//Take a number and return its string(check-written) form.
	String[] oneDigitSymbols = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

	String[] towDigitsLeadingSymbols = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	static final Map<Integer, String> twoDigitSymbols = new HashMap<Integer, String>() {{
	    put(10, "ten");
	    put(11, "eleven");
	    put(12, "twelve");
	    put(13, "thirteen");
	    put(14, "fourteen");
	    put(15, "fifteen");
	    put(16, "sixteen");
	    put(17, "seventeen");
	    put(18, "eighteen");
	    put(19, "nineteen");
	}};	

	String convertTwoDigits(int two_digits)	{
		if (two_digits == 0)
			return "";
		else if (twoDigitSymbols.get(two_digits) != null)
			return twoDigitSymbols.get(two_digits);
		else	{
			int lead = two_digits / 10;
			int one_digit = two_digits % 10;
			if (lead == 0)
				return oneDigitSymbols[one_digit];
			else
				return towDigitsLeadingSymbols[lead] + ((one_digit == 0)? "": " " + oneDigitSymbols[one_digit]);
		}
	}

	String convertThreeDigits(int three_digits)	{
		int h_digit = three_digits / 100;
		int two_digits = three_digits % 100;
		String two_digits_word = convertTwoDigits(two_digits);
		String result = two_digits_word;
		if (h_digit != 0)
			result = oneDigitSymbols[h_digit] + " hundred" + ((two_digits == 0)? "": " ") + result;
		return result;
	}
	
	public String convertToWords(int number) {
	    //Implement this, return a string.
		// billion, thousand, hundred
		if (number == 0)
			return "zero";
		
		String result = "";
		
		int b_digit = number / 1000000000;
		number = number % 1000000000;
		result = result + ((b_digit == 0)? "" : convertThreeDigits(b_digit) + " billion");
		
		int m_digit = number / 1000000;
		number = number % 1000000;
		result = result + ((result.length() == 0)? "": " ") + ((m_digit == 0)? "" : convertThreeDigits(m_digit) + " million");
		
		int t_digit = number / 1000;
		number = number % 1000;
		result = result + ((result.length() == 0)? "": " ") + ((t_digit == 0)? "" : convertThreeDigits(t_digit ) + " thousand");

		result = result + ((result.length() == 0)? "": " ") + convertThreeDigits(number);
		
	    return result;
	}	
}

public class CheckWriter {
	/*
	 * Write a program that converts a number to a print form (like check writer) 
	 * Example: input: 561 => output: Five Hundred Sixty One 
	 * input: 12340982 => Output: Twelve million three hundred forty thousand nine hundred eighty two
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		
		System.out.println(sol.convertToWords(1));
		System.out.println(sol.convertToWords(10));
		System.out.println(sol.convertToWords(20));
		System.out.println(sol.convertToWords(100));
		System.out.println(sol.convertToWords(200));
		System.out.println(sol.convertToWords(1000));
		System.out.println(sol.convertToWords(2000));
		System.out.println(sol.convertToWords(10000));
		System.out.println(sol.convertToWords(100000));
		System.out.println(sol.convertToWords(1000000));
		System.out.println(sol.convertToWords(561));
		System.out.println(sol.convertToWords(560));
		System.out.println(sol.convertToWords(501));
		System.out.println(sol.convertToWords(511));
		System.out.println(sol.convertToWords(111012));
		System.out.println(sol.convertToWords(12340982));
	}

}
