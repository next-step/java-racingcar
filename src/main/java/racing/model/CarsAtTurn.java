package racing.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class CarsAtTurn implements Iterable<FixedCar> {

    private final List<FixedCar> cars;

    public CarsAtTurn(List<FixedCar> cars) {
        this.cars = cars;
    }

    public List<FixedCar> getCarPositions() {
        return cars;
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
                .filter(car -> car.isPosition(new CarPosition(targetPosition)))
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<FixedCar> iterator() {
        return Collections.unmodifiableList(cars).iterator();
    }
}
