package racing.dto;

import racing.model.Car;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CarPosition {

    private Map<String, Integer> carNamePositions;

    public static CarPosition of(EntireCars entireCars) {

        CarPosition carPosition = new CarPosition();
        carPosition.carNamePositions = entireCars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition, (car1, car2) -> car1));

        return carPosition;
    }

    public int getPosition(String carName) {

        return carNamePositions.get(carName);
    }

    public Set<Map.Entry<String, Integer>> entrySet() {

        return carNamePositions.entrySet();
    }

}
