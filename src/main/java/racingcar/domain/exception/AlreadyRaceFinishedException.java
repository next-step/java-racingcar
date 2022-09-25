package racingcar.domain.exception;

public class AlreadyRaceFinishedException extends RuntimeException {
    public AlreadyRaceFinishedException() {
        super("The race has already ended.");
    }
}
