package racinggame.domain;

import racinggame.domain.random.RandomGenerator;
import racinggame.domain.random.RandomRule;

public class Car {

    private static final int GO_POSSIBLE_VALUE = 4;

    private final String carName;
    private int location;

    public Car(String carName, int location) {
        this.carName = carName;
        this.location = location;
    }

    public int getLocation() {
        return location;
    }

    public String getCarName() {
        return carName;
    }

    public void move(RandomRule randomRule) {
        if (randomRule.getRandomValue() >= GO_POSSIBLE_VALUE) {
            location++;
        }
    }
}
