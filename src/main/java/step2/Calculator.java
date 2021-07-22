package step2;

import static step2.Converter.*;
import static step2.Validator.*;

public class Calculator {

	public String[] expressionInit(String expression) {
		validateExpression(expression);

		return expression.trim()
			.split(" ");
	}

	public int calculate(String expression) {
		String[] operands = expressionInit(expression);

		int number1 = stringToInt(operands[0]);
		for (int i = 1; i < operands.length; i += 2) {
			int number2 = stringToInt(operands[i + 1]);
			String operator = operands[i];

			number1 = operate(operator, number1, number2);
		}

		return number1;
	}

	private int operate(String operator, int number1, int number2) {
		validateOperator(operator);

		int result = 0;

		if (operator.equals("+"))
			result = plus(number1, number2);
		else if (operator.equals("-"))
			result = minus(number1, number2);
		else if (operator.equals("*"))
			result = multiply(number1, number2);
		else if (operator.equals("/"))
			result = divide(number1, number2);

		return result;
	}

	public int plus(int number1, int number2) {
		return number1 + number2;
	}

	public int minus(int number1, int number2) {
		return number1 - number2;
	}

	public int multiply(int number1, int number2) {
		return number1 * number2;
	}

	public int divide(int number1, int number2) {
		if (number2 == 0) {
			throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
		}
		return number1 / number2;
	}
}
