package racing.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racing.domain.movestrategies.RandomMoveStrategy;

public class RacingGame {

    private final Map<String, Queue<Integer>> results = new HashMap<>();
    private List<Car> cars = new ArrayList<>();
    private int tries;

    public RacingGame(List<String> names, int tries) {
        this.cars = createCars(names);
        this.tries = tries;
    }

    public void doRaces() {
        IntStream.range(0, tries)
            .forEach(i -> doRace());
    }

    private void doRace() {
        cars.stream()
            .forEach(car -> car.move());
    }

    protected List<Car> createCars(List<String> namesOfCars) {
        namesOfCars.forEach(name -> cars.add(new Car(new RandomMoveStrategy(), name)));
        return cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getTries() {
        return tries;
    }

    public List<String> getWinnerNames() {
        int biggestPosition = getBiggestPosition();
        return cars.stream()
            .filter(car -> car.isPositioned(biggestPosition))
            .map(Car::getName)
            .collect(Collectors.toList());
    }

    private int getBiggestPosition() {
        return cars.stream()
            .mapToInt(Car::getPosition)
            .max()
            .getAsInt();
    }

    public Map<String, Queue<Integer>> getResults() {
        cars.stream()
            .forEach(car -> this.results.put(car.getName(), car.getRecords()));
        return results;
    }
}
