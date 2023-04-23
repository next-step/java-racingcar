package racingcar.domain;

public class Score {
    private final Point point;
    private final Name name;

    public Score(Car car) {
        this(car.findCarPoint(), car.findCarName());
    }

    public Score(int point, String carName) {
        this.point = new Point(point);
        this.name = new Name(carName);
    }

    public int findPoint() {
        return point.getPoint();
    }

    public String findCarName() {
        return name.getName();
    }
}
