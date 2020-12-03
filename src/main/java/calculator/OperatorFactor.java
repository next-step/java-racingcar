package calculator;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OperatorFactor {
	private final Operator mathOperator;

	public OperatorFactor(String symbol) {
		this.mathOperator = Stream.of(Operator.values())
			.filter(operator -> operator.getSymbol().equals(symbol))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	public static Queue<OperatorFactor> getOperatorFactors(String expression) {
		return Arrays.stream(expression.split(CalculationExpressionFactory.SEPARATOR_CALCULATION_EXPRESSION))
			.filter(OperatorFactor::validator)
			.map(OperatorFactor::new).collect(Collectors.toCollection(LinkedList::new));
	}

	private static boolean validator(String value) {
		return Stream.of(Operator.values())
			.anyMatch(operator -> operator.getSymbol().equals(value));
	}

	public Operator valueOfFactor() {
		return mathOperator;
	}

}
