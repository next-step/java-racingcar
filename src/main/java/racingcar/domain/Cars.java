package racingcar.domain;

import java.util.*;

public class Cars {
    private static final String NAME_DELIMITER = ",";

    private final List<Car> cars;

    public Cars(String carsNames) {
        this(makeRacingCars(carsNames));
    }

    // 주생성자
    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCarsByStrategy(MoveStrategy moveStrategy) {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public Map<String, Integer> showCarsPositions() {
        Map<String, Integer> carsPositions = new HashMap<>();
        for (Car car : cars) {
            carsPositions.putAll(car.showCurrentPosition());
        }
        return carsPositions;
    }

    private static List<Car> makeRacingCars(String carsNames) {
        String[] names = carsNames.split(NAME_DELIMITER);
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }
        return cars;
    }
}
