package calculator.exception;

public class IllegalCalculationFormatException extends IllegalArgumentException {
	private static final String ILLEGAL_CALCULATION_FORMAT_MESSAGE = "The calculation expression does not match the format";

	@Override
	public String getMessage() {
		return ILLEGAL_CALCULATION_FORMAT_MESSAGE;
	}
}
