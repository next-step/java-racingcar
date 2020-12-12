package carrace.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public static List<Car> makeCarList(int carCount) {
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < carCount; i++) {
            carList.add(new Car());
        }

        return carList;
    }

    public static List<Car> makeCarList(List<CarName> carNames) {
        if (carNames == null) {
           throw new IllegalArgumentException();
        }
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
