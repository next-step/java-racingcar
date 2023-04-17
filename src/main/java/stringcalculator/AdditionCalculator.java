package stringcalculator;

import static stringcalculator.CalculatorUtils.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdditionCalculator {

	public static int calculate(String text) {
		if (isEmpty(text)) {
			return ZERO;
		}

		return sum(positives(toInts(split(text))));
	}

	private static boolean isEmpty(String text) {
		return text == null || text.isBlank();
	}

	private static String[] split(String text) {
		Matcher matcher = Pattern.compile(CUSTOM_REGEX).matcher(text);

		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}

		return text.split(BASIC_REGEX);
	}

	private static int[] toInts(String[] stringNumbers) {
		int[] numbers = new int[stringNumbers.length];

		for (int i = ZERO; i < stringNumbers.length; i++) {
			numbers[i] = Integer.parseInt(stringNumbers[i]);
		}

		return numbers;
	}

	private static int[] positives(int[] numbers) {
		for (int number : numbers) {
			positive(number);
		}

		return numbers;
	}

	private static void positive(int number) {
		if (number < ZERO) {
			throw new RuntimeException("음수는 입력받을 수 없습니다.");
		}
	}

	private static int sum(int[] numbers) {
		int sum = ZERO;

		for (int number : numbers) {
			sum += number;
		}

		return sum;
	}
}
