package racingcar.game;

import racingcar.domain.Car;

import java.util.*;
import java.util.stream.Collectors;

public class WinnerGetter {

    private int getMaxPosition(List<Car> carList){
        return Collections.max(
                carList.stream()
                        .map(car -> car.getPosition())
                        .collect(Collectors.toList()));
    }

    public List<Car> getWinnerCars(List<Car> carList){
        int maxPosition = getMaxPosition(carList);
        return Collections.unmodifiableList(
                carList.stream()
                        .filter(car -> car.getPosition() == maxPosition)
                        .collect(Collectors.toList()));
    }
}