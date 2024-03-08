package calculator;

public class Calculator {
	public int additionCalculate(final String input) {
		if (input == null || input.equals("")) {
			return 0;
		}

		String[] number = input.split(",|:");

		int result = calculateAddition(number);

		return result;
	}

	private static int calculateAddition(final String[] number) {
		int result = 0;

		for (int i = 0; i < number.length; i++) {
			result += Integer.parseInt(number[i]);
		}
		return result;
	}
}
