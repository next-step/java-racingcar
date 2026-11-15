package calculator;

import java.util.Arrays;
import java.util.regex.*;

public class StringAddCalculator {
	
	public static final int ZERO=0;
	public static final String DEFAULT_DELIMITER=",|:";
	public static final String CUSTOM_DELIMITER_REGEXP = "//(.)\\n(.*)";
	
	

	public static int calculate(String input) {
		
		if(isBlank(input)) {
			return ZERO;
		}
		return sum(toInts(split(input)));
	}

	private static String[] split(String input) {
		
		Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(input);
		if (m.find()) {
		    String customDelimiter = m.group(1);
		    return m.group(2).split(customDelimiter);
		}
		
		return input.split(DEFAULT_DELIMITER);
	}

	private static boolean isBlank(String input) {
		return input==null|| input.isBlank();
	}
	
	private static int[] toInts(String[] values) {
	    int[] numbers = new int[values.length];

	    for (int i = 0; i < values.length; i++) {
	        numbers[i] = toPositive(values[i]);
	    }
	    return numbers;
	}

	private static int toPositive(String value) {
	    int number = Integer.parseInt(value);

	    if (isNegative(number)) {
	        throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
	    }
	    return number;
	}

	private static boolean isNegative(int number) {
	    return number < 0;
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
