package calculator;

class Accumulator {

	private Long result;

	private Accumulator(Long initValue) {
		this.result = initValue;
	}

	static Accumulator of(Long initValue) {
		if (initValue == null) {
			throw new IllegalArgumentException("initValue must be nonNull");
		}
		return new Accumulator(initValue);
	}

	void applyOperatingEntry(OperatingEntry operatingEntry) {
		applyOperator(operatingEntry.getFourRuleOperator(), operatingEntry.getOperand());
	}

	void applyOperator(Operator operator, Long operand) {
		this.result = operator.operate(this.result, operand);
	}

	Long getResult() {
		return result;
	}
}
