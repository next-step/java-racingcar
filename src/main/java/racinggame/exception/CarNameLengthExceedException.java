package racinggame.exception;

public class CarNameLengthExceedException extends RuntimeException {

    public CarNameLengthExceedException() {
        super("자동차의 이름은 5자를 초과할 수 없습니다.");
    }
}
