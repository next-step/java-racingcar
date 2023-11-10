package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String DELIMITER = ",";
    private final List<Car> cars;

    public Cars(String carName) {
        cars = new ArrayList<>();
        initCars(carName);
    }

    private void initCars(String carNames) {
        String[] carName = nameSplit(carNames);
        for (int i = 0; i < carName.length; i++) {
            checkNameLength(carName[i]);
            addCar(new Car(carName[i]));
        }
    }

    private String[] nameSplit(String carsName) {
        String[] carNames = carsName.split(DELIMITER);
        return carNames;
    }

    private void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> carList() {
        return cars;
    }

    public List<String> maxPositionCars() {
        return cars.stream()
                .filter(car -> car.matchPosition(maxPosition()))
                .map(car -> car.carName())
                .collect(Collectors.toList());
    }

    private int maxPosition() {
        return cars.stream()
                .mapToInt(Car::forwardCnt)
                .max()
                .getAsInt();
    }

    private void checkNameLength(String carName) {
        if (carName.length() > 5) {
            throw new RuntimeException("자동차 이름은 5자를 초과할 수 없다.");
        }
    }
}
