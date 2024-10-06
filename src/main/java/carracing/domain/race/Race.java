package carracing.domain.race;

import carracing.domain.car.Car;
import carracing.domain.car.Name;
import carracing.domain.random.RandomNumberGenerator;
import carracing.domain.record.RoundRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final int totalRoundNumber;
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<RoundRecord> roundRecords = new ArrayList<>();

    private List<Car> cars = new ArrayList<>();

    private Race(List<Car> cars, int rounds, RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.totalRoundNumber = rounds;
        this.cars.addAll(cars);
    }

    public static Race of(List<String> carNames, int rounds, RandomNumberGenerator randomNumberGenerator) {
        List<Car> cars = createCars(carNames);
        return new Race(cars, rounds, randomNumberGenerator);
    }

    public List<RoundRecord> start() {
        recordRound();

        for (int i = 0; i < totalRoundNumber; i++) {
            moveCars();
            recordRound();
        }

        return roundRecords;
    }

    public List<Car> getWinners() {
        RoundRecord lastRound = roundRecords.get(roundRecords.size() - 1);
        return lastRound.getLeadingCar();
    }

    public List<Car> getCars() {
        return cars;
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> Car.from(Name.from(name)))
                .collect(Collectors.toUnmodifiableList());
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
