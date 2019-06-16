package step2.racing.dto;

import step2.racing.model.Car;

import java.util.Map;
import java.util.stream.Collectors;

public class CarPosition {

    private Map<Integer, Integer> carNumberPositions;

    public static CarPosition of(EntireCars entireCars) {

        CarPosition carPosition = new CarPosition();
        carPosition.carNumberPositions = entireCars.stream()
                .collect(Collectors.toMap(Car::getUniqueNumber, Car::getPosition, (car1, car2) -> car1));

        return carPosition;
    }

    public int getPosition(int carNumber) {

        return carNumberPositions.get(carNumber);
    }

    public int sizeOfCars() {

        return carNumberPositions.keySet().size();
    }

}
