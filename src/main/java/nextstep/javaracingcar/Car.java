package nextstep.javaracingcar;

import nextstep.javaracingcar.step2.PositiveNumber;

public class Car {
    private PositiveNumber distance;
    private final CarEngine engine;

    public Car(final CarEngine engine) {
        this.distance = PositiveNumber.ZERO;
        this.engine = engine;
    }
    public void move() {
        this.distance = this.distance.plus(engine.work());
    }

    public CarDashboard dashboard() {
        return new CarDashboard(distance);
    }

}
