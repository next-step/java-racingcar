package step5.dto;

import step5.dto.strategy.RunStrategy;

public class Car {
    private Position position;
    private final CarName name;

    public Car(CarName name) {
        this.name = name;
        this.position = new Position();
    }

    public Car(CarName name, Position position) {
        this.name = name;
        this.position = position;
    }

    public Car(Car car) {
        this(car.name, car.position);
    }

    public void run(RunStrategy runStrategy) {
        if(runStrategy.runnable()) {
            this.position = position.plusPosition();
        }
    }

    public Position getPosition() {
        return this.position;
    }

    public CarName getName() {
        return this.name;
    }
}
