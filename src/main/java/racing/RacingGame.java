package racing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racing.movestrategies.RandomMoveStrategy;

class RacingGame {

    private List<Car> cars = new ArrayList<>();
    private int tries;

    RacingGame(List<String> names, int tries) {
        this.cars = createCars(names);
        this.tries = tries;
    }

    void doRaces() {
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

    List<Car> getCars() {
        return cars;
    }

    int getTries() {
        return tries;
    }

    List<String> getWinnerNames() {
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
}
