package study.calculator;

public enum CustomErrorMessage {
    DIVISION_BY_ZERO(0, "0으로 나눌 수 없습니다."),
    EMPTY_INPUT(1, "빈값을 입력하실 수 없습니다."),
    ILLEGAL_OPERATOR(2, "연산자는 (+,-,*,/)만 사용 가능합니다."),
    ILLEGAL_OPERAND(3, "피연산자는 정수형 숫자로 입력하세요."),
    UNCOMPLETED_INPUT(4, "입력값이 정상적으로 종료되지않았습니다.");

    private int code;
    private String errorMessage;

    CustomErrorMessage(int code, String errorMessage){
        this.code = code;
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage(){
        return errorMessage;
    }

}
