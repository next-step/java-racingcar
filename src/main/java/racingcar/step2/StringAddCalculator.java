package racingcar.step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String SEPARATOR = "[,:]";
	private static final Pattern PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final String NEGATIVE_NUMBER_MESSAGE = "음수는 계산할 수 없습니다.";

	private StringAddCalculator() {
	}

	public static int calculate(String input) {
		if (isBlank(input)) {
			return 0;
		}

		Matcher matcher = PATTERN.matcher(input);
		if (matcher.find()) {
			return sum(split(matcher.group(2), matcher.group(1)));
		}

		return sum(split(input));
	}

	private static boolean isBlank(String input) {
		return input == null || input.isBlank();
	}

	private static int parseToInt(String input) {
		return Integer.parseInt(input);
	}

	private static String[] split(String input) {
		return input.split(SEPARATOR);
	}

	private static String[] split(String input, String delimiter) {
		return input.split(delimiter);
	}

	private static int sum(String[] values) {
		int result = 0;
		for (String value : values) {
			result += toPositive(value);
		}
		return result;
	}

	private static int toPositive(String value) {
		int number = parseToInt(value);
		if (isNegative(number)) {
			throw new NumberFormatException(NEGATIVE_NUMBER_MESSAGE);
		}

		return number;
	}

	private static boolean isNegative(int number) {
		return number < 0;
	}
}
