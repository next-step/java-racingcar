package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	public static final String NEGATIVEDELIMITER = "-";
	public static final String DELIMITERS = ",|:";
	public static final String CUSTOMDELIMITER = "//(.)\n(.*)";

	public static int cal(String input) {
		if (isNullOrBlank(input)) {
			return 0;
		}

		if (isContainNegative(input)) {
			throw new RuntimeException();
		}

//		if (iscontainDelimiters(input)) {
//			return sumInput(removeDelimiter(input, DELIMITERS));
//		}
//
//		Matcher m = Pattern.compile(CUSTOMDELIMITER).matcher(input);
//		if (m.find()) {
//			String customDelimiter = m.group(1);
//			return sumInput(removeDelimiter(m.group(2), customDelimiter));
//		}

		return sumInput(removeDelimiter(input));
	}

	private static String[] removeDelimiter(String input) {
		Matcher m = Pattern.compile(CUSTOMDELIMITER).matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String tokens[] = m.group(2).split(customDelimiter);
			return tokens;
		}
		return input.split(DELIMITERS);
	}

	private static boolean iscontainDelimiters(String input) {
		return input.contains(",") || input.contains(":");
	}

	private static boolean isContainNegative(String input) {
		return input.contains(NEGATIVEDELIMITER);
	}

	private static boolean isNullOrBlank(String input) {
		return input == null || input.isEmpty();
	}

	private static int sumInput(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}
