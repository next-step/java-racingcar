package calculator;

public class Parser {
	public static int[] toNaturalNumbers(String[] values) {
		int[] numbers = new int[values.length];
		for (int i = 0; i < values.length; i++) {
			numbers[i] = toNaturalNumber(values[i]);
		}
		return numbers;
	}

	public static int toNaturalNumber(String value) {
		int number = toInt(value);
		if (number < 0) {
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
