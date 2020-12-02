package calculator;

public class IllegalCalculationFormatException extends IllegalArgumentException {
	private final String illegalCalculationFormatMessage = "calculation expression format error";

	@Override
	public String getMessage() {
		return illegalCalculationFormatMessage;
	}
}
