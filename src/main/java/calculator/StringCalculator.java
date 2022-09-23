package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	private static final Pattern INPUT_PATTERN = Pattern.compile("//(.*)\\n(.*)");
	public static final String DEFAULT_SEPARATOR = ",|:";

	public Positive calculate(String input) {
		if (input == null || input.isBlank())
			return new Positive(0);
		String separator = separator(input);
		String expression = expression(input);
		String[] numbers = expression.split(separator);
		return sum(positives(numbers));
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

	private Positive sum(Positive[] numbers) {
		Positive sum = new Positive(0);
		for (Positive number : numbers) {
			sum = sum.plus(number);
		}
		return sum;
	}

	private Positive[] positives(String[] numbers) {
		Positive[] positives = new Positive[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			positives[i] = new Positive(numbers[i]);
		}
		return positives;
	}
}
