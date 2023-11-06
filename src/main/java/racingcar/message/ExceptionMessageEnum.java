package racingcar.message;

public enum ExceptionMessageEnum {
    ERROR_STRING_INPUT("문자열을 입력하셨습니다."),
    ERROR_INPUT_CAR_NAME("자동차 이름은 5자를 초과 할 수 없습니다."),
    ERROR_INPUT_CAR_NAME_EMPTY("자동차 이름이 없는 경우가 있습니다."),
    ERROR_INPUT_UNDER_ZERO("0보다 큰 숫자를 입력해주세요.");

    private final String message;

    ExceptionMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
