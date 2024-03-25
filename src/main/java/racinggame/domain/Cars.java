package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    private static final int MAX_BOUND = 10;

    private final List<Car> cars;

    public Cars(String carNames) {
        this(initCars(carNames));
    }

    private static List<Car> initCars(String carNames) {
        if (StringUtils.isBlank(carNames)) {
            throw new IllegalArgumentException("자동차 이름은 값이 존재해야 합니다.");
        }
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        Random random = new Random();
        for (Car car : cars) {
            car.move(random.nextInt(MAX_BOUND));
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> findWinners() {
        return findWinners(maxPosition());
    }

    private List<Car> findWinners(CarNumber maxPosition) {
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isMatch(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private CarNumber maxPosition() {
        CarNumber maxPosition = new CarNumber();
        for (Car car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }
}
