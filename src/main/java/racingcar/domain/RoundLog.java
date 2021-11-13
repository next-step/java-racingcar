package racingcar.domain;

public class RoundLog {
    private final Round round;
    private final Car car;

    private RoundLog(Round round, Car car) {
        this.round = round;
        this.car = car;
    }

    public static RoundLog of(Round round, Car car) {
        return new RoundLog(round, car);
    }

    public int round() {
        return round.currentRound();
    }

    public String carName() {
        return car.carName();
    }

    public int position() {
        return car.currentPosition().getPosition();
    }
}
