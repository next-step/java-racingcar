package calculator;

import java.util.List;

public class NumberCalculator {

	public static int sum(List<Integer> numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}
}
