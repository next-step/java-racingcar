package racing.domain;

public class CarContext {

    private final Car car;

    public CarContext(Car car) {
        this.car = car;
    }

    public String getName() {
        return car.getName();
    }

    public int getMovedDistance() {
        return car.getMovedDistance();
    }
}
