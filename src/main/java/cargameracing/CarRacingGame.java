package cargameracing;

import java.util.List;
import java.util.Random;

/**
 * Domain(Model) Role
 * @author minji
 */
public class CarRacingGame {
    Car[] cars;

    public CarRacingGame(List<Name> carName){
        int count = carName.size();
        cars = new Car[count];
        for (int i = 0; i < count; i++) {
            cars[i] = new Car(carName.get(i));
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
