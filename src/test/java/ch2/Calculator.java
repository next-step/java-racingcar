package ch2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static final String DELIMITER = "[,:]";

	public static int calc(String text) {
		if (isBlank(text))
			return 0;

		Matcher matcher = getCustomDelimiterMatcher(text);
		if (matcher.find()) {
			return sum(toInts(split(matcher)));
		}
		return sum(toInts(split(text)));
	}


	private static Matcher getCustomDelimiterMatcher(String text) {
		return Pattern.compile("//(.)\n(.*)").matcher(text);
	}

	private static String[] split(Matcher matcher) {
		String customDelimiter = matcher.group(1);
		String calcText = matcher.group(2);
		return split(calcText, customDelimiter);
	}

	private static String[] split(String text) {
		return text.split(DELIMITER);
	}

	private static String[] split(String text, String delimiter) {
		return text.split(delimiter);
	}

	private static boolean isBlank(String text) {
		return text == null || text.isEmpty();
	}

	private static int sum(int[] numbers) {
		int sum = 0;
		for (int num: numbers) {
			sum += num;
		}
		return sum;
	}

	private static int[] toInts(String[] arrays) {
		int[] numbers = new int[arrays.length];
		for (int index = 0; index <arrays.length; index++) {
			numbers[index] = getParseInt(arrays[index]);
		}
		return numbers;
	}

	private static int getParseInt(String text) {
		int parseInt = Integer.parseInt(text);
		if (parseInt < 0) {
			throw new RuntimeException();
		}
		return parseInt;
	}
}
