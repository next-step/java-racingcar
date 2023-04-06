package step2_calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	public static final int ZERO = 0;
	private static final String DEFAULT_REGEX = ",|:";
	private static final String CUSTOM_REGEX_PATTERN = "//(.)\n(.*)";
	private static final String NEGATIVE_ERROR_MSG = "음수 값 발견";
	private static final String PARSEINT_ERROR_MSG = "NumberFormat 변환 중 오류 발생";

	private static StringAddCalculator stringAddCalculator;

	private StringAddCalculator() {
	}

	public static StringAddCalculator getInstance() {
		if (stringAddCalculator == null) {
			stringAddCalculator = new StringAddCalculator();
		}

		return stringAddCalculator;
	}

	public int splitAndSum(String text) {
		int sum = ZERO;

		if (isBlank(text)) {
			return ZERO;
		}

		String regex = DEFAULT_REGEX;
		Matcher matcher = Pattern.compile(CUSTOM_REGEX_PATTERN).matcher(text);

		if (matcher.find()) {
			regex += '|' + matcher.group(1);
			String customText = matcher.group(2);
			return sum(toPostives(split(customText, regex)));
		}

		return sum(toPostives(split(text, DEFAULT_REGEX)));
	}

	private boolean isBlank(String text) {
		return text == null || text.isBlank();
	}

	private String[] split(String text, String regex) {
		return text.split(regex);
	}

	private int sum(int[] numbers) {
		int sum = ZERO;

		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

	private int[] toPostives(String[] values) {
		int[] numbers = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			int number = toPositive(values[i]);
			numbers[i] = number;
		}
		return numbers;
	}

	private int toPositive(String value) {
		try {
			int number = Integer.parseInt(value);

			if (number < 0) {
				throw new RuntimeException(NEGATIVE_ERROR_MSG);
			}
			return number;
		} catch (NumberFormatException e) {
			throw new RuntimeException(PARSEINT_ERROR_MSG);
		}
	}

}
