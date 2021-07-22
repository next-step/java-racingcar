package calculator;

public class CalculatorPlusOperator implements CalculatorOperator {
	@Override
	public CalculatorNumber operate(CalculatorNumber left, CalculatorNumber right) {
		return left.add(right);
	}
}
