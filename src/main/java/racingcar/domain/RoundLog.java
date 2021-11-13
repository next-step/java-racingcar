package racingcar.domain;

public class RoundLog {
    private final int round;
    private final Car car;

    private RoundLog(int round, Car car) {
        this.round = round;
        this.car = car;
    }

    public static RoundLog of(int round, Car car) {
        return new RoundLog(round, car);
    }

    public int round() {
        return round;
    }

    public String carName() {
        return car.carName();
    }

    public int position() {
        return car.currentPosition().getPosition();
    }
}
