package utils.exception;

public class CarNameExceedFiveCharacterException extends RuntimeException{
    public CarNameExceedFiveCharacterException() {
        super("자동차 이름은 5글자 이하여야만 합니다.");
    }

    public CarNameExceedFiveCharacterException(String message) {
        super(message);
    }
}
