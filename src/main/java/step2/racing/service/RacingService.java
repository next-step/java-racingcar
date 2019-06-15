package step2.racing.service;

import step2.racing.dto.RacingResult;
import step2.racing.model.Car;
import step2.racing.random.RandomGenerator;
import step2.racing.random.RealRandomGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingService {

    private int raceCount = 0;

    private final int carCount;
    private final int attempts;
    private final RandomGenerator randomGenerator;

    private static final int RANDOM_NUMBER_BOUND = 10;

    public RacingService(int carCount, int attempts) {

        this.carCount = carCount;
        this.attempts = attempts;
        this.randomGenerator = new RealRandomGenerator(RANDOM_NUMBER_BOUND);
    }

    public RacingService(int carCount, int attempts, RandomGenerator randomGenerator) {

        this.carCount = carCount;
        this.attempts = attempts;
        this.randomGenerator = randomGenerator;
    }

    public RacingResult run() {

        List<Car> cars = createCars(carCount);

        RacingResult racingResult = new RacingResult();
        racingResult.addCarPosition(cars);

        while (!isFinished(attempts)) {
            raceEntireCars(cars);
            racingResult.addCarPosition(cars);
        }

        return racingResult;
    }

    private List<Car> createCars(int carCount) {

        return IntStream.range(0, carCount)
                .mapToObj(Car::of)
                .collect(Collectors.toList());
    }

    private boolean isFinished(int attempts) {

        return raceCount >= attempts;
    }

    private void raceEntireCars(List<Car> cars) {

        cars.forEach(car -> car.race(randomGenerator.getRandomIntValue()));
        raceCount++;
    }
}
