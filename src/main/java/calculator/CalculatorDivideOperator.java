package calculator;

public class CalculatorDivideOperator implements CalculatorOperator {
	@Override
	public CalculatorNumber operate(CalculatorNumber left, CalculatorNumber right) {
		return left.div(right);
	}
}
