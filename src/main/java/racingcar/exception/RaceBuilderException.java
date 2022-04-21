package racingcar.exception;

public class RaceBuilderException extends RuntimeException {
    public RaceBuilderException() {
        super("RaceBuilder 에서 오류가 발생하였습니다");
    }

    public RaceBuilderException(String message) {
        super(message);
    }
}
