package race;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public CarRace(int carCount, int tryCount, ForwardCheck forwardCheck) {
        this.tryCount = tryCount;
        initCar(carCount, forwardCheck);
    }

    public List<Car> proceedRound() {
        checkCarForward();
        tryCount--;
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean checkTryCount() {
        return tryCount > 0;
    }

    private void initCar(int carCount, ForwardCheck forwardCheck) {
        for(int i = 0; i < carCount; i++) {
            this.cars.add(new Car(forwardCheck));
        }
    }

    private void checkCarForward() {
        for (Car car : cars) {
            car.forward();
        }
    }
}
