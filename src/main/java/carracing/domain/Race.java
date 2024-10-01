package carracing.domain;

import carracing.domain.random.RandomNumberGenerator;
import carracing.domain.record.CarRecord;
import carracing.domain.record.RoundRecord;
import carracing.domain.record.RoundRecords;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars = new ArrayList<>();
    private final List<RoundRecord> roundRecords = new ArrayList<>();
    private final int rounds;
    private final RandomNumberGenerator randomNumberGenerator;


    private Race(List<Car> cars, int rounds, RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.rounds = rounds;
        this.cars.addAll(cars);
    }

    public static Race of(List<String> carNames, int rounds, RandomNumberGenerator randomNumberGenerator) {
        List<Car> cars = carNames.stream()
                .map(Car::from)
                .collect(Collectors.toUnmodifiableList());
        return new Race(cars, rounds, randomNumberGenerator);
    }

    public RoundRecords start() {
        recordRound();

        for (int i = 0; i < rounds; i++) {
            moveCars();
            recordRound();
        }
        return RoundRecords.from(roundRecords);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void recordRound() {
        List<CarRecord> roundResult = cars.stream()
                .map(CarRecord::of)
                .collect(Collectors.toUnmodifiableList());
        roundRecords.add(RoundRecord.from(roundResult));
    }

    private void moveCars() {
        cars.forEach(car -> {
            int randomDistance = randomNumberGenerator.generate();
            car.move(randomDistance);
        });
    }


}
