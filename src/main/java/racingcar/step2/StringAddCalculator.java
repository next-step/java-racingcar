package racingcar.step2;

public class StringAddCalculator {

	public static final String COMMA = ",";

	public static int calculate(String input) {
		if (isBlank(input)) {
			return 0;
		}

		return sum(split(input));
	}

	private static boolean isBlank(String input) {
		return input == null || input.isBlank();
	}

	private static int parseToInt(String input) {
		return Integer.parseInt(input);
	}

	private static String[] split(String input) {
		return input.split(COMMA);
	}

	private static int sum(String[] numbers) {
		int result = 0;
		for (String number : numbers) {
			result += parseToInt(number);
		}
		return result;
	}
}
