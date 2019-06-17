package racing.dto;

import racing.model.Car;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class RacingPosition {

    private Map<String, Integer> carNamePositions;

    public static RacingPosition of(EntireCars entireCars) {

        RacingPosition racingPosition = new RacingPosition();
        racingPosition.carNamePositions = entireCars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition, (car1, car2) -> car1));

        return racingPosition;
    }

    public int getPosition(String carName) {

        return carNamePositions.get(carName);
    }

    // TODO
    public Set<Map.Entry<String, Integer>> entrySet() {

        return carNamePositions.entrySet();
    }

}
