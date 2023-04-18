package step5.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> carList = new ArrayList<>();

    public void addCar(Car newCar) {
        carList.add(newCar);
    }

    public List<String> race() {
        return carList.stream()
                .map(Car::race)
                .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        return carList.stream()
                .filter(car -> car.getNowPosition().length() == getMaxPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(car -> car.getNowPosition().length())
                .max()
                .orElseThrow();
    }

}
