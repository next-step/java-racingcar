package racingcar.step2;

public class StringAddCalculator {

	public static int sum(String input) {
		if (isBlank(input)) {
			return 0;
		}

		return parseToInt(input);
	}

	private static int parseToInt(String input) {
		return Integer.parseInt(input);
	}

	private static boolean isBlank(String input) {
		return input == null || input.isBlank();
	}
}
