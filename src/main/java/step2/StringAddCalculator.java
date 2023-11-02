package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private final int ZERO = 0;

	public int splitAndSum(String input) {
		if(input == null || input.isEmpty()) {
			return ZERO;
		}

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String[] tokens = m.group(2).split(customDelimiter);
			return sum(tokens);
		}

		String[] numbers = input.split(",|:");
		return sum(numbers);
	}

	private int sum(String[] numbers) {
		int sum = 0;
		for(String number : numbers) {
			sum += Integer.parseInt(number);
		}

		return sum;
	}
}
