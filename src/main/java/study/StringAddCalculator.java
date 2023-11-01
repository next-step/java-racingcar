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
			String text = matcher.group(2);
			numbers = split(text, customDelimiter);
			return sum(numbers);
		}

		numbers = split(input, ",|:");
		return sum(numbers);
	}

	private static String[] split(String input, String delimiter) {
		return input.split(delimiter);
	}

	private static Matcher patternMatcher(String text) {
		return Pattern.compile("//(.)\n(.*)").matcher(text);
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
