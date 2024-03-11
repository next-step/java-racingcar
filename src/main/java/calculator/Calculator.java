package calculator;

public class Calculator {

	public static final String DELIMITER_REGEX = ",|:";

	public String calculate(String input) {
		if ( (input == null) || (input.isEmpty()) ) {
			return "0";
		}

		String[] numbers = input.split(DELIMITER_REGEX);

		if (numbers.length == 1 && isNumber(numbers[0])) {
			return input;
		}

		return sum(numbers).toString();
	}

	private Integer sum(String[] numbers) {
		int result = 0;
		for (String number : numbers) {
			result += Integer.valueOf(number);
		}

		return result;
	}

	private boolean isNumber(String input) {
		return input != null && input.matches("[-+]?\\d*\\.?\\d+");
	}

}
