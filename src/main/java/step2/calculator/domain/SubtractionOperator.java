package step2.calculator.domain;

public class SubtractionOperator implements Operator {
	@Override
	public Integer operate(final Integer result, final Integer number) {
		return result - number;
	}
}
