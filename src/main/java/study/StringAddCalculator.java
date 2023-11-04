package study;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String DEFAULT_DELIMITER = ",|:";
	private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int splitAndSum(String text) {
		if (isEmpty(text))
			return 0;

		if (text.contains("-"))
			throw new RuntimeException();

		return sum(stringToInt(split(findText(text), findDelimiter(text))));
	}

	private static String findText(String text) {
		Matcher matcher = PATTERN.matcher(text);
		if (matcher.find()) {
			return matcher.group(2);
		}
		return text;
	}

	private static String findDelimiter(String text) {
		Matcher matcher = PATTERN.matcher(text);
		if (matcher.find()) {
			return DEFAULT_DELIMITER + '|' + matcher.group(1);
		}
		return DEFAULT_DELIMITER;
	}

	private static int[] stringToInt(String[] texts) {
		int[] result = new int[texts.length];
		for (int i = 0; i < texts.length; i++) {
			result[i] = Integer.parseInt(texts[i]);
		}
		return result;
	}

	private static String[] split(String text, String delimiter) {
		return text.split(delimiter);
	}

	private static int sum(int[] numbers) {
		int result = 0;
		for (int number : numbers) {
			result += number;
		}
		return result;
	}

	private static boolean isEmpty(String text) {
		return text == null || "".equals(text);
	}

}
