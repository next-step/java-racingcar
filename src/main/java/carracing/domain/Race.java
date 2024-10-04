package carracing.domain;

import carracing.domain.random.RandomNumberGenerator;
import carracing.domain.record.RoundRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private List<Car> cars = new ArrayList<>();
    private final int rounds;
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<RoundRecord> roundRecords = new ArrayList<>();

    private Race(List<Car> cars, int rounds, RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.rounds = rounds;
        this.cars.addAll(cars);
    }

    public static Race of(List<String> carNames, int rounds, RandomNumberGenerator randomNumberGenerator) {
        List<Car> cars = createCars(carNames);
        return new Race(cars, rounds, randomNumberGenerator);
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::from)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<RoundRecord> start() {
        recordRound();

        for (int i = 0; i < rounds; i++) {
            moveCars();
            recordRound();
        }

        return roundRecords;
    }

    public List<Car> getCars() {
        return cars;
    }

    private void recordRound() {
        roundRecords.add(RoundRecord.from(cars));
    }

    private void moveCars() {
        cars = cars.stream()
                .map(car -> {
                    int randomDistance = randomNumberGenerator.generate();
                    return car.move(randomDistance);
                }).collect(Collectors.toUnmodifiableList());
    }

}
