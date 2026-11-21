package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> cars;
    private final int rounds;
    private final NumberGenerator numberGenerator;
    private final List<RoundResult> roundResults;
    private boolean played;

    public Race(List<String> carNames, int rounds, NumberGenerator numberGenerator) {
        if (rounds < 0) {
            throw new IllegalArgumentException("rounds can not be negative value");
        }
        this.cars = createCars(carNames);
        this.rounds = rounds;
        this.numberGenerator = numberGenerator;
        this.roundResults = new ArrayList<>();
        this.played = false;
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<RoundResult> getRoundResults() {
        return roundResults;
    }

    public void play() {
        if (played) {
            throw new IllegalStateException("cannot play again");
        }
        for (int i = 0; i < rounds; i++) {
            roundResults.add(playRound());
        }
        played = true;
    }

    private RoundResult playRound() {
        List<CarStatus> carStatuses = new ArrayList<>();
        for (Car car : cars) {
            car.move(numberGenerator.generate());
            carStatuses.add(car.toCarStatus());
        }
        return new RoundResult(carStatuses);
    }
}
