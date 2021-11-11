package racingcar.domain;

public class RoundLog {
    private final int round;
    private final Car car;
    private final Position position;

    private RoundLog(int round, Car car, Position position) {
        this.round = round;
        this.car = car;
        this.position = position;
    }

    public static RoundLog of(int round, Car car, Position position) {
        return new RoundLog(round, car, position);
    }
}
