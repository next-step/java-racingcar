package racing.refactor.domain;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class CarRacingGame {

    private final List<Car> cars;
    private static final int ZERO = 0;

    public CarRacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        int topTravelDistance = topScore();
        return cars.stream()
                .filter(car -> car.equalsDistance(topTravelDistance))
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    private int topScore() {
        return displayTrack().stream()
                .map(Car::getDrivingDistance)
                .max(naturalOrder())
                .orElse(ZERO);
    }

    public List<Car> nextRound(List<Integer> diceNumbers) {
        for (int i = ZERO; i < cars.size(); i++) {
            Car car = cars.get(i);
            int diceNumber = diceNumbers.get(i);
            car.moveOrStop(diceNumber);
        }
        return displayTrack();
    }

    private List<Car> displayTrack() {
        return cars;
    }
}
