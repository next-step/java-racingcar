package step5;

import step5.enums.MOVE;

public class Car {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private int location = 0;
    private final CarName carName;

    public Car(String name) {
        this.carName = new CarName(name);
    }

    public int getLocation() {
        return this.location;
    }

    public CarName getCarName() {
        return carName;
    }

    public void goOrStop() {
        int luckyNumber = RandomNumberGenerator.getRandomNumberGenerator().getRandomInt();

        if (MOVE.movable(luckyNumber)) {
            this.progress();
        }
    }

    private void progress() {
        this.location += 1;
    }
}
