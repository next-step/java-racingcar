package racingcar;

public class RacingCarException extends RuntimeException {
    private RacingCarErrorCode errorCode;

    public RacingCarException(RacingCarErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}

