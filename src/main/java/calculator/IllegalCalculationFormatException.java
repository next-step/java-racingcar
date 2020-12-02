package calculator;

public class IllegalCalculationFormatException extends IllegalArgumentException {
	private final String illegalCalculationFormatMessage = "The calculation expression does not match the format";

	@Override
	public String getMessage() {
		return illegalCalculationFormatMessage;
	}
}
