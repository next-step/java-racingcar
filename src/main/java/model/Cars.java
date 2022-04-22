package model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private static final String CAR_NAME_DELIMITER = ",";

    private final List<Car> cars;

    public Cars(String carNames) {
        this.cars = toCarList(carNames);
    }

    private List<Car> toCarList(String carNames) {
        List<CarName> carNameList = makeCarNameList(carNames);
        return carNameList.stream().map(Car::new).collect(Collectors.toList());
    }

    private List<CarName> makeCarNameList(String carNames) {
        return Arrays.stream(carNames.split(CAR_NAME_DELIMITER)).map(CarName::new).collect(Collectors.toList());
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move(new RandomMoveRule());
        }
    }
}
