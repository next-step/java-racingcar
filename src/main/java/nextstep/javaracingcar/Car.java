package nextstep.javaracingcar;

public class Car {
    private final String name;
    private PositiveNumber distance;
    private final CarEngine engine;

    public Car(final String name, final CarEngine engine) {
        this.name = name;
        this.distance = PositiveNumber.ZERO;
        this.engine = engine;
    }

    public void move() {
        this.distance = this.distance.plus(engine.work());
    }

    public CarDashboard dashboard() {
        return new CarDashboard(name, distance);
    }
}
