package calculator;

import java.util.stream.Stream;

public class OperatorFactor {
	private final Operator mathOperator;

	public OperatorFactor(String symbol) {
		this.mathOperator = Stream.of(Operator.values())
			.filter(operator -> operator.getSymbol().equals(symbol))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	public static boolean validator(String value) {
		return Stream.of(Operator.values())
			.anyMatch(operator -> operator.getSymbol().equals(value));
	}

	public Operator valueOfFactor() {
		return mathOperator;
	}

}
