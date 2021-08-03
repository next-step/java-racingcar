package step2;

import static step2.Converter.*;
import static step2.Validator.*;

public class Calculator {
	public int execute(String expression) {
		String[] elements = splitExpression(expression);

		int number1 = stringToInt(elements[0]);
		int result = number1;

		for (int i = 1; i < elements.length; i += 2) {
			int number2 = stringToInt(elements[i + 1]);
			String operator = elements[i];

			result = calculate(operator, number1, number2);
			number1 = result;
		}

		return result;
	}

	private String[] splitExpression(String expression) {
		validateEmpty(expression);

		return expression.trim()
			.split(" ");
	}

	private int calculate(String operator, int number1, int number2) {
		OperatorType operatorType = OperatorType.getByOperator(operator);

		return operatorType.calculate(number1, number2);
	}
}
