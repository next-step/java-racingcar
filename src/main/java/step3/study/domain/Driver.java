package step3.study.domain;

import step3.study.util.RandomGenerator;

public class Driver {
    private final String name;
    private final Car car;

    public Driver(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public void moveCar(int randomNumber) {
        car.move(randomNumber);
    }

    public String getName() {
        return name;
    }

    public String getDistance() {
        return car.getDistance();
    }

    public String getNameAndNowPosition() {
        return this.name + " : " + car.getDistance();
    }
}
