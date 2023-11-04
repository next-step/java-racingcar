package calculator;

public class StringCalculator {

	public static int cal(String input) {
		int result = 0;
		if (input == null || input.isEmpty()) {

			return 0;
		}
		return Integer.parseInt(input);
	}
}
