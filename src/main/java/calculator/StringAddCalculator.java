package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
	private static final Pattern COMPILE_PATTERN = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
	private static final String DEFAULT_DELIMITER = ",|:";
	private static final int DEFAULT_RETURN_VALUE = 0;

	public static int splitAndSum(String input) {
		if (validate(input)) {
			return DEFAULT_RETURN_VALUE;
		}
		Number number = new Number(split(input));
		return number.sum();
	}

	private static boolean validate(String input) {
		return input == null || input.isEmpty();
	}

	private static String[] split(String input) {
		Matcher matcher = COMPILE_PATTERN.matcher(input);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}
		return input.split(DEFAULT_DELIMITER);
	}

}
