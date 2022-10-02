package domain;

import static java.lang.Math.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private int max_dist = 0;
    private final List<Car> carList;

    public Cars(String[] carNames) {
        this.carList = createInitCarList(carNames);
    }

    public List<Car> createInitCarList(String[] carNames) {
        return Arrays.stream(carNames)
            .map(Car::createCarWithName)
            .collect(Collectors.toList());
    }

    public List<String> findWinner() {
        findMaxDist();
        return carList.stream()
            .filter(it -> it.getCurrentLocation() == max_dist)
            .map(Car::getCarName)
            .collect(Collectors.toList());
    }

    private void findMaxDist() {
        for (Car car : carList) {
            max_dist = max(car.getCurrentLocation(), max_dist);
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

}
