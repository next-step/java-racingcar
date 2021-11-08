package calculator;

public class Calculator {

	public static double calculate(InputNumber input) {
		String [] numbers = input.getInputNumbers();

		double result = Double.parseDouble(numbers[0]);
		for (int i = 0; i < numbers.length - 2; i+=2) {
			result = Operator.operation(numbers[i+1]).operate(result, Double.parseDouble(numbers[i+2]));
		}
		return result;
	}
}
