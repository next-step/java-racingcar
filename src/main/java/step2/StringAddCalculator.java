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
			if(hasNegativeNumbers(tokens)) {
				throw new RuntimeException("주어진 숫자에 음수가 있습니다");
			}
			return sum(tokens);
		}

		String[] numbers = input.split(",|:");
		if(hasNegativeNumbers(numbers)) {
			throw new RuntimeException("주어진 숫자에 음수가 있습니다");
		}
		return sum(numbers);
	}

	private boolean hasNegativeNumbers(String[] numbers) {
		for(String number : numbers) {
			if(Integer.parseInt(number) < 0) return true;
		}

		return false;
	}

	private int sum(String[] numbers) {
		int sum = 0;
		for(String number : numbers) {
			sum += Integer.parseInt(number);
		}

		return sum;
	}
}
