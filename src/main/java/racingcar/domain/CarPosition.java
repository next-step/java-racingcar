package racingcar.domain;

public class CarPosition {
    private final String name;
    private final int position;

    public CarPosition(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public static CarPosition of(Car car) {
        return new CarPosition(car.getName(), car.getPosition());
    }
}
