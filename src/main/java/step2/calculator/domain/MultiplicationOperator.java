package step2.calculator.domain;

public class MultiplicationOperator implements Operator {
	@Override
	public Integer operate(final Integer result, final Integer number) {
		return result * number;
	}
}
