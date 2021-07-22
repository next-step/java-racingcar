package calculator;

public class CalculatorOperatorFactory {
	public static CalculatorOperator create(String s) {
		if(s.equals(CalculatorOperator.PLUS)) {
			return new CalculatorPlusOperator();
		}
		if(s.equals(CalculatorOperator.MINUS)) {
			return new CalculatorMinusOperator();
		}
		throw new IllegalArgumentException();
	}
}
