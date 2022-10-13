package step3_pobi.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;
    private int tryNo;

    private MovingStrategy movingStrategy;

    public RacingGame(String carsNames, int tryNo, MovingStrategy movingStrategy) {
        this.cars = initCars(carsNames);
        this.tryNo = tryNo;
        this.movingStrategy = movingStrategy;
    }

    private static List<Car> initCars(String carsNames) {
        if (StringUtils.isBlank(carsNames)) {
            throw new IllegalArgumentException("자동차 이름은 존재해야 합니다.");
        }
        String[] names = carsNames.split(",");
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
        for (Car car : cars) {
            car.move(movingStrategy);
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
