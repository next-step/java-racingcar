package step2;

public class StringAddCalculator {
	private final int ZERO = 0;

	public int splitAndSum(String input) {
		if(input == null || input.isEmpty()) {
			return ZERO;
		}

		String[] numbers = input.split(",|:");

		return sum(numbers);
	}

	private int sum(String[] numbers) {
		int sum = 0;
		for(String number : numbers) {
			sum += Integer.parseInt(number);
		}

		return sum;
	}
}
