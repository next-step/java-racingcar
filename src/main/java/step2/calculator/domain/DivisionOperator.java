package step2.calculator.domain;

public class DivisionOperator implements Operator {

	@Override
	public Integer operate(final Integer result, final Integer number) {
		if (0 == number) {
			throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
		}
		return result / number;
	}

	@Override
	public String getSign() {
		return "/";
	}

}
