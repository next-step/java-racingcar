package carrace;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRace {
    private final Cars cars;
    private final int numberOfLaps;
    private final List<Cars> results;
    private final Movable movable;

    public CarRace(Cars cars, int numberOfLaps, Movable movable) {
        this.cars = cars;
        this.numberOfLaps = numberOfLaps;
        this.movable = movable;
        this.results = new ArrayList<>();
    }

    public void start() {
        for (int i = 0; i < numberOfLaps; i++) {
            cars.move(movable);
            results.add(cars.copy());
        }
    }

    public List<Cars> getResults() {
        return new ArrayList<>(results);
    }

    public List<String> getWinners() {
        final int maxPosition = getMaxPosition();
        return IntStream.range(0, cars.size())
                .filter(index -> cars.getPosition(index) == maxPosition)
                .mapToObj(cars::getCarName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return cars.getPositions()
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }
}
