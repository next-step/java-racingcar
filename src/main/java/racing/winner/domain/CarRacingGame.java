package racing.winner.domain;

import java.util.Collections;
import java.util.List;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class CarRacingGame {

    private final List<Car> cars;

    public CarRacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getWinners() {
        int topTravelDistance = topScore();
        return cars.stream()
                .filter(car -> topTravelDistance <= car.getDrivingDistance())
                .collect(collectingAndThen(toList(), Collections::unmodifiableList));
    }

    private int topScore() {
        return displayTrack().stream()
                .map(Car::getDrivingDistance)
                .max(naturalOrder())
                .orElse(0);
    }

    public List<Car> nextRound(List<Integer> diceNumbers) {
        for (int i = 0; i < cars.size(); i++) {
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
