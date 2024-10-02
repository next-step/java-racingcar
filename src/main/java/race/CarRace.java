package race;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    public static final int INIT_MAX_POSITION = Integer.MIN_VALUE;
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

    public List<String> getRaceResult() {
        List<String> raceResult = new ArrayList<>();

        int maxPosition = calculateMaxPosition(cars.size(), INIT_MAX_POSITION, getCars());

        for (Car car : cars) {
            collectWinners(car, maxPosition, raceResult);
        }

        return raceResult;
    }

    private void initCar(String[] carNames, ForwardCheck forwardCheck) {
        for(String carName : carNames) {
            this.cars.add(new Car(carName, forwardCheck));
        }
    }

    private void proceed() {
        for (Car car : cars) {
            car.forward();
        }
    }

    private void collectWinners(Car car, int maxPosition, List<String> raceResult) {
        if (car.isMaxPosition(maxPosition)) {
            raceResult.add(car.getCarName());
        }
    }

    private int calculateMaxPosition(int size, int maxPosition, List<Car> cars) {
        for (int i = 0; i < size; i++) {
            maxPosition = compareMaxPosition(cars.get(i), maxPosition);
        }
        return maxPosition;
    }

    private int compareMaxPosition(Car car, int maxPosition) {
        return car.compareWithMaxPosition(maxPosition);
    }
}
