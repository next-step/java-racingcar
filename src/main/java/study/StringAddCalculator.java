package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static int splitAndSum(String input) throws RuntimeException {
		if (isEmpty(input))
			return 0;

		if (input.contains("-"))
			throw new RuntimeException();

		Matcher matcher = patternMatcher(input);

		String[] numbers;
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			numbers = split(input, customDelimiter);
			return sum(numbers);
		}

		numbers = split(input, ",|:");
		return sum(numbers);
	}

	private static String[] split(String input, String delimiter) {
		return input.split(delimiter);
	}

	private static Matcher patternMatcher(String input) {
		return Pattern.compile("//(.)\n(.*)").matcher(input);
	}

	private static int sum(String[] numbers) {
		int result = 0;
		for (String number : numbers)
			result += Integer.parseInt(number);
		return result;
	}

	private static boolean isEmpty(String input) {
		return input == null || "".equals(input);
	}

}
