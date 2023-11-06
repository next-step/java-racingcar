package racinggame.factory;

import racinggame.domain.Car;
import racinggame.strategy.MoveStrategy;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    public List<Car> generateCar(List<String> carNames, MoveStrategy moveStrategy) {
        return carNames.stream()
                .map(carName -> new Car(carName, moveStrategy))
                .collect(Collectors.toList());
    }

}
