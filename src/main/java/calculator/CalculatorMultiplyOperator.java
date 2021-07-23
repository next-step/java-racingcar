package calculator;

public class CalculatorMultiplyOperator implements CalculatorOperator {
	@Override
	public CalculatorNumber operate(CalculatorNumber left, CalculatorNumber right) {
		return left.mul(right);
	}
}
