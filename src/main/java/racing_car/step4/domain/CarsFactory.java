package racing_car.step4.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarsFactory {
    private static final int POSITION_RESET_NUMBER = 0;
    
    public static List<Car> from(int numberOfCars) {
        return IntStream.range(0, numberOfCars)
                .mapToObj(count -> new Car(new Position(POSITION_RESET_NUMBER)))
                .collect(Collectors.toList());
    }
}
