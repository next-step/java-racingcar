package race;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class CarRace {

    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public CarRace(String[] carNames, int tryCount, ForwardCheck forwardCheck) {
        this.tryCount = tryCount;
        initCar(carNames, forwardCheck);
    }

    public List<Car> proceedRound() {
        proceed();
        tryCount--;
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean checkTryCount() {
        return tryCount > 0;
    }

    private void initCar(String[] carNames, ForwardCheck forwardCheck) {
        int carCount = carNames.length;
        for(int i = 0; i < carCount; i++) {
            this.cars.add(new Car(carNames[i], forwardCheck));
        }
    }

    private void proceed() {
        for (Car car : cars) {
            car.forward();
        }
    }
}
