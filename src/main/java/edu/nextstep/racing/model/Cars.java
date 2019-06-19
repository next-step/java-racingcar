package edu.nextstep.racing.model;

import edu.nextstep.racing.utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-racingcar
 * create date  : 2019-06-18 19:12
 */
public class Cars {

    private static final int MOVE_LIMIT_COUNT_FLAG = 4;
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public Cars goForward() {
        this.cars = this.cars.stream()
                .peek(car -> doMoveCheck(car))
                .collect(Collectors.toList());

        return new Cars(this.cars);
    }

    public int getNumberOfCars() {
        return this.cars.size();
    }

    public Car getCarInformation(int carNumber) {
        return this.cars.stream()
                .filter(car -> car.getCarNumber() == carNumber)
                .findFirst()
                .get();
    }

    public int getWinnerScore() {
        int winnerScore = 0;

        for (Car car : cars) {
            winnerScore = NumberUtils.getMax(winnerScore, car.currentPosition());
        }
        return winnerScore;
    }

    public Cars getWinnerPlayer(int winScore) {
        List<Car> tempCars = getWinners(winScore);

        return new Cars(tempCars);
    }

    public List<String> getWinnerName(int winScore) {
        return getWinners(winScore).stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    private List<Car> getWinners(int winScore) {
        return cars.stream()
                .filter(car -> car.currentPosition() >= winScore)
                .collect(Collectors.toList());
    }

    private void doMoveCheck(Car targetCar) {
        if (isMoving()) {
            targetCar.move();
        }
    }

    private boolean isMoving() {
        if (NumberUtils.getRandomNumber() >= MOVE_LIMIT_COUNT_FLAG) {
            return true;
        }
        return false;
    }
}
