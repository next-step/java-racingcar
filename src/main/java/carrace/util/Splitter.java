package carrace.util;

import carrace.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class Splitter {

    private static final int MAX_LENGTH = 5;

    public List<Car> splitCarNames(String carNames) {
        List<String> carNamesList = List.of(carNames.split("[,]"));

        for (String carName : carNamesList) {
            isMoreThanMAXLENGTH(carName);
        }

        return carNamesList.stream()
                .map(this::createCar)
                .collect(Collectors.toList());
    }

    private void isMoreThanMAXLENGTH(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new RuntimeException("자동차 이름은 최대 5자까지 허용됩니다.");
        }
    }

    private Car createCar(String carName) {
        return new Car(carName);
    }
}
