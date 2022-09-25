package racinggame.exception;

public class InvalidCarRegistrationException extends RuntimeException {

    public InvalidCarRegistrationException() {
        super("차량은 한 대 이상이어야 합니다.");
    }

}
