package racingcar.model;

import racingcar.dto.CarName;
import racingcar.strategy.MovingStrategy;
import racingcar.util.RandomNumberUtils;

import java.util.Random;

public class Car {
    private int position;
    private CarName name;
    private static int INIT_POSITION = 0;

    public Car(CarName name) {
        this.name = name;
        this.position = INIT_POSITION;
    }

    public CarName getName() {
        return name;
    }

    public int getPosition() {
        return this.position;
    }

    public void move(MovingStrategy movingStrategy) {
        if (movingStrategy.movable()) {
            this.position++;
        }
    }
}
