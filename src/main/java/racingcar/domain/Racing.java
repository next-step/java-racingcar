package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Racing {

    private static final String SPLITTER = ",";
    private final String[] CAR_NAMES;
    private final List<Car> CARS;
    private final MovingStrategy MOVING_STRATEGY;

    public Racing(String[] CAR_NAMES, List<Car> CARS, MovingStrategy MOVING_STRATEGY) {
        this.CAR_NAMES = CAR_NAMES;
        this.CARS = CARS;
        this.MOVING_STRATEGY = MOVING_STRATEGY;
    }

    public static List<Car> create(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(new CarName(carName)));
        }
        return cars;
    }

    public void race() {
        for (Car car : CARS) {
            car.move(MOVING_STRATEGY);
        }
    }

    public List<Car> getRacingCars() {
        return CARS;
    }

    public String findWinner() {
        int maxMoveCount = findMaxMoveCount(CARS);
        List<String> winners = findWinnerCarNames(CARS, maxMoveCount);
        return findFinalWinners(winners);
    }

    private String findFinalWinners(List<String> winners) {
        return String.join(SPLITTER, winners);
    }

    public List<String> findWinnerCarNames(List<Car> cars, int maxMoveCount) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            CarName carName = car.getCarName();
            maxMoved(maxMoveCount, winners, car, carName);
        }
        return winners;
    }

    public void maxMoved(int maxMoveCount, List<String> winners, Car car, CarName carName) {
        if (car.getMoveCount() == maxMoveCount) {
            winners.add(carName.getStringCarName());
        }
    }

    public int findMaxMoveCount(List<Car> cars) {
        int maxMoveCount = 0;
        for (Car car : cars) {
            maxMoveCount = max(maxMoveCount, car.getMoveCount());
        }
        return maxMoveCount;
    }
}
