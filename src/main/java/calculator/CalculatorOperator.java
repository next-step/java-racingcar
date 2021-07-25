package calculator;

import java.util.Arrays;

public enum CalculatorOperator {
	PLUS("+") {
		public CalculatorNumber operate(CalculatorNumber left, CalculatorNumber right) {
			return left.add(right);
		}
	},

	MINUS("-") {
		public CalculatorNumber operate(CalculatorNumber left, CalculatorNumber right) {
			return left.sub(right);
		}
	},

	MULTIPLY("*") {
		public CalculatorNumber operate(CalculatorNumber left, CalculatorNumber right) {
			return left.mul(right);
		}
	},

	DIVIDE("/") {
		public CalculatorNumber operate(CalculatorNumber left, CalculatorNumber right) {
			return left.div(right);
		}
	};

	private final String operator;

	CalculatorOperator(String s) {
		this.operator = s;
	}

	public abstract CalculatorNumber operate(CalculatorNumber two, CalculatorNumber three);

	public static CalculatorOperator getCalculatorOperator(String value) {
		CalculatorOperator[] operators = CalculatorOperator.values();
		int i = 0;
		while(i < operators.length && !operators[i].operator.equals(value)) {
			i++;
		}
		if(i >= operators.length) {
			throw new IllegalArgumentException();
		}
		return operators[i];
	}
}
