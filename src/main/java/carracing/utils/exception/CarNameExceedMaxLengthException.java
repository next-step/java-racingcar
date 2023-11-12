package carracing.utils.exception;

public class CarNameExceedMaxLengthException extends RuntimeException {
    public CarNameExceedMaxLengthException() {
        super("차의 길이는 5글자를 초과할 수 없습니다.");
    }
}
