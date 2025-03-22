package step5.racingcar3.domain;

import java.util.Objects;

public class Car {

    private final CarName carName;
    private final CarEngine carEngine;
    private final Position position;

    public Car(CarName carName, CarEngine carEngine) {
        this.carName = carName;
        this.carEngine = carEngine;
        this.position = new Position();
    }

    public Car(CarName carName, CarEngine carEngine, Position position) {
        this.carName = carName;
        this.carEngine = carEngine;
        this.position = position;
    }

    public Position position() {
        return position;
    }

    public CarName name() {
        return carName;
    }

    public void run() {
        if (carEngine.canGo()) {
            position.increase();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return carName.equals(car.carName) && carEngine.equals(car.carEngine) && position.equals(car.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carName, carEngine, position);
    }

}
