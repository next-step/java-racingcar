package racingcar.domain.game;

import racingcar.domain.model.Car;
import racingcar.domain.model.Cars;

import java.util.*;
import java.util.stream.Collectors;

public class WinnerGetter {

    private int getMaxPosition(List<Car> carList){
        return Collections.max(
                carList.stream()
                        .map(car -> car.getPosition())
                        .collect(Collectors.toList()));
    }

    public List<Car> getWinnerCars(Cars cars){
        int maxPosition = getMaxPosition(cars.getCarList());
        return Collections.unmodifiableList(
                cars.getCarList().stream()
                        .filter(car -> car.getPosition() == maxPosition)
                        .collect(Collectors.toList()));
    }
}