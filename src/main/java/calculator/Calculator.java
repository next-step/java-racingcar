package calculator;

public class Calculator {
	public static int calculate(int firstNumber, String symbol, int secondNumber) {
		Operator operator = Operator.valueOfOperator(symbol);
		return operator.calculate(firstNumber, secondNumber);
	}
}
