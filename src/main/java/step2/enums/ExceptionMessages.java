package step2.enums;

public enum  ExceptionMessages {

    INPUT_VALUE_IS_NULL_OR_EMPTY("입력값이 비어있습니다."),
    NONE_VALID_INPUT_VALUE("올바른 입력값이 아닙니다."),
    IS_NOT_OPERATOR("사칙 연산 기호가 아닙니다."),
    CAN_NOT_DIVIDE_ZERO("0으로 나눌 수 없습니다.");

    private String message;

    ExceptionMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
