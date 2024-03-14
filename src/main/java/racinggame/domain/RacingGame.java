package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private static final int MAX_BOUND = 10;

    private final List<Car> cars;

    private int tryNo;

    public RacingGame(String carNames, int tryNo) {
        this.cars = initCars(carNames);
        this.tryNo = tryNo;
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

    public void race() {
        this.tryNo--;
        moveCars();
    }

    private void moveCars() {
        Random random = new Random();
        for (Car car : cars) {
            car.move(random.nextInt(MAX_BOUND));
        }
    }

    public boolean racing() {
        return this.tryNo > 0;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public List<Car> getWinners() {
        return null;
    }
}
