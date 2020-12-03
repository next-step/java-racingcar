package calculator;

public enum Operator {
	ADD("+") {
		@Override
		public NumberFactor calculate(NumberFactor base, NumberFactor target) {
			return NumberFactor.createFactor(Math.addExact(base.valueOfFactor(), target.valueOfFactor()));
		}
	},
	SUBTRACT("-") {
		@Override
		public NumberFactor calculate(NumberFactor base, NumberFactor target) {
			return NumberFactor.createFactor(base.valueOfFactor() - target.valueOfFactor());
		}
	},
	MULTIPLY("*") {
		@Override
		public NumberFactor calculate(NumberFactor base, NumberFactor target) {
			return NumberFactor.createFactor(Math.multiplyExact(base.valueOfFactor(), target.valueOfFactor()));
		}
	},
	DIVIDE("/") {
		@Override
		public NumberFactor calculate(NumberFactor base, NumberFactor target) {
			return NumberFactor.createFactor(base.valueOfFactor() / target.valueOfFactor());
		}
	};

	private final String symbol;

	Operator(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbol() {
		return symbol;
	}

	abstract NumberFactor calculate(NumberFactor base, NumberFactor target);
}
