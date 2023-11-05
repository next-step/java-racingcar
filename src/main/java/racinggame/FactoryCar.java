package racinggame;

import racinggame.domain.Car;
import racinggame.domain.GenerateNumber;
import racinggame.domain.Name;

import java.util.List;
import java.util.stream.Collectors;

public class FactoryCar {

    public List<Car> generateCar(List<String> carNames, GenerateNumber generateNumber) {
        return carNames.stream()
                .map(carName -> new Car(new Name(carName), generateNumber))
                .collect(Collectors.toList());
    }

}
