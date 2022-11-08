package racingcar.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(String[] carNames) {
        this.carList = generateCarList(carNames);
    }

    private List<Car> generateCarList(String[] cars) {
        return Arrays.stream(cars)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public List<String> getWinners() {
        Comparator<Car> comparator = Comparator.comparingInt(Car::getDistance);
        Car max = carList.stream().max(comparator).get();
        return carList.stream()
                .filter(c -> c.getDistance() == max.getDistance())
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
