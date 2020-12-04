package calculator;

public class Calculator {

	public static int plus(int number1, int number2) {

		return number1 + number2;
	}

	public static int minus(int number1, int number2) {

		return number1 - number2;
	}

	public static int mod(int number1, int number2) {

		return number1 / number2;
	}

	public static int multi(int number1, int number2) {

		return number1 * number2;
	}

	public static int calculate(int number1, int number2, String sign) {

		if ("+".equals(sign)) {
			return plus(number1, number2);
		}

		if ("-".equals(sign)) {
			return minus(number1, number2);
		}

		if ("*".equals(sign)) {
			return multi(number1, number2);
		}

		if ("/".equals(sign)) {
			return  mod(number1, number2);
		}

		return 0;
	}
}
