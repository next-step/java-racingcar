package racingcar.domain;

public class CarStatus {

    private final String name;
    private final int position;

    public CarStatus(Car car) {
        this(car.getName().getName(), car.getPosition());
    }

    private CarStatus(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
