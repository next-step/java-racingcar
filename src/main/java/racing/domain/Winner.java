package racing.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    public static List<String> award(RacingCars racingCars) {
        int farthestPosition = racingCars.getFarthestPosition();
        return racingCars.getCars().stream()
                .filter(car -> farthestPosition == car.getPosition())
                .map(Car::getName)
                .collect(Collectors.toList());
    }

}
