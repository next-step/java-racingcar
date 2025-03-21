package racing.model;

import java.util.List;
import java.util.stream.Collectors;

public class CarsAtTurn {

    private final List<FixedCar> cars;

    public CarsAtTurn(List<FixedCar> cars) {
        this.cars = cars;
    }

    public List<FixedCar> getCarPositions() {
        return cars;
    }

    public String getCarName(int index) {
        return cars.get(index).getName();
    }

    public int getCarPosition(int index) {
        return cars.get(index).getPosition();
    }

    public int getCarSize() {
        return cars.size();
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (FixedCar car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    public List<String> findMaxPositionCarNames() {
        int maxPosition = findMaxPosition();
        List<FixedCar> winners = findCarsAtPositions(maxPosition);
        return winners
                .stream()
                .map(FixedCar::getName)
                .collect(Collectors.toList());
    }

    private List<FixedCar> findCarsAtPositions(int targetPosition) {
        return this.cars
                .stream()
                .filter(car -> car.isPosition(targetPosition))
                .collect(Collectors.toList());
    }
}
