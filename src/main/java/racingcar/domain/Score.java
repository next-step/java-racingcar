package racingcar.domain;

public class Score {
    private final int point;
    private final String carName;

    public Score(Car car) {
        this.point = car.findCarPoint();
        this.carName = car.findCarName();
    }

    public int findPoint() {
        return point;
    }

    public String findCarName() {
        return carName;
    }
}
