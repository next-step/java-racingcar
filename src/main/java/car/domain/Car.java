package car.domain;

import car.logic.NumberGenerator;

public class Car {
    private final int MOVING_LIMIT = 4;
    private CarName name;
    private Position position;
    public String getName() {
        return this.name.getName();
    }

    public Car(String carName) {
        this.name = new CarName(carName);
    }

    public int move() {
        int randomNum = NumberGenerator.getRandomNumber();
        if (randomNum >= MOVING_LIMIT) {
            this.position.increasePosition();
        }
        return randomNum;
    }

    public int getPosition() {
        return this.position.getPosition();
    }

}
