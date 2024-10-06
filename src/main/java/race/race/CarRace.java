package race.race;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import race.car.Car;
import race.car.CarName;

public class CarRace {

    private static final int MAX_RANGE = 10;

    private List<Car> cars = new ArrayList<>();
    private TryCount tryCount;

    public CarRace(List<Car> cars, TryCount tryCount) {
        this.tryCount = tryCount;
        this.cars.addAll(cars);
    }

    public CarRace(String[] carNames, TryCount tryCount) {
        this.tryCount = tryCount;
        initCar(carNames);
    }

    public void proceedRound() {
        proceed();
        this.tryCount = tryCount.decrease();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public boolean isPlus() {
        return tryCount.isPlus();
    }

    public List<String> getRaceResult() {
        return getWinners(calculateMaxPosition());
    }

    private List<String> getWinners(int maxPosition) {
        List<String> raceResult = new ArrayList<>();
        for (Car car : cars) {
            raceResult.add(collectWinners(car, maxPosition));
        }

        raceResult.removeIf(String::isBlank);
        return raceResult;
    }

    private void initCar(String[] carNames) {
        for(String carName : carNames) {
            this.cars.add(new Car(new CarName(carName)));
        }
    }

    private void proceed() {
        for (Car car : cars) {
            car.forward(getRandomNumber());
        }
    }

    private RandomNumber getRandomNumber() {
        return new RandomNumber(new Random().nextInt(MAX_RANGE));
    }

    private String collectWinners(Car car, int maxPosition) {
        if (car.isMaxPosition(maxPosition)) {
            return car.getCarName();
        }
        return "";
    }

    private int calculateMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = compareMaxPosition(car, maxPosition);
        }
        return maxPosition;
    }

    private int compareMaxPosition(Car car, int maxPosition) {
        return car.compareWithMaxPosition(maxPosition);
    }
}
