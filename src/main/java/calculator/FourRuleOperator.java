package calculator;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public enum FourRuleOperator implements Operator {

	PLUS("+", (x, y) -> x + y),
	MINUS("-", (x, y) -> x - y),
	MULTIPLY("*", (x, y) -> x * y),
	DIVIDE("/", (x, y) -> x / y);

	FourRuleOperator(String identifier, Operator operator) {
		this.identifier = identifier;
		this.operator = operator;
	}

	private String identifier;
	private Operator operator;

	public static Optional<FourRuleOperator> of(String identifier) {
		return Stream.of(values())
				.filter(fourRuleOperator -> fourRuleOperator.isIdentifierEqual(identifier))
				.findFirst();
	}

	@Override
	public Long operate(Long firstOperand, Long secondOperand) {
		return operator.operate(firstOperand, secondOperand);
	}

	private boolean isIdentifierEqual(String identifier) {
		return Objects.equals(this.identifier, identifier);
	}
}
