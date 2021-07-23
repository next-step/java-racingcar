package calculator;

public class CalculatorMinusOperator implements CalculatorOperator {
	@Override
	public CalculatorNumber operate(CalculatorNumber left, CalculatorNumber right) {
		return left.sub(right);
	}
}
