package carracing.exception;

public class RacerNameLimitException extends IllegalArgumentException {
    private static final String MESSAGE = "자동차 이름의 길이는 5를 초과할 수 없습니다";
    public RacerNameLimitException() {
        throw new IllegalArgumentException(MESSAGE);
    }
}
