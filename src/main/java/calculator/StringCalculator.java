package calculator;

public class StringCalculator {

	public Integer calculate(String input) {
		if (input == null || input.length() == 0)
			return 0;
		String[] split = input.split(",");
		int sum = 0;
		for (String number : split) {
			sum += Integer.parseInt(number);
		}
		return sum;
	}
}
