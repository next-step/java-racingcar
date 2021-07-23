package calculator;

public class CalculatorOperatorFactory {
	public static CalculatorOperator create(String s) {
		if(s.equals(CalculatorOperator.PLUS)) {
			return new CalculatorPlusOperator();
		}
		if(s.equals(CalculatorOperator.MINUS)) {
			return new CalculatorMinusOperator();
		}
		if(s.equals((CalculatorOperator.MULTIPLY))) {
			return new CalculatorMultiplyOperator();
		}
		if(s.equals((CalculatorOperator.DIVIDE))) {
			return new CalculatorDivideOperator();
		}
		throw new IllegalArgumentException();
	}
}
