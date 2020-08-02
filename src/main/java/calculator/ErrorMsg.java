package calculator;

public enum ErrorMsg {
    NOT_OPERATION_SYMBOL("연산기호를 확인해주세요."),
    IS_NULL_OR_BLANK("입력 값이 null이거나 빈 공백 문자입니다.");

    String msg;
    ErrorMsg(String msg) {
        this.msg = msg;
    }
}
