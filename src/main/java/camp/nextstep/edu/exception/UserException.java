package camp.nextstep.edu.exception;

public class UserException extends IllegalArgumentException {
	public UserException() {
		super("정상적인 사용자 값이 아닙니다.");
	}
}
