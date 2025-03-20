package racinggame;

import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private CarFactory() {

    }

    public static List<Car> createCars(List<String> carNames, MoveStrategy moveStrategy) {
        return carNames.stream()
            .map(name -> new Car(name, moveStrategy))
            .collect(Collectors.toList());
    }

}
