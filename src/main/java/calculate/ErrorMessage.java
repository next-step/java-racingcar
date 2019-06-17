package calculate;

public enum ErrorMessage {
    EMPTY_VALUE("수식을 입력해주세요."),
    INCORRECT_END_CHARACTER("마지막 피연산자가 입력되지 않았습니다."),
    INCORRECT_MATH_SIGN("사칙연산 기호를 정확히 입력해주세요. 입력 가능한 기호 : +, -, *, /"),
    INCORRECT_NUMBER("숫자를 정확히 입력해주세요.");
    
    private String message;
    
    ErrorMessage(String message) {
        this.message = message;
    }
    
    public String getMessage() {
        return message;
    }
}
