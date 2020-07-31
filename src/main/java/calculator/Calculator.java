package calculator;

import calculator.expression.Expression;

/**
 * 문자열 사칙연산 계산기
 */
public class Calculator {
	/**
	 * 문자열 사칙계산 main method
	 * @param value
	 * @return
	 */
	public static int process(String value) {
		Expression expression = new Expression(value);
		int result = expression.getNextNumber();

		//operator 수 만큼 연산을 수행하므로 연산자가 있는지 먼저 확인.
		while(expression.hasNextOperator() && expression.hasNextNumber()) {
			int a = result;
			String operator = expression.getNextOperator();
			int b = expression.getNextNumber();

			result = calculate(operator, a, b);
		}

		return result;
	}

	public static int calculate(String operator, int a, int b) {
		switch (operator) {
			case "+":
				return add(a, b);
			case "-":
				return subtract(a, b);
			case "*":
				return multiply(a, b);
			case "/":
				return divide(a, b);
		}

		throw new IllegalArgumentException();
	}

	private static int add(int a, int b) {
		return a + b;
	}

	private static int subtract(int a, int b) {
		return a - b;
	}

	private static int multiply(int a, int b) {
		return a * b;
	}

	private static int divide(int a, int b) {
		if (b == 0) {
			throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
		}

		return a / b ;
	}
}
