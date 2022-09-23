package calculator;

public class StringCalculator {

	private String separator() {
		return ",|:";
	}

	private String[] expressions(String input) {
		if (input == null || input.isBlank())
			return new String[] {};
		return input.split(separator());
	}

	private int sum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}

	private int[] numbers(String[] expressions) {
		int[] numbers = new int[expressions.length];
		for (int i = 0; i < expressions.length; i++) {
			numbers[i] = Integer.parseInt(expressions[i]);
		}
		return numbers;
	}

	public int calculate(String input) {
		String[] expressions = expressions(input);
		return sum(numbers(expressions));
	}
}
