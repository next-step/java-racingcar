package race;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRace {

    private static final int MAX_RANGE = 10;

    private List<Car> cars = new ArrayList<>();
    private int tryCount;

    public CarRace(String[] carNames, int tryCount) {
        this.tryCount = tryCount;
        initCar(carNames);
    }

    public void proceedRound() {
        proceed();
        tryCount--;
    }

    public List<Car> getCars() {
        return cars;
    }

    public boolean checkTryCount() {
        return tryCount > 0;
    }

    public List<String> getRaceResult() {
        return getWinners(calculateMaxPosition(cars.size(), getCars()));
    }

    private List<String> getWinners(int maxPosition) {
        List<String> raceResult = new ArrayList<>();
        for (Car car : cars) {
            collectWinners(car, maxPosition, raceResult);
        }

        return raceResult;
    }

    private void initCar(String[] carNames) {
        for(String carName : carNames) {
            this.cars.add(new Car(carName));
        }
    }

    private void proceed() {
        for (Car car : cars) {
            car.forward(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return new Random().nextInt(MAX_RANGE);
    }

    private void collectWinners(Car car, int maxPosition, List<String> raceResult) {
        if (car.isMaxPosition(maxPosition)) {
            raceResult.add(car.getCarName());
        }
    }

    private int calculateMaxPosition(int size, List<Car> cars) {
        int maxPosition = 0;
        for (int i = 0; i < size; i++) {
            maxPosition = compareMaxPosition(cars.get(i), maxPosition);
        }
        return maxPosition;
    }

    private int compareMaxPosition(Car car, int maxPosition) {
        return car.compareWithMaxPosition(maxPosition);
    }
}
