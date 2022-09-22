package step2;

public class InvalidStringException extends RuntimeException {

    public InvalidStringException() {
        super("숫자 이외의 값은 입력할 수 없습니다.");
    }
}
