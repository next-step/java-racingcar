package calculator;

import java.util.stream.Stream;

import calculator.helper.NumberFactorHelper;


public enum Operator {
	ADD("+") {
		@Override
		public NumberFactor calculate(InputFactor<Integer> base, InputFactor<Integer> target) {
			return NumberFactorHelper.add(base, target);
		}
	},
	SUBTRACT("-") {
		@Override
		public NumberFactor calculate(InputFactor<Integer> base, InputFactor<Integer> target) {
			return NumberFactorHelper.subtract(base, target);
		}
	},
	MULTIPLY("*") {
		@Override
		public NumberFactor calculate(InputFactor<Integer> base, InputFactor<Integer> target) {
			return NumberFactorHelper.multiply(base, target);
		}
	},
	DIVIDE("/") {
		@Override
		public NumberFactor calculate(InputFactor<Integer> base, InputFactor<Integer> target) {
			return NumberFactorHelper.divide(base, target);
		}
	};

	private final String symbol;

	Operator(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	public static Operator of(String symbol) {
		return Stream.of(Operator.values())
			.filter(operator -> operator.getSymbol().equals(symbol))
			.findFirst()
			.orElseThrow(IllegalArgumentException::new);
	}

	public static boolean isContainsMathOperator(String symbol) {
		return Stream.of(Operator.values())
			.anyMatch(operator -> operator.getSymbol().equals(symbol));
	}

	abstract NumberFactor calculate(InputFactor<Integer> base, InputFactor<Integer> target);
}
