package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static final String CUSTOM_SEPARATOR = "//(.)\n(.*)";

	public int additionCalculate(final String input) {
		if (input == null || input.equals("")) {
			return 0;
		}

		Matcher matcher = Pattern.compile(CUSTOM_SEPARATOR).matcher(input);

		if (matcher.find()) {
			return calculateAdditionWithCustomSign(matcher);
		}

		return calculateAddition(input.split(",|:"));
	}

	private static int calculateAdditionWithCustomSign(final Matcher matcher) {
		String customDelimiter = matcher.group(1);
		String[] numbers = matcher.group(2).split(customDelimiter);
		return calculateAddition(numbers);
	}

	private static int calculateAddition(final String[] number) {
		int result = 0;

		for (int i = 0; i < number.length; i++) {
			checkNegativeNumber(number, i);
			result += Integer.parseInt(number[i]);
		}
		return result;
	}

	private static void checkNegativeNumber(final String[] number, final int i) {
		if (Integer.parseInt(number[i]) < 0) {
			throw new RuntimeException();
		}
	}
}
