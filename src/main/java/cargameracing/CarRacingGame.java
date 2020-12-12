package cargameracing;

import java.util.Random;

/**
 * Domain(Model) Role
 * @author minji
 */
public class CarRacingGame {
    Car[] cars;

    public CarRacingGame(int carCount) {
        cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
    }

    public void playGame(MovingStrategy movingStrategy) {
        for (int j = 0; j < cars.length; j++) {
            cars[j].junjinUp(movingStrategy);
        }
    }

    public Car[] getCars() {
        return cars;
    }
}
