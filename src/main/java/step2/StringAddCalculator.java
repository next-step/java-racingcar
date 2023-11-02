package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private final int ZERO = 0;

	public String[] split(String input) {
		if(input == null || input.isEmpty()) {
			return new String[]{};
		}

		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}

		return input.split(",|:");
	}

	public int sum(String[] numbers) {
		if(numbers.length == 0) {
			return ZERO;
		}

		if(hasNegativeNumbers(numbers)) {
			throw new RuntimeException("주어진 숫자에 음수가 있습니다");
		}

		int sum = 0;
		for(String number : numbers) {
			sum += Integer.parseInt(number);
		}

		return sum;
	}

	private boolean hasNegativeNumbers(String[] numbers) {
		for(String number : numbers) {
			if(Integer.parseInt(number) < 0) return true;
		}

		return false;
	}
}
