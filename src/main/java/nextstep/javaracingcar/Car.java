package nextstep.javaracingcar;

public class Car {
    private final String name;
    private Distance distance;
    private final CarEngine engine;

    public Car(final String name, final CarEngine engine) {
        this.name = name;
        this.distance = Distance.ZERO;
        this.engine = engine;
    }

    public void move() {
        this.distance = this.distance.plus(engine.work());
    }

    public CarDashboard dashboard() {
        return new CarDashboard(name, distance);
    }
}
