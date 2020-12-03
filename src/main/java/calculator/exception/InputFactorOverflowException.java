package calculator.exception;

public class InputFactorOverflowException extends IllegalArgumentException {
	private static final String OVER_FLOW_MESSAGE = "OperatorFactor cannot be greater than NumberFactor";

	@Override
	public String getMessage() {
		return OVER_FLOW_MESSAGE;
	}
}
