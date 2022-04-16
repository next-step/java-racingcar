package racing.exception;

public class RacingCarNotFoundException extends RacingException {
    private static final String MESSAGE = "레이싱카가 존재하지 않습니다.";

    public RacingCarNotFoundException(String carName) {
        super(MESSAGE + " (carName: " + carName + ")");
    }

}
