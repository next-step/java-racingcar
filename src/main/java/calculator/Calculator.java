package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	private static final int ZERO = 0;
	private static final String DELIMITER = ",|:";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int calc(String input) {
		if (isNullOrEmpty(input)) {
			return ZERO;
		}
		return sum(split(input));
	}

	private static boolean isNullOrEmpty(String input) {
		return isNull(input) || input.isEmpty();
	}

	private static String[] split(String input) {
		Matcher m = findCustomDelimiter(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String numbers = m.group(2);
			return numbers.split(customDelimiter);
		}
		
		return input.split(DELIMITER);
	}

	private static int sum(String[] values) {
		int sum = 0;
		for (String value : values) {
			sum += toPositiveNumber(value);
		}
		return sum;
	}

	private static int toPositiveNumber(String value) {
		int num = Integer.parseInt(value);
		if (isNegative(num)) {
			throw new RuntimeException();
		}
		return num;
	}

	private static boolean isNull(String value) {
		return value == null;
	}

	private static boolean isNegative(int num) {
		return num < ZERO;
	}

	private static Matcher findCustomDelimiter(String input) {
		return CUSTOM_DELIMITER_PATTERN.matcher(input);
	}

}
