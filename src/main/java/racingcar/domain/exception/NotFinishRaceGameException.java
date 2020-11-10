package racingcar.domain.exception;

public class NotFinishRaceGameException extends RuntimeException {

    private static final String ERROR_MESSAGE = " 라운드가 아직 남았어요";

    public NotFinishRaceGameException(int round) {
        super(round + ERROR_MESSAGE);
    }
}
