package step3.study.domain;

import step3.study.util.NumberGenerator;

public class Driver {
    private final String name;
    private final Car car;

    public Driver(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public void moveCar(NumberGenerator numberGenerator) {
        car.move(numberGenerator);
    }

    public int position() {
        return car.position();
    }

    public String name() {
        return name;
    }
}
