package racinggame.domain.exception;

public class RacingGameException extends RuntimeException {
    private static final String NOT_EXIST_SNAPSHOTS = "경기기록이 없어 우승자를 찾을 수 없습니다";

    public RacingGameException(String message) {
        super(message);
    }

    public static RacingGameException ofNotExistSnapshots() {
        return new RacingGameException(NOT_EXIST_SNAPSHOTS);
    }
}
