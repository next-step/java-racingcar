package car.domain.model;

import car.utils.RandomNumberGenerator;

public class Car {

    private final int MOVING_LIMIT = 4;
    private int position = 0;
    public String name;


    public Car(final String carName) {
        this.name = carName;
    }

    // TODO : [Review 14] Random test 어떻게 해야할지 깊게 고민해 보기
    public int move() {
        int randomNum = RandomNumberGenerator.getRandomNumber();
        if (randomNum >= MOVING_LIMIT) {
            this.position++;
        }
        return randomNum;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

}
