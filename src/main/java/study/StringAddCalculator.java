package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String DEFAULT_DELIMITER = ",|:";
	private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
	private static String input;

	public static int splitAndSum(String text) {
		input = text;
		if (isEmpty(input))
			return 0;

		if (input.contains("-"))
			throw new RuntimeException();

		String delimiter = findDelimiter(input);
		String[] numbers = split(input, delimiter);
		return sum(numbers);
	}

	private static String findDelimiter(String text) {
		Matcher matcher = PATTERN.matcher(text);
		if (matcher.find()) {
			input = matcher.group(2);
			return DEFAULT_DELIMITER + '|' + matcher.group(1);
		}
		return DEFAULT_DELIMITER;
	}


	private static String[] split(String text, String delimiter) {
		return text.split(delimiter);
	}

	private static int sum(String[] numbers) {
		int result = 0;
		for (String number : numbers) {
			result += Integer.parseInt(number);
		}
		return result;
	}

	private static boolean isEmpty(String text) {
		return text == null || "".equals(text);
	}

}
