package calculator;

public class Calculator {

	private Calculator() {
	}

	public static double calculate(InputNumber input) {
		String [] numbers = input.getInputNumbers();

		int result = Integer.parseInt(numbers[0]);
		for (int i = 0; i < numbers.length - 2; i+=2) {
			result = Operator.operation(numbers[i+1]).operate(result, Integer.parseInt(numbers[i+2]));
		}
		return result;
	}
}
