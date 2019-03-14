package racinggame.service;

import racinggame.Car;

import java.util.List;

import static java.util.stream.Collectors.*;

public class WinnerDecisionService {

    List<Car> carList;

    public WinnerDecisionService(List<Car> carList) {
        this.carList = carList;
    }

    public List<Car> getWinners() {
        int maximumPosition = getMaximumPosition();

        return carList.stream()
                .filter(c -> c.getPosition() == maximumPosition)
                .collect(toList());

    }

    private int getMaximumPosition() {
        return carList.stream()
                    .mapToInt(Car::getPosition)
                    .max()
                    .orElse(-1);
    }
}