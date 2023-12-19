package calculator;

import java.util.List;

public class PositiveNumber {
	private static final String MINUS = "-";

	public boolean checkNegativeNumber(List<String> numbers) {
		for (String number : numbers) {
			if (number.contains(MINUS)) {
				return true;
			}
		}
		return false;
	}
}
