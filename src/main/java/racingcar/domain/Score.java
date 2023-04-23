package racingcar.domain;

public class Score {
    private final int point;
    private final String carName;

    public Score(Car car) {
        this(car.findCarPoint(), car.findCarName());
    }

    public Score(int point, String carName) {
        this.point = point;
        this.carName = carName;
    }

    public int findPoint() {
        return point;
    }

    public String findCarName() {
        return carName;
    }
}
