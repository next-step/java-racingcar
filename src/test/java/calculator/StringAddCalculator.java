package calculator;

import java.util.regex.*;

public class StringAddCalculator {

	public static final String DEFAULT_DELIMITER=",|:";
	public static final String CUSTOM_DELIMITER_REGEXP = "//(.)\\n(.*)";



	public static int calculate(String input) {
	    if (isBlank(input)) {
	        return PositiveNumber.ZERO.toInt();
	    }
	    return sum(split(input)).toInt();
	}

	private static String[] split(String input) {

		Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEXP).matcher(input);
		if (m.find()) {
		    String customDelimiter = m.group(1);
		    return m.group(2).split(Pattern.quote(customDelimiter));
		}

		return input.split(DEFAULT_DELIMITER);
	}

	private static boolean isBlank(String input) {
		return input==null|| input.isBlank();
	}

	private static PositiveNumber sum(String[] values) {
	    PositiveNumber result = PositiveNumber.ZERO;
	    for (String value : values) {
	        result = result.plus(new PositiveNumber(value));
	    }
	    return result;
	}

}
