package racinggame.exception;

public class OverCarNameLengthException extends RuntimeException{

    private static final String OVER_CAR_NAME_LENGTH_TEXT = "자동차 이름은 5자를 초과할 수 없습니다.";

    public OverCarNameLengthException() {
        super(OVER_CAR_NAME_LENGTH_TEXT);
    }

}
