package step2;

public class Calculator {
	private final Delimiter delimiter;

	public Calculator(Delimiter delimiter) {
		this.delimiter = delimiter;
	}

	public int calculate(String input) {
		String[] tokens = delimiter.split(input);

		int sum = 0;
		for (String token : tokens) {
			sum += Integer.parseInt(token);
		}
		return sum;
	}

	public int parseOrZero(String input) {
		if (input.isEmpty() || input.equals("null")) {
			return 0;
		}
		return Integer.parseInt(input);
	}

	public int parseIfSingleDigit(String input) {
		if (input.length() > 0) {
			return Integer.parseInt(input);
		}
		return 0;
	}

	public void checkedNegativeNumber(String input) {
		String[] split = delimiter.split(input);

		for (String s : split) {
			int number = Integer.parseInt(s);

			if (number < 0) {
				throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
			}
		}
	}

	public void validateDelimiters(String input) {
		String regex = "[\\d" + delimiter.getDelimiter() + "]+";

		if (!input.matches(regex)) {
			throw new IllegalArgumentException("허용되지 않은 구분자가 포함되어 있습니다.");
		}
	}
}
