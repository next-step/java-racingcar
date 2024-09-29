package race;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public CarRace(int carCount, int tryCount, RandomNumber randomNumber) {
        this.tryCount = tryCount;
        initCar(carCount, randomNumber);
    }

    public List<Car> proceedRound() {
        checkCarForward();
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTryCount() {
        return tryCount;
    }

    private void initCar(int carCount, RandomNumber randomNumber) {
        for(int i = 0; i < carCount; i++) {
            this.cars.add(new Car(randomNumber));
        }
    }

    private void checkCarForward() {
        for (Car car : cars) {
            car.forward();
        }
    }
}
