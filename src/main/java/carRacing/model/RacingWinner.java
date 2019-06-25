package carRacing.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {

    public static RacingCars pickOutWinners(RacingCars racingCars, int bestPosition) {
        List<Car> cars = racingCars.getRacingCars().stream()
                .filter(car -> car.isWinner(bestPosition))
                .collect(Collectors.toList());
        return new RacingCars(cars);
    }
}
