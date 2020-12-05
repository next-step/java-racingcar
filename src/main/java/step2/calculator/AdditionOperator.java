package step2.calculator;

public class AdditionOperator implements Operator {
	@Override
	public Integer operate(final Integer result, final Integer number) {
		return result + number;
	}
}
