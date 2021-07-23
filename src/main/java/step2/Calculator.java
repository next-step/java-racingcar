package step2;

import static step2.Converter.*;
import static step2.Validator.*;

public class Calculator {

	public String[] splitExpression(String expression) {
		validateEmpty(expression);

		return expression.trim()
			.split(" ");
	}

	public int execute(String expression) {
		String[] elements = splitExpression(expression);

		int number1 = stringToInt(elements[0]);
		for (int i = 1; i < elements.length; i += 2) {
			int number2 = stringToInt(elements[i + 1]);
			String operator = elements[i];

			number1 = calculate(operator, number1, number2);
		}

		return number1;
	}

	private int calculate(String operator, int number1, int number2) {
		validateOperator(operator);

		OperatorType operatorType = OperatorType.getByOperator(operator);

		return operatorType.calculateByOperator(number1, number2);
	}
}
