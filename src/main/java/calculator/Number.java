package calculator;

import java.util.Arrays;

public class Number {

	private final int[] numbers;

	public Number(String[] numbers) {
		this.numbers = Arrays.stream(numbers).mapToInt(Number::parsePositiveInt).toArray();
	}

	public int sum() {
		return Arrays.stream(numbers).sum();
	}

	private static int parsePositiveInt(String input) {
		int number = Integer.parseInt(input);
		if (isNegative(number)) {
			throw new RuntimeException("음수는 입력할 수 없습니다.");
		}
		return number;
	}

	private static boolean isNegative(int number) {
		return number < 0;
	}
}
