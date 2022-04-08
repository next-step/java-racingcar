package study;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static int splitAndSumAll(String text) {
		int result = 0;
		if (isNullOrEmptyString(text)) return result;

		result = calculate(text);
		return result;
	}

	private static boolean isNullOrEmptyString(String text) {
		return text == null || "".equals(text);
	}

	private static int calculate(String text) {
		String delimiter = ",|:";

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		boolean existCustomDelimiter = m.find();

		if (existCustomDelimiter) {
			delimiter = m.group(1);
			String number = m.group(2);
			String[] tokens = getTokens(number, delimiter);
			return sumAll(tokens);
		}

		String[] tokens = getTokens(text, delimiter);
		return sumAll(tokens);
	}

	private static String[] getTokens(String input, String delimiter) {
		String[] tokens = input.split(delimiter);
		return tokens;
	}

	private static int sumAll(String[] split) {
		int[] arr = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();
		validation(arr);
		int result = Arrays.stream(arr).sum();
		return result;
	}

	private static void validation(int[] numbers) {
		Arrays.stream(numbers).forEach(number -> {
			if (number < 0) throw new IllegalArgumentException("입력값에 음수가 있습니다");
		});
	}

}
