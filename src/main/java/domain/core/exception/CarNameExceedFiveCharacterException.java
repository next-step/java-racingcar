package domain.core.exception;

public class CarNameExceedFiveCharacterException extends IllegalArgumentException{
    public CarNameExceedFiveCharacterException() {
        super("자동차 이름은 5글자 이하여야만 합니다.");
    }
}
