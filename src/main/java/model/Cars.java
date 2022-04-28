package model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public void moveCars(MoveRule moveRule) {
        for (Car car : cars) {
            car.move(moveRule);
        }
    }

    public List<CarName> getWinnerCarNames() {
        List<Car> winnerCars = WinnerCars.getWinnerCars(this.cars);
        return winnerCars.stream()
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public Map<CarName, Integer> getMoveHistories() {
        Map<CarName, Integer> moveHistories = new HashMap<>();
        for (Car car : this.cars) {
            moveHistories.put(car.getCarName(), car.getPosition().getPosition());
        }
        return moveHistories;
    }

}
