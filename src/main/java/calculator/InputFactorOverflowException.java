package calculator;

public class InputFactorOverflowException extends IllegalArgumentException {
	private final String overFlowMessage = "OperatorFactor cannot be greater than NumberFactor";

	@Override
	public String getMessage() {
		return overFlowMessage;
	}
}
