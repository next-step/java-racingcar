package racingcar.common.exception;

public class InvalidCarEngineOperateInputException extends IllegalArgumentException {

    private static final String message = "입력 범위를 벗어났습니다. (0 ~ 9)";

    public InvalidCarEngineOperateInputException() {
        super(message);
    }
}
