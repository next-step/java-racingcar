package step2.calculator.domain;

public class AdditionOperator implements Operator {

	@Override
	public Integer operate(final Integer result, final Integer number) {
		return result + number;
	}

	@Override
	public String getSign() {
		return "+";
	}

}
