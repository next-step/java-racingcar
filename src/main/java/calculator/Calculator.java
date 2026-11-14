package calculator;

public class Calculator {

	private static final String DELIMITER = ",|:";

	public static int calc(String input) {
		int sum = 0;
		String[] values = input.split(DELIMITER);
		for (String value : values) {
			sum += Integer.parseInt(value);
		}
		return sum;
	}
}
