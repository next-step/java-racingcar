package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	private static final Pattern INPUT_PATTERN = Pattern.compile("//(.*)\\n(.*)");
	public static final String DEFAULT_SEPARATOR = ",|:";

	public int calculate(String input) {
		if (input == null || input.isBlank())
			return 0;
		String separator = separator(input);
		String expression = expression(input);
		String[] expressions = expression.split(separator);
		return sum(numbers(expressions));
	}

	private String separator(String input) {
		Matcher matcher = INPUT_PATTERN.matcher(input);
		if (matcher.find())
			return matcher.group(1);
		return DEFAULT_SEPARATOR;
	}

	private String expression(String input) {
		Matcher matcher = INPUT_PATTERN.matcher(input);
		if (matcher.matches())
			return matcher.group(2);
		return input;
	}

	private int sum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

	private int[] numbers(String[] expressions) {
		int[] numbers = new int[expressions.length];
		for (int i = 0; i < expressions.length; i++) {
			numbers[i] = Integer.parseInt(expressions[i]);
		}
		return numbers;
	}
}
