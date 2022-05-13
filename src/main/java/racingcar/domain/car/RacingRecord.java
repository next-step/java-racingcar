package racingcar.domain.car;

public class RacingRecord {

    private final Position position;

    public RacingRecord(Position position) {
        this.position = position;
    }

    public static RacingRecord newInstance(Position position) {
        return new RacingRecord(new Position(position.getValue()));
    }

    public int readPosition() {
        return this.position.getValue();
    }
}
