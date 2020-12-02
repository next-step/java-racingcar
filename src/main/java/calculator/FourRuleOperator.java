package calculator;

public enum FourRuleOperator implements Operator {

	PLUS((x, y) -> x + y),
	MINUS((x, y) -> x - y),
	MULTIPLY((x, y) -> x * y),
	DIVIDE((x, y) -> x / y);

	FourRuleOperator(Operator operator) {
		this.operator = operator;
	}

	private Operator operator;

	@Override
	public Long operate(Long firstOperand, Long secondOperand) {
		return operator.operate(firstOperand, secondOperand);
	}
}
