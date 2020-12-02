package calculator;

class Accumulator {

	private Long result;

	Accumulator(Long initValue) {
		this.result = initValue;
	}

	void applyOperator(Operator operator, Long operand) {
		this.result = operator.operate(this.result, operand);
	}

	Long getResult() {
		return result;
	}
}
