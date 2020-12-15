package cargameracing;

import java.util.List;

/**
 * Domain(Model) Role
 * @author minji
 */
public class CarRacingGame {
    Car[] cars;
    TryNo tryNo;

    public CarRacingGame(List<String> carName, int playCount){
        int count = carName.size();
        cars = new Car[count];
        for (int i = 0; i < count; i++) {
            cars[i] = new Car(carName.get(i));
        }
        this.tryNo = new TryNo(playCount);
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
