package racinggame.service;

import racinggame.domain.Car;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class WinnerDecisionService {

    public List<Car> getWinnerList(List<Car> carList) {
        int maximumPosition = getMaximumPosition(carList);

        return carList.stream()
                        .filter(c -> c.getPosition() == maximumPosition)
                        .collect(toList());
    }

    int getMaximumPosition(List<Car> carList) {
        return carList.stream()
                        .mapToInt(Car::getPosition)
                        .max()
                        .orElse(Car.INITIAL_POSITION);
    }
}
