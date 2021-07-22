package calculator;

public class CalculatorOperatorFactory {
	public static CalculatorOperator create(String s) {
		return new CalculatorPlusOperator();
	}
}
