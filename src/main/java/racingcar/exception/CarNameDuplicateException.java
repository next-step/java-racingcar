package racingcar.exception;

public class CarNameDuplicateException extends CarNameException {
    private static final String NAME_EMPTY_EXCEPTION_MESSAGE = "자동차 이름은 중복될 수 없습니다.";

    // 네이밍 중복 되는 것도 막는게 좋을것 같아서 추가
    public CarNameDuplicateException() {}

    public String getMessage() {
        return NAME_EMPTY_EXCEPTION_MESSAGE;
    }
}
