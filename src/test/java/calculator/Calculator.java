package calculator;

public class Calculator {
	public static int calculate(String text) {
		if (text == null || text.isBlank()) {
			return 0;
		}
		String[] values = text.split(",");
		return sum(values);
	}

	private static int sum(String[] values) {
		int result = 0;
		for (String value : values) {
			result += Integer.parseInt(value);
		}
		return result;
	}
}
