package racing.model;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class TurnSnapshot implements Iterable<CarSnapshot> {

    private final List<CarSnapshot> cars;

    public TurnSnapshot(List<CarSnapshot> cars) {
        this.cars = cars;
    }

    public List<CarSnapshot> getCarPositions() {
        return cars;
    }

    private int findMaxPosition() {
        int maxPosition = 0;
        for (CarSnapshot car : cars) {
            maxPosition = car.max(maxPosition);
        }
        return maxPosition;
    }

    public List<String> findMaxPositionCarNames() {
        int maxPosition = findMaxPosition();
        List<CarSnapshot> winners = findCarsAtPositions(maxPosition);
        return winners
                .stream()
                .map(CarSnapshot::getName)
                .collect(Collectors.toList());
    }

    private List<CarSnapshot> findCarsAtPositions(int targetPosition) {
        return this.cars
                .stream()
                .filter(car -> car.isPosition(new CarPosition(targetPosition)))
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<CarSnapshot> iterator() {
        return Collections.unmodifiableList(cars).iterator();
    }
}
