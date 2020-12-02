package calculator;

public class OperatorFactor implements InputFactor<Operator> {
	private final Operator mathOperator;

	public OperatorFactor(String symbol) {
		this.mathOperator = Operator.of(symbol);
	}

	@Override
	public Operator valueOfFactor() {
		return mathOperator;
	}

}
