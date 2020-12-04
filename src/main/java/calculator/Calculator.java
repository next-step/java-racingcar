package calculator;

import calculator.expression.Expression;

/**
 * 문자열 사칙연산 계산기
 */
public class Calculator {

	private Calculator() {
		throw new AssertionError("해당 클래스는 인스턴스화 할 수 없습니다.");
	}

	/**
	 * 문자열 사칙계산 main method
	 */
	public static int process(String value) {
		Expression expression = new Expression(value);
		int result = expression.getNextNumber();

		//operator 수 만큼 연산을 수행하므로 연산자가 있는지 먼저 확인.
		while (expression.hasNextOperator() && expression.hasNextNumber()) {
			int x = result;
			String operator = expression.getNextOperator();
			int y = expression.getNextNumber();

			result = calculate(operator, x, y);
		}

		return result;
	}

	public static int calculate(String operator, int x, int y) {
		switch (operator) {
			case "+":
				return add(x, y);
			case "-":
				return subtract(x, y);
			case "*":
				return multiply(x, y);
			case "/":
				return divide(x, y);
		}

		throw new IllegalArgumentException("[" + operator + "]  잘못된 연산자 입니다.");
	}

	private static int add(int x, int y) {
		return x + y;
	}

	private static int subtract(int x, int y) {
		return x - y;
	}

	private static int multiply(int x, int y) {
		return x * y;
	}

	private static int divide(int x, int y) {
		if (y == 0) {
			throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
		}

		return x / y;
	}
}