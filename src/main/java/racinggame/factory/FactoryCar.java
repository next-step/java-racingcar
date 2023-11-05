package racinggame.factory;

import racinggame.domain.Car;
import racinggame.domain.Name;
import racinggame.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class FactoryCar {

    public List<Car> generateCar(List<String> carNames, MoveStrategy moveStrategy) {
        return carNames.stream()
                .map(carName -> new Car(new Name(carName), moveStrategy))
                .collect(Collectors.toList());
    }

}
