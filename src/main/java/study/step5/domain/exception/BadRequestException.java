package study.step5.domain.exception;

public class BadRequestException extends RuntimeException {

	public BadRequestException(String message) {
		super(message);
	}
}