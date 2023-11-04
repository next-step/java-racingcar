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
		if (input.contains(",")) {
			String[] numbers = input.split(",");
			return sumInput(numbers);
		}
		return Integer.parseInt(input);
	}

	private static int sumInput(String[] numbers) {
		int sum = 0;
		for (String number : numbers) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}
