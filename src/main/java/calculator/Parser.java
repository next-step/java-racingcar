package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {
	static final int MIN_OF_NATURAL_NUMBER = 0;

	public static List<Integer> toNaturalNumbers(String[] values) {
		List<Integer> numbers = new ArrayList<>();
		for (String value : values) {
			numbers.add(toNaturalNumber(value));
		}
		return numbers;
	}

	public static int toNaturalNumber(String value) {
		int number = toInt(value);
		if (number < MIN_OF_NATURAL_NUMBER) {
			throw new RuntimeException("음수는 허용하지 않습니다.");
		}
		return number;
	}

	public static int toInt(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException nfe) {
			throw new RuntimeException("숫자로 변환할 수 없는 값입니다.: " + value, nfe);
		}
	}
}
