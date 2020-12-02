package calculator;

class OperatingEntry {

	private FourRuleOperator fourRuleOperator;
	private Long operand;

	private OperatingEntry(FourRuleOperator fourRuleOperator, Long operand) {
		this.fourRuleOperator = fourRuleOperator;
		this.operand = operand;
	}

	static OperatingEntry of(FourRuleOperator fourRuleOperator, Long operand) {
		if (fourRuleOperator == null) {
			throw new IllegalArgumentException("fourRuleOperator must be nonNull");
		}

		if (operand == null) {
			throw new IllegalArgumentException("operand must be nonNull");
		}

		return new OperatingEntry(fourRuleOperator, operand);
	}

	FourRuleOperator getFourRuleOperator() {
		return fourRuleOperator;
	}

	Long getOperand() {
		return operand;
	}
}
