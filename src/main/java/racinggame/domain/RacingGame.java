package racinggame.domain;

import racinggame.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private int tryNo;

    public RacingGame(String carNames, int tryNo) {
        this(createCars(carNames), tryNo);
    }

    public RacingGame(List<Car> cars, int tryNo) {
        this.cars = cars;
        this.tryNo = tryNo;
    }

    private static List<Car> createCars(String carNames) {
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
        if (!racing()) {
            throw new IllegalStateException("게임이 종료되었습니다.");
        }
        this.tryNo--;
        moveCars();
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public boolean racing() {
        return this.tryNo > 0;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public Winners getWinners() {
        return Winners.findWinners(this.cars);
    }

    @Override
    public String toString() {
        return "RacingGame{" +
                "cars=" + cars +
                ", tryNo=" + tryNo +
                '}';
    }
}
