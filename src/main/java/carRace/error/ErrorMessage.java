package carRace.error;

public enum ErrorMessage {

    INVALID_INPUT_TYPE_STRING("입력값의 타입이 문자열입니다. 정수를 입력해주세요 "),

    INVALID_INPUT_TYPE_INT("입력값의 타입이 정수형입니다. 문자열을 입력해주세요 "),

    INVALID_INPUT_EMPTY("입력값이 없습니다. 경주할 자동차 이름을 다시 입력해주세요. "),

    ILLEGAL_STATE("비정상 경로로 접근하였습니다. 다시 실행해주세요. "),

    UNEXPECTED_ERROR("예기치 못한 예외가 발생되었습니다. 다시 실행해주세요. ");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
