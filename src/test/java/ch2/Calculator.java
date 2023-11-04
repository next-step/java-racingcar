package ch2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

	public static final String DELIMITER = "[,:]";

	public static int calc(String text) {
		if (isBlank(text))
			return 0;
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			String calcText = matcher.group(2);
			return sum(toInts(split(calcText, customDelimiter)));
		}

		return sum(toInts(split(text)));
	}

	private static String[] split(String text) {
		return text.split(DELIMITER);
	}

	private static String[] split(String text, String delmiter) {
		return text.split(delmiter);
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
		for (int i = 0; i <arrays.length; i++) {
			numbers[i] = Integer.parseInt(arrays[i]);
		}
		return numbers;
	}
}
