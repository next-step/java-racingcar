package calculator;

import java.util.List;

public class NumberCalculator {

	public static int sum(List<Integer> numbers) {
		return numbers.stream()
			.mapToInt(number -> number)
			.sum();
	}
}
