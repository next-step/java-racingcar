package car.domain.model;

import car.utils.RandomNumberGenerator;

public class Car {

    private final int MOVING_LIMIT = 4;
    private int position = 0;
    private CarName name;


    public Car(final CarName carName) {
        this.name = carName;
    }

    public int move() {
        int randomNum = RandomNumberGenerator.getRandomNumber();
        if (randomNum >= MOVING_LIMIT) {
            this.position++;
        }
        return randomNum;
    }

    public String getName() {
        return this.name.getText();
    }

    public int getPosition() {
        return this.position;
    }

}
