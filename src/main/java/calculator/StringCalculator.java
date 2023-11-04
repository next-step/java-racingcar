package calculator;

public class StringCalculator {

	public static int cal(String input) {
		int result = 0;
		if (input == null || input.isEmpty()) {
			return 0;
		}
		if (input.contains("-")) {
			throw new RuntimeException();
		}
		return Integer.parseInt(input);
	}
}
