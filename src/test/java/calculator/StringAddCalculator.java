package calculator;

import java.util.Arrays;

public class StringAddCalculator {
	
	public static final int ZERO=0;
	public static final String DEFAULT_DELIMITER=",|:";
	

	public static int calculate(String input) {
		
		if(isBlank(input)) {
			return ZERO;
		}
		return sum(toInts(split(input)));
	}

	private static String[] split(String input) {
		return input.split(DEFAULT_DELIMITER);
	}

	private static boolean isBlank(String input) {
		return input==null|| input.isBlank();
	}
	
	
	private static int[] toInts(String[] values) {
	    return Arrays.stream(values)
	                 .mapToInt(Integer::parseInt)
	                 .toArray();
	}

	private static int sum(int[] numbers) {
	    int result = 0;
	    for (int number : numbers) {
	        result += number;
	    }
	    return result;
	}

	private static int sum(String[] values) {
		int result=0;
		
		for(String value : values) {
			result+=Integer.parseInt(value);
		}
		return result;
	}
	
	

}
