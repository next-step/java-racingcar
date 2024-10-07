package step3.exception;

public class RaceParamUnvalidException extends RuntimeException {
	private final String message = "경주 할 파라미터는 1 이상인 양수여야 합니다.";
}
