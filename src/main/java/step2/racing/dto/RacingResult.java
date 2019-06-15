package step2.racing.dto;

import step2.racing.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingResult {

    private List<CarPosition> carPositions = new ArrayList<>();

    public CarPosition getCarPosition(int raceCount) {

        return carPositions.get(raceCount);
    }

    public void addCarPosition(List<Car> cars) {

        CarPosition carPosition = new CarPosition(cars.stream()
                                .collect(Collectors.toMap(Car::getUniqueNumber, Car::getPosition)));

        carPositions.add(carPosition);
    }

    public int length() {

        return carPositions.size();
    }

}
