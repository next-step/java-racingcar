package calculator;

public class Calculator {

	private static final String DELIMITER = ",|:";

	public static int calc(String input) {
		if (input.isEmpty()) {
			return 0;
		}

		String[] values = input.split(DELIMITER);
		int sum = 0;

		for (String value : values) {
			sum += Integer.parseInt(value);
		}

		return sum;
	}

}
