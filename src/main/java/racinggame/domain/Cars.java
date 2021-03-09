package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int MAX_BOUND = 10;

    private final List<Car> cars;

    public Cars(String carNames) {
        this(createCars(carNames));
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    private static List<Car> createCars(String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        String[] splitedCarNames = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String splitedCarName : splitedCarNames) {
            cars.add(new Car(splitedCarName));
        }
        return cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(getRandomNo());
        }
    }

    private int getRandomNo() {
        Random random = new Random();
        return random.nextInt(MAX_BOUND);
    }

    public int size() {
        return cars.size();
    }

    public Winners findWinners() {
        return winners(maxPosition());
    }

    private Winners winners(Position maxPosition) {
        Winners winners = new Winners();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.addWinner(car);
            }
        }
        return winners;
    }

    private Position maxPosition() {
        Position maxPosition = new Position();
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }
}
