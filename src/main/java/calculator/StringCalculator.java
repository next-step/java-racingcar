package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.exception.NegativeException;
import calculator.exception.NotANumberException;

public class StringCalculator {

	private static final Pattern INPUT_PATTERN = Pattern.compile("//(.*)\\n(.*)");
	public static final String DEFAULT_SEPARATOR = ",|:";
	public static final int SEPARATOR_GROUP_NUMBER = 1;
	public static final int EXPRESSION_GROUP_NUMBER = 2;

	public int calculate(String input) {
		if (input == null || input.isBlank()) {
			return 0;
		}
		String separator = parseSeparator(input);
		String expression = parseExpression(input);
		String[] numbers = expression.split(separator);
		return sum(parseInts(numbers));
	}

	private String parseSeparator(String input) {
		Matcher matcher = INPUT_PATTERN.matcher(input);
		if (matcher.find()) {
			return matcher.group(SEPARATOR_GROUP_NUMBER);
		}
		return DEFAULT_SEPARATOR;
	}

	private String parseExpression(String input) {
		Matcher matcher = INPUT_PATTERN.matcher(input);
		if (matcher.matches()) {
			return matcher.group(EXPRESSION_GROUP_NUMBER);
		}
		return input;
	}

	private int sum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

	private int[] parseInts(String[] numbers) {
		int[] positives = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			int integer = parseInt(numbers[i]);
			validateNotNegative(integer);
			positives[i] = integer;
		}
		return positives;
	}

	private int parseInt(String number) {
		try {
			return parseIntConsideringBlank(number);
		} catch (NumberFormatException exception) {
			throw new NotANumberException();
		}
	}

	private int parseIntConsideringBlank(String number) {
		if (number.isBlank()) {
			return 0;
		}
		return Integer.parseInt(number);
	}

	private void validateNotNegative(int integer) {
		if (integer < 0) {
			throw new NegativeException();
		}
	}
}
