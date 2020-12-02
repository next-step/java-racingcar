package calculator;

public class InputFactorOverflowException extends IllegalArgumentException {
	private final String overFlowMessage = "NumberFactor must be more than OperatorFactor in calculation expression";

	@Override
	public String getMessage() {
		return overFlowMessage;
	}
}
