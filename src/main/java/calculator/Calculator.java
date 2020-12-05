package calculator;

public class Calculator {
	public static int calculate(int firstNumber, String symbol, int secondNumber) {
		Operator operator = Operator.findOperator(symbol);
		return operator.calculate(firstNumber, secondNumber);
	}
}
