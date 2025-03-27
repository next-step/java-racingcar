package racingcar.message;

public class ErrorMessage {

    public static final String INVALID_NUMBER = "숫자를 입력해야 합니다.";
    public static final String POSITIVE_NUMBER = "양수를 입력해야 합니다.";
    public static final String INVALID_NAME = "닉네임은 1자 이상 5자 이하여야 합니다. 다시 입력해주세요.";
    public static final String INVALID_CAR_NAME_LENGTH = "자동차 이름은 1자 이상 5자 이하만 가능합니다.";

    private ErrorMessage() {
    }
}
