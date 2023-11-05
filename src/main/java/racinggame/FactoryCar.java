package racinggame;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FactoryCar {

    private static final int DEFAULT_CAR_POSITION = 0;

    public List<Car> generateCar(int carSize, GenerateNumber generateNumber) {
        return Stream.generate(() -> new Car(generateNumber))
                .limit(carSize)
                .collect(Collectors.toList());
    }

}
