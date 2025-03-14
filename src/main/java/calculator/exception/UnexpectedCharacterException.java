package calculator.exception;

public class UnexpectedCharacterException extends RuntimeException {

    public UnexpectedCharacterException() {
        super("숫자, 기본 구분자, 커스텀 구분자 외 문자는 입력할 수 없습니다.");
    }

}
